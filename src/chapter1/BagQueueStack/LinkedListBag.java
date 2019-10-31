package chapter1.BagQueueStack;

import java.util.Iterator;

public class LinkedListBag<Item> implements Bag<Item> {
    private Node first=null;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    @Override
    public void add(Item item) {
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
        N++;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean contains(Item item) {
        for (Node curNode=first; curNode!=null ;curNode=curNode.next) {
            if(curNode.item.equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
