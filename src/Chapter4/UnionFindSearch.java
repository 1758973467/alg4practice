package Chapter4;

import chapter1.CaseStudy.IUF;
import chapter1.CaseStudy.UFFaster;

public class UnionFindSearch implements ISearch {

    private IUF ufFaster;
    private final int s;
    private int count;//与s连通的分量数
    public UnionFindSearch(IGraph g,int s) {
        this.s=s;

        ufFaster=new UFFaster(g.V());
        for (int i = 0; i < g.V(); i++) {
            for (int w:g.adj(i)){
                if(!ufFaster.connected(i, w)){
                    ufFaster.union(i, w);
                }
            }
        }

        for (int i = 0; i < g.V(); i++) {
            if(i!=s&&ufFaster.connected(i,s)){
                count++;
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return ufFaster.connected(s,v);
    }

    @Override
    public int count() {
        return count;
    }
}
