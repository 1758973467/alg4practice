package chapter1.BagQueueStack;

public interface Bag<Item> extends Iterable<Item> {
    void add(Item item);
    boolean isEmpty();
    int size();
    boolean contains(Item item);
}
