package chapter1.BagQueueStack;

import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Queue<Item> {
    private Item[]a=(Item[]) new Object[1];
    private int N=0;

    private void resize(int max) {
        Item[]temp=(Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i]=a[i];
        }
        a=temp;
    }

    @Override
    public void enqueue(Item item) {
        if(N==a.length){
            resize(N*2);
        }
        a[N++]=item;

    }

    @Override
    public Item dequeue() {
        Item item=a[0];
        a[0]=null;
        for (int i = 0; i < N-1; i++) {
            a[i]=a[i+1];
        }
        if(N>0&&N==a.length/4){
            resize(N/4);
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
    public Iterator<Item> iterator() {
        return new NormalArrayIterator();
    }

    private class NormalArrayIterator implements Iterator<Item> {
        private int i=0;
        private int count=N;
        @Override
        public boolean hasNext() {
            return i<N;
        }

        @Override
        public Item next() {
            return a[i++];
        }
    }
}
