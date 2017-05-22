package multi.thread;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的简单使用
 * @author 鱼唇的人类
 * @date 2017/5/20
 * @time 22:28
 */
public class ExecutorsMain {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool= Executors.newFixedThreadPool(3);
        int []timeSpans={1,2,4,7,9,3,6,8,12,5,23,15};
        System.out.println("理论使用时间："+Arrays.stream(timeSpans).sum()+"ms");
        for (int i = 0; i < timeSpans.length; i++) {
            final int timeSpan= timeSpans[i];
            threadPool.execute(() -> {
                try {
                    Thread.sleep(timeSpan);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"-时间长度:"+timeSpan);
            });
        }
    }
}
