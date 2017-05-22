package data.structure.queue;

import data.structure.LinkedFather;
import data.structure.Node;

/**
 * 先进先出队列
 * 使用链表实现
 * @author 鱼唇的人类
 * @date 2017/5/21
 * @time 13:41
 */
public class Queue<T> extends LinkedFather<T> {
    private Node<T> last;
    public void enQueue(T t){
        Node<T> oldLast=last;
        last=new Node();
        last.item=t;
        last.next=null;
        if (isEmpty())first=last;
        else oldLast.next=last;
        size++;
    }
    public T deQueue(){
        T t=first.item;
        first= first.next;
        size--;
        return t;
    }
}
