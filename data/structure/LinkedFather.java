package data.structure;

import java.util.Iterator;

/**
 * @author 鱼唇的人类
 * @date 2017/5/21
 * @time 13:56
 */
public class LinkedFather<T> implements Iterable<T>  {
    protected Node<T> first;
    protected int size;

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node<T> current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }
        @Override
        public T next() {
            T t=current.item;
            current=current.next;
            return t;
        }
    }
}
