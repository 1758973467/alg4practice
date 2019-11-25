package Chapter5;

public interface IStringST<Value> {
    /**
     * 向表中插入键值对，值为null,则删除key
     * @param key
     * @param val
     */
    void put(String key,Value val);

    /**
     * 键key所对应的值，不存在则返回null
     * @param key
     * @return
     */
    Value get(String key);

    /**
     * 删除键key和它的值
     * @param key
     */
    void delete(String key);

    /**
     * s的前缀中最长的键
     * @param s
     * @return
     */
    String longestPrefixOf(String s);

    /**
     * 所有以s为前缀的键
     * @param s
     * @return
     */
    Iterable<String> keysWithPrefix(String s);

    /**
     * 所有和s匹配的键
     * @param s
     * @return
     */
    Iterable<String> keysThatMatch(String s);

    /**
     * 键值对数量
     * @return
     */
    int size();

    /**
     * 符号表中的所有键
     * @return
     */
    Iterable<String> keys();

    /**
     * 是否存在Key
     * @param key
     * @return
     */
    default boolean contains(String key){
        return get(key)!=null;
    }

    /**
     * 符号表是否为空
     * @return
     */
    default boolean isEmpty(){
        return size()!=0;
    }
}
