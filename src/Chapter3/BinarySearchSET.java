package Chapter3;

import java.util.Iterator;

public class BinarySearchSET<Key extends Comparable<Key>> implements ISET<Key> {
    private Key[]keys;
    private int N;

    public BinarySearchSET(int capacity) {
        keys=(Key[])new Object[capacity];
    }

    public BinarySearchSET(Key[]items) {
        keys=(Key[])new Object[items.length];
        for (var item :items){
            add(item);
        }
    }


    public Key min() {
        return keys[0];
    }


    public Key max() {
        return keys[N-1];
    }


    public Key floor(Key key) {
        int i=rank(key);
        if(i==0){
            return null;
        }
        if(i==N-1&&keys[N-1].compareTo(key)<0){
            return keys[N-1];
        }
        return keys[i-1];
    }


    public Key ceiling(Key key) {
        int i=rank(key);
        if(i>=N){
            return null;
        }
        return keys[i];
    }


    public int rank(Key key) {
        int lo=0,hi=N-1;
        while (lo<=hi){
            int mid=(lo+hi)/2;
            int cmp=keys[mid].compareTo(key);
            if(cmp>0)hi=mid-1;
            else if(cmp<0)lo=mid+1;
            else return mid;
        }
        return lo;
    }


    public Key select(int k) {
        return keys[k];
    }


    public Iterable<Key> keys(Key lo, Key hi) {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    private int loIndex=rank(lo);
                    private int highIndex=rank(hi);
                    private int current=loIndex;

                    @Override
                    public boolean hasNext() {
                        return current<highIndex;
                    }

                    @Override
                    public Key next() {
                        Key key=keys[current++];
                        return key;
                    }

                };
            }
        };
    }

    @Override
    public void add(Key key) {
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0){
            return;
        }
        for (int j = N; j >i ; --j) {
            keys[j]=keys[j-1];
        }
        keys[i]=key;
        N++;
    }

    @Override
    public boolean contains(Key key) {
        if(isEmpty())return false;
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0)return true;
        else return false;
    }

    @Override
    public void delete(Key key) {
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0){
            for (int j = i; j+1 <N ; j++) {
                keys[j]=keys[j+1];
            }
            N--;
        }
    }

    @Override
    public int size() {
        return N;
    }
}
