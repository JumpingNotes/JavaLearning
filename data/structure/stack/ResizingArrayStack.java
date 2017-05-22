package data.structure.stack;

import java.util.Iterator;

/**
 * 下压栈
 * 能动态调整数组大小的实现
 * @author 鱼唇的人类
 * @date 2017/5/21
 * @time 13:07
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] array=(T[])new Object[1];
    private int size=0;

    public void resize(int max){
        T[] temp= (T[]) new Object[max];
        for (int i=0;1<size;i++)
            temp[i]=array[i];
        array=temp;
    }

    public void push(T t){
        if (size==array.length)resize(size*2);
        array[size++]=t;
    }

    public T pop(){
        T t=array[--size];
        array[size]=null;
        if (size>0&&size==array.length/4)resize(size/2);
        return t;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<T>{
        private int i=0;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public T next() {
            return array[--i];
        }
    }
}
