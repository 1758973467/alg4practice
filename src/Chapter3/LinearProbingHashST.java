package Chapter3;

import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.ResizingArrayQueue;

import java.util.Objects;

/**
 * 线性探测的符号表
 *
 */
public class LinearProbingHashST<Key,Value> implements IST<Key,Value> {
    private int N;//符号表键值对的总数
    private int M=16;//线性探测表大小
    private Key[]keys;//键
    private Value[]vals;//值

    public LinearProbingHashST() {
        this(16);
    }

    public LinearProbingHashST(int size) {
        keys=(Key[]) new Object[size];
        vals=(Value[]) new Object[size];
        M=size;
    }
    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }

    @Override
    public void put(Key key, Value val) {
        if(N>=M*3/4)resize(2*M);
        int i=hash(key);
        for (; keys[i]!=null; i=(i+1)%M) {
            if(keys[i].equals(key)){
                vals[i]=val;
                return;
            }
        }
        keys[i]=key;
        vals[i]=val;
        N++;
    }

    @Override
    public Value get(Key key) {

        for (int i = hash(key); keys[i]!=null; i=(i+1)%M) {
            if(keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if(!contains(key))return;
        int i=hash(key);
        while (!key.equals(keys[i])){
            i=(i+1)%M;
        }

        keys[i]=null;
        vals[i]=null;
        i=(i+1)%M;
        while (keys[i]!=null){
            Key keyToReDo=keys[i];
            Value valToReDo=vals[i];
            keys[i]=null;
            vals[i]=null;
            N--;
            put(keyToReDo,valToReDo);
            i=(i+1)%M;
        }
        N--;
        if(N>0&&N==M/8)resize(M/2);
    }

    private void resize(int cap) {
        LinearProbingHashST<Key,Value>newST=new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if(keys[i]!=null){
                newST.put(keys[i],vals[i]);
            }
        }
        keys=newST.keys;
        vals= newST.vals;
        M=newST.M;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> keyQueue=new ResizingArrayQueue<>();
        for (var k:keys){
            if(k!=null){
                keyQueue.enqueue(k);
            }
        }
        return ()->keyQueue.iterator();
    }
}
