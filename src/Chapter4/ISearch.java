package Chapter4;

import stdlib.In;
import stdlib.StdOut;

public interface ISearch {
    /**
     *  v-s是连通的吗
     * @param v
     * @return
     */
    boolean marked(int v);
    /**
     * 与s顶点连接的顶点总数
     * @return
     */
    int count();

    public static  void main(String []args){
        IGraph g=new Graph(new In(args[0]));
        int s=Integer.parseInt(args[1]);
        DepthFirstSearchSearch search=new DepthFirstSearchSearch(g,s);
        for (int v = 0; v < g.V(); v++) {
            if(search.marked(v)){
                StdOut.print(v+" ");
            }
        }
        StdOut.println();

        if(search.count()!=g.V()){
            StdOut.print("NOT ");
        }
        StdOut.println("connected");

    }
}
