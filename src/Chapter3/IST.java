package Chapter3;

/**
 * 简单泛型符号表API
 * @param <Key>
 * @param <Value>
 */
public interface IST<Key,Value> {
    /**
     * 将键值对存入表中，若值为空则将键Key从表中删除
     * @param key
     * @param val
     */
    void put(Key key,Value val);

    /**
     * 获取键Key对应的值，若键key不存在返回null
     * @param key
     * @return
     */
    Value get(Key key);

    /**
     * 从表中删除键Key及其对应的值
     * @param key
     */
     void delete(Key key);


    /**
     * 键key在表中是否有对应的值
     * @param key
     * @return
     */
    default boolean contains(Key key){
        return get(key)!=null;
    }

    /**
     * 表是否为空
     * @return
     */
    default boolean isEmpty(){
        return size()==0;
    }

    /**
     * 表中键值对的数量
     * @return
     */
    int size();

    /**
     * 表中所有键的集合
     * @return
     */
    Iterable<Key>keys();


}
