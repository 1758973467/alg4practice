package Chapter3;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

import java.util.Iterator;

/**
 * min,max,
 * get,
 * floor,ceiling,rank,select,,put非递归
 *
 *
 * @param <Key>
 * @param <Value>
 */
public class BSTNoRecursion<Key extends Comparable<Key>,Value>implements IOrderKeyST<Key,Value>{
    private class Node{
        Key key;
        Value val;
        int N;//结点总数
        Node left,right;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }
    private Node root;
    @Override
    public Key min() {
        if(root==null) return null;
        Node x=root;
        while (x.left!=null){
            x=x.left;
        }
        return x.key;
    }

    @Override
    public Key max() {
        if(root==null) return null;
        Node x=root;
        while (x.right!=null){
            x=x.right;
        }
        return x.key;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        Node x=root;
        while (x!=null){
            int t=size(x.left)+1;
            if(t>k){
                x=x.left;
            }else if(t<k){
                x=x.right;
            }else break;
        }
        if(x==null)return null;
        return x.key;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> keyQueue=new LinkedListQueue<>();
        keys(lo,hi,keyQueue,root);
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return keyQueue.iterator();
            }
        };
    }
    private void keys(Key lo, Key hi, Queue<Key> keyQueue, Node node) {
        if(node==null)return ;
        if(node.key.compareTo(lo)>=0&&node.key.compareTo(hi)<=0){
            keyQueue.enqueue(node.key);
        }else if(node.key.compareTo(lo)<0){
            keys(lo,hi,keyQueue,node.right);
        }else if(node.key.compareTo(hi)>0){
            keys(lo,hi,keyQueue,node.left);
        }
    }

    @Override
    public void put(Key key, Value val) {

    }

    @Override
    public Value get(Key key) {
        Node x=root;
        while (x!=null){
            int cmp=key.compareTo(x.key);
            if(cmp>0){
                x=x.right;
            }else if(cmp<0){
                x=x.left;
            }else return x.val;
        }
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if(node==null)return 0;
        else return 1+size(node.right)+size(node.left);
    }
}
