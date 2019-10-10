package chapter1.BagQueueStack;

import java.util.Iterator;

public class LinkedListStack<Item> implements Stack<Item> {
    private Node first=null;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    @Override
    public void push(Item item) {
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
        N++;
    }

    @Override
    public Item pop() {
        Item item=first.item;
        first=first.next;
        N--;
        return item;
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
    public Item peek() {
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseLinkedListIterator();
    }
    private class ReverseLinkedListIterator implements Iterator<Item> {
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
