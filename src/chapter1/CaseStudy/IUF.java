package chapter1.CaseStudy;

public interface IUF{
    /**
     * 在p，q之间添加一条连接
     * @param p
     * @param q
     */
    void union(int p,int q);
    /**
     * p所在的分量标识符（0~N-1)
     * @param p
     * @return
     */
    int find(int p);
    /**
     * 如果p,q在同一连通分量为true
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p,int q);
    /**
     * 连通分量的数量
     * @return
     */
    int count();
}
