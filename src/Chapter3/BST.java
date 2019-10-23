package Chapter3;

public class BST<Key extends Comparable<Key>,Value> implements IOrderKeyST<Key,Value> {
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
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public void put(Key key, Value val) {
        root=put(root,key,val);
    }

    private Node put(Node node, Key key, Value val) {
        if(node==null)return new Node(key,val,1);
        int cmp=key.compareTo(node.key);
        if(cmp>0)node.right=put(node.right,key,val);
        else if(cmp<0)node.left=put(node.left,key,val);
        else node.val=val;
        node.N=1+size(node.left)+size(node.right);
        return node;
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
    public void delete(Key key) {

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
