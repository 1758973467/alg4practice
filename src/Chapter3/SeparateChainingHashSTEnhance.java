package Chapter3;

import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.ResizingArrayQueue;

/**
 * 拉链法散列表-不依赖SequentialSearchST
 */
public class SeparateChainingHashSTEnhance<Key,Value> implements IST<Key,Value> {
    private int N;//键值对总数
    private int M;//散列表大小

    private Node[] firsts;//链表首节点
    private class Node{
        Key key;
        Value val;
        Node next;
        int count;//插入该键值对时散列表元素的数量
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeparateChainingHashSTEnhance() {
        this(997);
    }

    public SeparateChainingHashSTEnhance(int M) {
        this.M=M;
        firsts=(Node[])new Object[M];
    }

    private int hash(Key key){
        //将符号位屏蔽，防止取余得到负数
        return (key.hashCode()&0x7fffffff)%M;
    }

    @Override
    public void put(Key key, Value val) {
        for (Node current=firsts[hash(key)]; current!=null ; current=current.next) {
            if(current.key.equals(key)){
                current.val=val;
                return;
            }
        }
        firsts[hash(key)]=new Node(key,val,firsts[hash(key)]);
        N++;
    }

    @Override
    public Value get(Key key) {
        for(Node x=firsts[hash(key)];x!=null;x=x.next){
            if(x.key.equals(key)){
                return x.val;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if(!contains(key))return;
        Node dummpyNode=new Node(null,null,firsts[hash(key)]);
        for (Node x=dummpyNode;x.next!=null;x=x.next) {
            if(x.next.key.equals(key)){
                x.next=x.next.next;
                break;
            }
        }
        firsts[hash(key)]=dummpyNode.next;
    }


    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> keyQueue=new ResizingArrayQueue<>();
        for (var first:firsts){
            for (Node current=first; current!=null ; current=current.next) {
                keyQueue.enqueue(current.key);
            }
        }
        return () -> keyQueue.iterator();
    }
}
