package chapter1.BagQueueStack;

import java.util.Arrays;
import java.util.Iterator;

public class ResizingArrayStack<Item> implements Stack<Item>  {
    private Item[]a=(Item[])new Object[1];
    private int N=0;

    @Override
    public void push(Item item) {
        if(N==a.length){
            resize(N*2);
        }
        a[N++]=item;
    }

    private void resize(int max) {
        Item[]temp=(Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i]=a[i];
        }
        a=temp;
    }

    @Override
    public Item pop() {
        Item item=a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4){
            resize(a.length/4);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Item peek() {
        Item item= a[--N];
        N++;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public String toString() {
        return "ResizingArrayStack{" +
                "Content=" + Arrays.toString(a) +
                ", Size=" + N +
                '}';
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
