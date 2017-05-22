package data.structure.stack;

import data.structure.LinkedFather;
import data.structure.Node;

/**
 * 下压堆栈
 * 使用链表实现(后进先出)
 * @author 鱼唇的人类
 * @date 2017/5/21
 * @time 13:33
 */
public class Stack<T> extends LinkedFather<T> {
    public void push(T t){
        Node<T> oldFirst=first;
        first=new Node();
        first.item=t;
        first.next=oldFirst;
        size++;
    }
    public T pop(){
        T t=first.item;
        first=first.next;
        size--;
        return t;
    }
}
