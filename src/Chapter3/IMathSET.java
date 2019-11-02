package Chapter3;

public interface IMathSET<Key> extends ISET<Key> {
    /**
     * 将a中所有不在该集合中的键加入该集合
     * @param a
     */
    void union(IMathSET<Key> a);

    /**
     * 将该集合所有不在a中的键删除
     * @param a
     */
    void intersect(IMathSET<Key> a);

}
