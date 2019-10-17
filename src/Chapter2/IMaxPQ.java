package Chapter2;

public interface IMaxPQ<Key extends Comparable<Key>> {
    Key deleteMax();
    void insert(Key key);
    int size();
    boolean isEmpty();
    Key max();
}
