package Chapter3;

public class OrderedLinkedListSequentilSearchST<Key extends Comparable<Key>,Value> implements
        IOrderKeyST<Key,Value> {
    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    private Node first;
    @Override
    public Key min() {
        if(first==null){
            return null;
        }
        return first.key;
    }

    @Override
    public Key max() {
        Node dummpyNode=new Node(null,null,first);
        Node last=dummpyNode;
        while (last.next!=null){
            last=last.next;
        }
        return last.key;
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
        Node x=first;
        for (int i=0; i <k ; ++i) {
            if(x!=null){
                x=x.next;
            }else return null;
        }
        return x.key;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public void put(Key key, Value val) {
        Node dummpyNode=new Node(null,null,first);
        Node x=first;
        while (x!=null){
            if(x.key.compareTo(key)==0){
                x.val=val;
                return;
            }
            x=x.next;
        }
        x=dummpyNode;
        while (x.next!=null){
            if(x.next.key.compareTo(key)<0){
                x=x.next;
            }
        }
        Node temp=new Node(key,val,null);
        temp.next=x.next;
        x.next=x;

        first=dummpyNode.next;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public int size() {
        int N=0;
        Node x=first;
        while (x!=null){
            x=x.next;
            N++;
        }
        return N;
    }
}
