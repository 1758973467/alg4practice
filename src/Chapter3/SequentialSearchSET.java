package Chapter3;

public class SequentialSearchSET<Key> implements ISET<Key> {
    private Node first;//链表首节点
    private class Node{
        Key key;

        Node next;

        public Node(Key key,  Node next) {
            this.key = key;
            this.next = next;
        }
    }

    @Override
    public void add(Key key) {
        if(contains(key))return;
        first=new Node(key,first);
    }



    @Override
    public void delete(Key key) {
        Node dummpyNode=new Node(null,first);
        for (Node x=dummpyNode;x.next!=null;x=x.next) {
            if(x.next.key.equals(key)){
                break;
            }
        }
        first=dummpyNode.next;
    }

    @Override
    public boolean contains(Key key) {
        for (Node current=first; current!=null ; current=current.next) {
            if(current.key.equals(key)){
                return true;
            }
        }
        return false;
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

}
