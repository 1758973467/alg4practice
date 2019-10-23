package Chapter3;

import java.util.Iterator;

public class BinarySearchST<Key extends Comparable<Key>,Value> implements IOrderKeyST<Key,Value> {
    private KeyValuePair<Key,Value>[]keyvalpairs;
    private int N;

    public BinarySearchST(int capacity) {
        keyvalpairs=(KeyValuePair<Key,Value>[])new KeyValuePair[capacity];
        for (int i = 0; i < capacity; i++) {
            keyvalpairs[i]=new KeyValuePair();
        }
    }

    public BinarySearchST(KeyValuePair<Key,Value>[]items) {
        keyvalpairs=(KeyValuePair<Key,Value>[])new KeyValuePair[items.length];
        for (int i = 0; i < items.length; i++) {
            keyvalpairs[i]=new KeyValuePair();
        }
        for (var item :items){
            put(item.getKey(),item.getValue());
        }
    }

    @Override
    public Key min() {
        return keyvalpairs[0].getKey();
    }

    @Override
    public Key max() {
        return keyvalpairs[N-1].getKey();
    }

    @Override
    public Key floor(Key key) {
        int i=rank(key);
        if(i==0){
            return null;
        }
        if(i==N-1&&keyvalpairs[N-1].getKey().compareTo(key)<0){
            return keyvalpairs[N-1].getKey();
        }
        return keyvalpairs[i-1].getKey();
    }

    @Override
    public Key ceiling(Key key) {
        int i=rank(key);
        if(i>=N){
            return null;
        }
        return keyvalpairs[i].getKey();
    }

    @Override
    public int rank(Key key) {
        int lo=0,hi=N-1;
        while (lo<=hi){
            int mid=(lo+hi)/2;
            int cmp=keyvalpairs[mid].getKey().compareTo(key);
            if(cmp>0)hi=mid-1;
            else if(cmp<0)lo=mid+1;
            else return mid;
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        return keyvalpairs[k].getKey();
    }

    @Override
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
                        Key key=keyvalpairs[current++].getKey();
                        return key;
                    }

                };
            }
        };
    }

    @Override
    public void put(Key key, Value val) {
        int i=rank(key);
        if(i<N&&keyvalpairs[i].getKey().compareTo(key)==0){
            keyvalpairs[i].setValue(val);
            return;
        }
        for (int j = N; j >i ; --j) {
            keyvalpairs[j].setKey(keyvalpairs[j-1].getKey());
            keyvalpairs[j].setValue(keyvalpairs[j-1].getValue());
        }
        keyvalpairs[i].setKey(key);
        keyvalpairs[i].setValue(val);
        N++;
    }

    @Override
    public Value get(Key key) {
        if(isEmpty())return null;
        int i=rank(key);
        if(i<N&&keyvalpairs[i].getKey().compareTo(key)==0)return keyvalpairs[i].getValue();
        else return null;
    }

    @Override
    public void delete(Key key) {
        int i=rank(key);
        if(i<N&&keyvalpairs[i].getKey().compareTo(key)==0){
            for (int j = i; j+1 <N ; j++) {
                keyvalpairs[j].setKey(keyvalpairs[j+1].getKey());
                keyvalpairs[j].setValue(keyvalpairs[j+1].getValue());
            }
            N--;
        }
    }

    @Override
    public int size() {
        return N;
    }
}
