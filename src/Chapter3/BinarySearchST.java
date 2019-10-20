package Chapter3;

public class BinarySearchST<Key extends Comparable<Key>,Value> implements IOrderKeyST<Key,Value> {
    private Key[]keys;
    private Value[]vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys=(Key[])new Comparable[capacity];
        vals=(Value[])new Object[capacity];

    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N-1];
    }

    @Override
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

    @Override
    public Key ceiling(Key key) {
        int i=rank(key);
        if(i>=N){
            return keys[N-1];
        }
        return keys[i];
    }

    @Override
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

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public void put(Key key, Value val) {
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0){
            vals[i]=val;
            return;
        }
        for (int j = N; j >i ; --j) {
            keys[j]=keys[j-1];
            vals[j]=vals[j-1];
        }
        keys[i]=key;
        vals[i]=val;
        N++;
    }

    @Override
    public Value get(Key key) {
        if(isEmpty())return null;
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0)return vals[i];
        else return null;
    }

    @Override
    public void delete(Key key) {
        int i=rank(key);
        if(i<N&&keys[i].compareTo(key)==0){
            for (int j = i; j+1 <N ; j++) {
                keys[j]=keys[j+1];
                vals[j]=vals[j+1];
            }
            N--;
        }
    }

    @Override
    public int size() {
        return N;
    }
}
