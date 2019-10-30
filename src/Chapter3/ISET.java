package Chapter3;

/**
 * 集合数据类型
 * @param <Key>
 */
public interface ISET<Key> {
    /**
     * 键Key加入集合
     * @param key
     */
    void add(Key key);

    /**
     * 从集合中删除key
     * @param key
     */
    void delete(Key key);

    /**
     * 键key是否在集合中
     * @param key
     * @return
     */
    boolean contains(Key key);

    /**
     * 集合中键的数量
     * @return
     */
    int size();

    /**
     * 对象的字符串表示
     * @return
     */
    String toString();

    /**
     * 集合是否为空
     * @return
     */
    default boolean isEmpty(){
        return size()==0;
    }
}
