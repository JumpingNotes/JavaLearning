package multi.thread.fork;

import java.util.concurrent.*;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/12/13 13:51
 */
public class ForkJoinTest extends RecursiveTask<Integer> {
    private int start;
    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static final int THRESHOLD =75;

    @Override
    protected Integer compute() {
        int sum = 0;
        System.out.println("run：start="+start+",end="+end);
        // 如果任务足够小, 就直接执行
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
                try {
                    System.out.println("sleep：start="+start+",end="+end);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else {
            //任务大于阈值, 分裂为2个任务
            int middle = (start + end) / 2;
            ForkJoinTest countTask1 = new ForkJoinTest(start, middle);
            ForkJoinTest countTask2 = new ForkJoinTest(middle + 1, end);
            // 开启线程
            invokeAll(countTask1, countTask2);
            Integer join1 = countTask1.join();
            Integer join2 = countTask2.join();
            // 结果合并
            sum = join1 + join2;
        }
        return sum;
    }


    // 测试
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        ForkJoinTest countTask = new ForkJoinTest(1, 1000);
        ForkJoinTask<Integer> result = forkJoinPool.submit(countTask);
        System.out.println(result.get()+",time="+(System.currentTimeMillis()-start));
    }
}
