package Chapter3;

import java.util.Iterator;

public class SequentialSearchST<Key,Value> implements IST<Key,Value> {
    private Node first;//链表首节点
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

    @Override
    public void put(Key key, Value val) {
        for (Node current=first; current!=null ; current=current.next) {
            if(current.key.equals(key)){
                current.val=val;
                return;
            }
        }
        first=new Node(key,val,first);
    }

    @Override
    public Value get(Key key) {
        for(Node x=first;x!=null;x=x.next){
            if(x.key.equals(key)){
                return x.val;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        Node dummpyNode=new Node(null,null,first);
        for (Node x=dummpyNode;x.next!=null;x=x.next) {
            if(x.next.key.equals(key)){
                x.next=x.next.next;
                break;
            }
        }
        first=dummpyNode.next;
    }

    @Override
    public int size() {
        int N=0;
        for(Node x=first;x!=null;x=x.next,++N){
        }
        return N;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new LinkedListIterator();
            }
        };
    }
    private class LinkedListIterator implements Iterator<Key> {
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Key next() {
            Key item=current.key;
            current=current.next;
            return item;
        }
    }
}
