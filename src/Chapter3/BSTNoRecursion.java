package Chapter3;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

/**
 * min,max,
 * get,
 * rank,select,put,floor,ceiling非递归
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
        Node curNode=root,preNode=null;
        while (curNode!=null){
            int cmp=key.compareTo(curNode.key);
            //key大于,可能存在
            if(cmp>0){
                preNode=curNode;
                curNode=curNode.right;
                //小于一定在左子树
            }else if(cmp<0){
                curNode=curNode.left;
            }else break;
        }
        if(curNode==null){
            if(preNode==null){
                return null;
            }else return preNode.key;
        }else return curNode.key;
    }

    @Override
    public Key ceiling(Key key) {
        Node curNode=root,preNode=null;
        while (curNode!=null){
            int cmp=key.compareTo(curNode.key);
            //key大于,可能存在
            if(cmp>0){
                curNode=curNode.right;
                //小于一定在左子树
            }else if(cmp<0){
                preNode=curNode;
                curNode=curNode.left;
            }else break;
        }
        if(curNode==null){
            if(preNode==null){
                return null;
            }else return preNode.key;
        }else return curNode.key;
    }

    @Override
    public int rank(Key key) {
        int i=0;
        Node x=root;
        while (x!=null){
            int cmp=key.compareTo(x.key);
            if(cmp>0){
                i+=1+size(x.left);
                x=x.right;
            }else if(cmp<0){
                i+=0;
                x=x.left;
            }else {
                i+=size(x.left);
                break;
            }
        }
        return i;
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
        Node node=root;
        while (node!=null){
            if(node.key.compareTo(lo)>=0&&node.key.compareTo(hi)<=0){
                keyQueue.enqueue(node.key);
            }else if(node.key.compareTo(lo)<0){
                node=node.right;
            }else if(node.key.compareTo(hi)>0){
               node=node.left;
            }
        }
        return () -> keyQueue.iterator();
    }


    @Override
    public void put(Key key, Value val) {
        Node z = new Node(key, val,1);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = z;
        else         parent.right = z;
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
        if(root==null)return;
        root=delete(root,key);
    }

    private Node delete(Node node, Key key) {
        if(node==null)return null;
        int cmp=key.compareTo(node.key);
        if(cmp<0){
            node.left=delete(node.left,key);
        }else if(cmp>0){
            node.right=delete(node.right,key);
        }else{
            //found node
            if(node.left==null)return node.right;
            if(node.right==null)return node.left;
            Node x=node.right;
            while (x.left!=null){
                x=x.left;
            }
            x.left=node.left;
            x.right=deleteMin(node.right);
        }

        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    private Node deleteMin(Node node) {
        if(node==null)return null;
        if(node.left!=null)node.left=deleteMin(node.left);
        else{
            return node.right;
        }
        node.N=1+size(node.left)+size(node.right);
        return node;
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
