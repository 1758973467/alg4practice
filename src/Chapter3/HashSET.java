package Chapter3;

import java.util.Iterator;

/**
 * 无序的集合，采用hash
 * @param <Key>
 */
public class HashSET<Key> implements ISET<Key> {

    private LinearProbingHashST<Key,Integer> st=new LinearProbingHashST<>(3);
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


    @Override
    public Iterator<Key> iterator() {
        return st.keys().iterator();
    }
}
