package chapter1.BagQueueStack;

public interface Stack<Item> extends Iterable<Item> {
    void push(Item item);
    Item pop();
    boolean isEmpty();
    int size();
    Item peek();
}
