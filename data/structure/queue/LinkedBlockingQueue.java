package data.structure.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc: 线程安全的队列，阻塞
 * @author: 鱼唇的人类
 * @see Queue
 * @date: 2017/8/17 12:03
 */
public class LinkedBlockingQueue<E>{
    private final Queue<E> queue=new Queue<>();
    private final int length;
    private final AtomicInteger count=new AtomicInteger();
    private final ReentrantLock putLock=new ReentrantLock();
    private final Condition putCondition=putLock.newCondition();
    private final ReentrantLock takeLock=new ReentrantLock();
    private final Condition takeCondition=takeLock.newCondition();

    public LinkedBlockingQueue(int length) {
        this.length = length;
    }

    public boolean offer(E e){
        if (e==null) {
            throw new NullPointerException("element not allow null");
        }
        final ReentrantLock lock=this.putLock;
        lock.lock();
        try {
            if (count.get()<length){
                queue.enQueue(e);
                count.addAndGet(1);
                return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }
}
