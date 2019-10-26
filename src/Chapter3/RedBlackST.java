package Chapter3;

import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

import java.util.Iterator;

public class RedBlackST<Key extends Comparable<Key>,Value>
        implements IOrderKeyST<Key,Value> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private class Node{
        Key key;
        Value val;
        Node left,right;
        int N;//这颗子树的结点总数
        boolean color;//由其父节点指向它的链接的颜色

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x==null)return false;
        return x.color==RED;
    }

    /**
     * 左旋
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }

    /**
     * 右旋
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right);
        return x;
    }
    private Node root;
    @Override
    public Key min() {
        if(root==null)return null;
        return min(root).key;
    }

    private Node min(Node node) {
        if(node.left!=null)return min(node.left);
        return node;
    }

    @Override
    public Key max() {
        if(root==null)return null;
        return max(root).key;
    }

    private Node max(Node node) {
        if(node.right==null)return node;
        else return max(node.right);
    }


    @Override
    public Key floor(Key key) {
        Node x=floor(root,key);
        if(x!=null){
            return x.key;
        }
        return null;
    }

    private Node floor(Node node, Key key) {
        if(node==null){
            return null;
        }
        int cmp=key.compareTo(node.key);
        //小于一定在左子树
        if(cmp<0){
            return floor(node.left,key);
        }else if(cmp>0){
            //key大于,可能存在
            var x=floor(node.right,key);
            if(x!=null){
                return x;
            }
        }
        return node;
    }

    @Override
    public Key ceiling(Key key) {
        Node x=ceiling(root,key);
        if(x==null){
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node node, Key key) {
        if(node==null)return null;
        int cmp=key.compareTo(node.key);
        if(cmp>0)return ceiling(node.right,key);
        else if(cmp<0){
            Node x=ceiling(node.left,key);
            if(x!=null){
                return x;
            }
        }
        return node;
    }
    @Override
    public int rank(Key key) {
        if(root==null)return 0;
        return rank(root,key);
    }

    private int rank(Node node, Key key) {
        if(node==null)return 0;
        int cmp=key.compareTo(node.key);
        if(cmp<0){
            return rank(node.left,key);
        }else if(cmp>0){
            return 1+size(node.left)+rank(node.right,key);
        }else{
            return size(node.left);
        }
    }

    @Override
    public Key select(int k) {
        if(root==null)return null;
        Node x=select(root,k);
        return x.key;
    }

    private Node select(Node node, int k) {
        if(node==null)return null;
        int t=size(node.left)+1;
        if(t==k){
            return node;
        }else if(t>k){
            return select(node.left,k);
        }else {
            return select(node.right,k-t);
        }
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
        root=put(root,key,val);
        root.color=BLACK;
    }
    
    private Node put(Node node, Key key, Value val) {
        if(node==null)return new Node(key,val,1,RED);
        int cmp=key.compareTo(node.key);
        if(cmp<0)node.left=put(node.left,key,val);
        else if(cmp>0)node.right=put(node.right,key,val);
        else node.val=val;
        
        if(isRed(node.right)&&!isRed(node.left))node=rotateLeft(node);
        if(isRed(node.left)&&isRed(node.left.left))node=rotateRight(node);
        if(isRed(node.left)&&isRed(node.right))flipColors(node);
        node.N=size(node.left)+size(node.right)+1;
        return node;
            
    }

    private void flipColors(Node node) {
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
    }

    @Override
    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node node, Key key) {
        if(node==null)return null;
        int cmp=key.compareTo(node.key);
        if(cmp>0)return get(node.right,key);
        else if(cmp<0)return get(node.left,key);
        else return node.val;
    }

    @Override
    public void deleteMin() {
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color=RED;
        }
        root=deleteMin(root);
        if(!isEmpty())root.color=BLACK;
    }

    private Node deleteMin(Node node) {
        if(node.left==null)
            return null;
        if(!isRed(node.left)&& !isRed(node.left.left)){
            node=moveRedLeft(node);
        }
        node.left=deleteMin(node.left);
        return balance(node);
    }

    private Node balance(Node node) {
        if(isRed(node.right))
            node=rotateLeft(node);

        if(isRed(node.right)&&!isRed(node.left))node=rotateLeft(node);
        if(isRed(node.left)&&isRed(node.left.left))node=rotateRight(node);
        if(isRed(node.left)&&isRed(node.right))flipColors(node);
        node.N=size(node.left)+size(node.right)+1;
        return node;
    }

    private Node moveRedLeft(Node node) {
        //flipColors
        // 假设结点node color=RED node.left.color=BLACK node.left.left.color=BLACK
        //将node.left.color=RED或者node.left.left.color=RED
        node.left.color=RED;
        if(isRed(node.right.left)){
            node.right=rotateRight(node.right);
            node=rotateLeft(node);
        }
        return node;
    }

    @Override
    public void deleteMax() {
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color=RED;
        }
        root=deleteMax(root);
        if(!isEmpty())root.color=BLACK;
    }

    private Node deleteMax(Node node) {
        if(isRed(node.left)){
            node=rotateRight(node);
        }
        if(node.right==null)
            return null;
        if(!isRed(node.right)&&!isRed(node.right.left)){
            node=moveRedRight(node);
        }
        node.right=deleteMax(node.right);
        return balance(node);
    }

    private Node moveRedRight(Node node) {
        //flipColors
        // 假设结点node color=RED node.right.color=BLACK node.right.left.color=BLACK
        //将node.right.color=RED或者node.right.left.color=RED
        node.right.color=RED;
        if(isRed(node.right.left)){
            node.right=rotateRight(node.right);
            node=rotateLeft(node);
        }
        return node;
    }

    @Override
    public void delete(Key key) {
        if(!isRed(root.left)&&!isRed(root.right)){
            root.color=RED;
        }
        root=delete(root,key);
        if(!isEmpty())root.color=BLACK;
    }

    private Node delete(Node node, Key key) {
        if(key.compareTo(node.key)<0){
            if(!isRed(node.left)&&!isRed(node.left.left)){
                node=moveRedLeft(node);
            }
            node.left=delete(node.left,key);
        }else {
            if(isRed(node.left)){
                node=rotateRight(node);
            }
            if(key.compareTo(node.key)==0&&node.right==null){
                return null;
            }
            if(!isRed(node.right)&&!isRed(node.right.left)){
                node=rotateRight(node);
            }
            if(key.compareTo(node.key)==0){
                node.val=get(node.right,min(node.right).key);
                node.key=min(node.right).key;
                node.right=deleteMin(node.right);
            }else{
                node.right=delete(node.right,key);
            }
        }
        return balance(node);
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if(node==null) return 0;
        else return 1+size(node.right)+size(node.left);
    }
}
