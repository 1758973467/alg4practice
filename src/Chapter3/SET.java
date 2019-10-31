package Chapter3;

import java.util.Iterator;

/**
 * 有序的集合，采用IOrderedST
 * @param <Key>
 */
public class SET<Key extends Comparable<Key>>implements ISET<Key> {
    private IOrderKeyST<Key,Integer> st=new RedBlackBST<>();
    @Override
    public void add(Key key) {
        st.put(key,1);
    }

    @Override
    public void delete(Key key) {
        st.delete(key);
    }

    @Override
    public boolean contains(Key key) {
        return st.contains(key);
    }

    @Override
    public int size() {
        return st.size();
    }

    /*other API*/

    public Key max(){
        return st.max();
    }

    public Key min(){
        return st.min();
    }

    public int rank(Key key){
        return st.rank(key);
    }

    public int size(Key lo,Key hi){
        return st.size(lo,hi);
    }

    public Iterable<Key> keys(Key lo,Key hi){
        return st.keys(lo,hi);
    }

    @Override
    public Iterator<Key> iterator() {
        return st.keys(min(),max()).iterator();
    }
}
