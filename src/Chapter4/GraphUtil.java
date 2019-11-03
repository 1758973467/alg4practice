package Chapter4;

public class GraphUtil {
    public static int degree(IGraph G,int v){
        int degree=0;
        for (int w:G.adj(v)){
            degree++;
        }
        return degree;
    }

    public static int maxDegree(IGraph G){
        int maxDegree=0;
        for (int i = 0; i < G.V(); i++) {
            int curDegree=degree(G,i);
            if(maxDegree<curDegree){
                maxDegree=curDegree;
            }
        }
        return maxDegree;
    }

    /**
     * 平均度数
     * @param G
     * @return
     */
    public static double avgDegree(IGraph G){
        return 2.0*G.E()/G.V();
    }

    /**
     * 计算自环个数
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(IGraph G){
        int count=0;
        for (int v = 0; v <G.V(); v++) {
            for(int w:G.adj(v)){
                if(v==w){
                    count++;
                }
            }
        }
        return count/2;
    }


    public static String toString(IGraph G){
        StringBuilder builder=new StringBuilder();
        builder.append(G.V()+" vertices,"+G.E()+" edges\n");
        for (int v = 0; v < G.V(); v++) {
            builder.append(v+": ");
            for (int w:G.adj(v)){
                builder.append(w+" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
