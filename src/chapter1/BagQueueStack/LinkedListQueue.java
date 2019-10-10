package chapter1.BagQueueStack;

import java.util.Iterator;

public class LinkedListQueue<Item> implements Queue<Item> {
    private Node first=null;
    private Node last=null;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    @Override
    public void enqueue(Item item) {
        Node oldLast=last;
        last=new Node();
        last.next=null;
        last.item=item;
        if(isEmpty()){
            first=last;
        }else{
            oldLast.next=last;
        }
        N++;

    }

    @Override
    public Item dequeue() {
        Node oldFirst=first;
        first=first.next;
        if(isEmpty()){
            last=null;
        }
        N--;
        return oldFirst.item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new NormalLinkedListIterator();
    }
    private class NormalLinkedListIterator implements Iterator<Item> {
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
