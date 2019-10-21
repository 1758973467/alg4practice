package Chapter3;

import java.util.Iterator;

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
        Node dummpyNode=new Node(null,null,first);
        Node x=dummpyNode;
        while (x.next!=null){
            if(x.next.key.compareTo(key)<=0){
                x=x.next;
            }else break;
        }
        if(first==null){
            return null;
        }
        //全部小于
        if(x==null){
            return max();
        }else return x.key;

    }

    @Override
    public Key ceiling(Key key) {
        Node x=first;

        while (x!=null){
            if(x.key.compareTo(key)>=0){
                break;
            }
            x=x.next;

        }
        if(first==null){
            return null;
        }
        //全部小于key
        if(x==null){
            return max();
        }else return x.key;
    }

    @Override
    public int rank(Key key) {
        Node x=first;
        int count=0;
        while (x!=null){
            if(x.key.compareTo(key)<0){
                count++;
                x=x.next;
            }else break;
        }
        return count;
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
        Node loNode=first;
        while (loNode!=null){
            if(loNode.key.compareTo(lo)<0){
                loNode=loNode.next;
            }else break;
        }
        Node hiNode=first;
        while (hiNode!=null){
            if(hiNode.key.compareTo(lo)<0){
                hiNode=hiNode.next;
            }else break;
        }

        Node finalLoNode = loNode;
        Node finalHiNode = hiNode;
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    private Node lowNode= finalLoNode;
                    private Node highNode= finalHiNode;
                    @Override
                    public boolean hasNext() {
                        return lowNode !=null&& lowNode !=highNode;
                    }

                    @Override
                    public Key next() {
                        Key key=lowNode.key;
                        lowNode=lowNode.next;
                        return key;
                    }
                };
            }
        };
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
        x.next=temp;

        first=dummpyNode.next;
    }

    @Override
    public Value get(Key key) {
        Node x=first;
        while (x!=null){
            if(x.key.compareTo(key)==0){
               return x.val;
            }
            x=x.next;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        Node dummpyNode=new Node(null,null,first);
        Node x=dummpyNode;
        while (x.next!=null){
            if(x.next.key.compareTo(key)==0){
                x.next=x.next.next;
                break;
            }
            x=x.next;
        }
        first=dummpyNode.next;
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
