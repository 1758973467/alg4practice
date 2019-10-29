package Chapter3;

import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.ResizingArrayQueue;

import java.util.Iterator;

/**
 * 拉链法散列表
 */
public class SeparateChainingHashST<Key,Value> implements IST<Key,Value> {
    private int N;//键值对总数
    private int M;//散列表大小
    private SequentialSearchST<Key,Value>[]st;//存放链表对象的数组


    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M=M;
        st=(SequentialSearchST<Key,Value>[])new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i]=new SequentialSearchST<>();
        }
    }

    private int hash(Key key){
        //将符号位屏蔽，防止取余得到负数
        return (key.hashCode()&0x7fffffff)%M;
    }

    @Override
    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
        N++;
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void delete(Key key) {
        if(st[hash(key)].contains(key)){
            st[hash(key)].delete(key);
            N--;
        }
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> keyQueue=new ResizingArrayQueue<>();
        for (var oneST:st){
            for (var k:oneST.keys()){
                keyQueue.enqueue(k);
            }
        }

        return () -> keyQueue.iterator();
    }
}
