package com.beppe.kafka.statemachine.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author beppe
 * @date 2020/4/13
 * @description: RabbitMq 配置类
 */
@Slf4j
@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String address;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(address + ":" + port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(publisherConfirms);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(confirmCallback());
        rabbitTemplate.setReturnCallback(returnCallback());
        return rabbitTemplate;
    }

    //----------------------点对点 direct 模式------------------------------------------------

    /**
     * 查看 Queue 的构造方法  有五个参数
     * name 队列名
     * durable 是否是持久化队列（服务器重启不会消失）默认为true
     * exclusive 普通队列允许的消费者没有限制，多个消费者绑定到多个队列时，RabbitMQ 会采用轮询进行投递。如果需要消费者独占队列，在队列创建的时候，设定属性 exclusive 为 true。
     * autoDelete 是否自动删除
     * map 参数传递
     */

    @Bean
    public Queue crawlerToLdos() {
        return new Queue("beppe");
    }


    /**
     * 生产者发送确认
     */
    @Bean
    public RabbitTemplate.ConfirmCallback confirmCallback() {
        return new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    log.info("发送者发送mq成功");
                } else {
                    log.error("发送者发送mq失败，原因如下：" + cause);
                }
            }
        };
    }

    /**
     * 发送者失败通知  主要是 路由失败
     */
    @Bean
    public RabbitTemplate.ReturnCallback returnCallback() {
        return new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.error("发送者路由失败，请检查路由");
                log.error("Returned replyCode" + replyCode);
                log.error("Returned replyText" + replyText);
                log.error("Returned routingKey" + routingKey);
                String msgJson = new String(message.getBody());
                log.error("Returned message " + msgJson);
            }
        };
    }


//    @Bean("batchQueueTaskScheduler")
//    public TaskScheduler batchQueueTaskScheduler() {
//        TaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        return taskScheduler;
//    }


//    //批量处理rabbitTemplate
//    @Bean("batchQueueRabbitTemplate")
//    public BatchingRabbitTemplate batchQueueRabbitTemplate(ConnectionFactory connectionFactory,
//                                                           @Qualifier("batchQueueTaskScheduler") TaskScheduler taskScheduler) {
//        //!!!重点： 所谓批量， 就是spring 将多条message重新组成一条message, 发送到mq, 从mq接受到这条message后，在重新解析成多条message
//        //一次批量的数量
//        int batchSize = 10;
//        // 缓存大小限制,单位字节，
//        // simpleBatchingStrategy的策略，是判断message数量是否超过batchSize限制或者message的大小是否超过缓存限制，
//        // 缓存限制，主要用于限制"组装后的一条消息的大小"
//        // 如果主要通过数量来做批量("打包"成一条消息), 缓存设置大点
//        // 详细逻辑请看simpleBatchingStrategy#addToBatch()
//        int bufferLimit = 1024; //1 K
//        long timeout = 10000;
//        //注意，该策略只支持一个 exchange/routingKey
//        //A simple batching strategy that supports only one exchange/routingKey
//        BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(batchSize, bufferLimit, timeout);
//        return new BatchingRabbitTemplate(batchingStrategy, taskScheduler);
//    }
}
