package com.beppe.statemachine;

import com.beppe.statemachine.enumerate.OrderEvents;
import com.beppe.statemachine.enumerate.OrderStates;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.guard.Guard;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
//@EnableStateMachineFactory
public class OrderStateMachineBuilder {

    private final static String MACHINEID = "orderMachine";

    /**
     * 构建状态机
     *
     * @param beanFactory
     * @return
     * @throws Exception
     */
    public StateMachine<OrderStates, OrderEvents> build(BeanFactory beanFactory) throws Exception {
        StateMachineBuilder.Builder<OrderStates, OrderEvents> builder = StateMachineBuilder.builder();

        System.out.println("构建订单状态机");

        builder.configureConfiguration()
                .withConfiguration()
                .machineId(MACHINEID)
//                .stateDoActionPolicy(StateDoActionPolicy.IMMEDIATE_CANCEL)
//                .stateDoActionPolicy(StateDoActionPolicy.TIMEOUT_CANCEL)
//                .stateDoActionPolicyTimeout(10, TimeUnit.SECONDS)
                .beanFactory(beanFactory);

        builder.configureStates()
                .withStates()
                .initial(OrderStates.UNPROCESSED)
                .state(OrderStates.IN_PROCESS, enterAction(), outAction())
                .states(EnumSet.allOf(OrderStates.class));

        builder.configureTransitions()
                .withExternal()
                .source(OrderStates.UNPROCESSED)
                .target(OrderStates.IN_PROCESS)
                .event(OrderEvents.DO_PROCESS)
                .guard(toWaitBorrowGuard())
                .and()
                .withExternal()
                .source(OrderStates.IN_PROCESS)
                .target(OrderStates.PASS_PROCESS)
                .event(OrderEvents.DO_PASS)
                .action(action(), errorAction());

        return builder.build();
    }

    @Bean
    public Action<OrderStates, OrderEvents> enterAction() {
        return new Action<OrderStates, OrderEvents>() {

            @Override
            public void execute(StateContext<OrderStates, OrderEvents> context) {
                System.out.println("执行 enterAction 的context" + context);
            }
        };
    }

    public Action<OrderStates, OrderEvents> outAction() {
        return new Action<OrderStates, OrderEvents>() {
            @Override
            public void execute(StateContext<OrderStates, OrderEvents> stateContext) {
                System.out.println("执行 outAction 的context" + stateContext);
            }
        };
    }

    /**
     * 状态机错误执行 ？？？ 貌似现在还没找到
     *
     * @return
     */
    public Action<OrderStates, OrderEvents> errorAction() {
        return new Action<OrderStates, OrderEvents>() {
            @Override
            public void execute(StateContext<OrderStates, OrderEvents> stateContext) {
                System.out.println("执行 errorAction 的context" + stateContext);
                Exception exception = stateContext.getException();
                exception.getMessage();
            }
        };
    }

    public Action<OrderStates, OrderEvents> action() {
        return new Action<OrderStates, OrderEvents>() {
            @Override
            public void execute(StateContext<OrderStates, OrderEvents> stateContext) {
                System.out.println("执行 action 的context" + stateContext);
//                throw new RuntimeException("MyError");
            }
        };
    }

    private Guard<OrderStates, OrderEvents> toWaitBorrowGuard() {
        return context -> {
            // 返回FALSE 则不会执行 action 和 状态转换
            // 这里可以拿到参数进行判断 是否要进行 状态转换
            return true;
        };
    }
}