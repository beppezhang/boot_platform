package com.beppe.kafka.concurrent;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * 并发变成   future 框架
 */
public class FutureDemo {

    @Test
    public void test1() throws InterruptedException, ExecutionException {
        TimeInterval timer = DateUtil.timer();
//        List<ServerTask> serverTasks = new ArrayList<>() ;
//        for (int i=0;i<3;i++){
//            serverTasks.add(new ServerTask("beppe"+i));
//        }
        List<FutureTask> list = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            FutureTask futureTask = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("this is:"+"calling");
                    Thread.sleep(2000);
                    return "beppe";
                }
            });
            list.add(futureTask);
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < list.size(); i++) {
            FutureTask task=list.get(i);
            executor.execute(task);
        }
        for (int i = 0; i < 3; i++) {
            FutureTask task=list.get(i);
            task.get();
        }


//        executor.execute(futureTask);
//        // 任务信息获取
//        System.out.println("是否完成："+futureTask.isDone());
//        System.out.println("是否取消："+futureTask.isCancelled());
////        System.out.println("获取结果："+futureTask.get());
////        System.out.println("尝试取消："+futureTask.cancel(Boolean.TRUE));
        System.out.println("timer...interval = "+timer.interval());

    }
}
