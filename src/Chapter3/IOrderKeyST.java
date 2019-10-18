package Chapter3;

/**
 * 有序泛型符号表API
 * @param <Key>
 * @param <Value>
 */
public interface IOrderKeyST<Key extends Comparable<Key>,Value> extends IST<Key,Value> {
    /**
     * 最小的键
     * @return
     */
    Key min();

    /**
     * 最大的键
     * @return
     */
    Key max();

    /**
     * 小于等于key的最大键
     * @param key
     * @return
     */
    Key floor(Key key);

    /**
     * 大于等于key的最小键
    * @param key
     * @return
     */
    Key ceiling(Key key);

    /**
     * 小于Key的键的数量
     * @param key
     * @return
     */
    int rank(Key key);

    /**
     * 排名为k的键
     * @param k
     * @return
     */
    Key select(int k);

    /**
     * 删除最小键
     */
    default void deleteMin(){
        delete(min());
    }

    /**
     * 删除最大键
     */
    default void deleteMax(){
        delete(max());
    }

    /**
     * [lo..hi]之间的键的数量
     * @param lo
     * @param hi
     * @return
     */
    default int size(Key lo,Key hi){
        if(hi.compareTo(lo)<0){
            return 0;
        }else if(contains(hi)){
            return rank(hi)-rank(lo)+1;
        }else
            return rank(hi)-rank(lo);
    }

    /**
     * [lo..hi]之间的所有键，已排序
     * @param lo
     * @param hi
     * @return
     */
    Iterable<Key> keys(Key lo,Key hi);

    default Iterable<Key> keys(){
        return keys(min(),max());
    }
}
