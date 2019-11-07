package Chapter4.UnDirectGraph;

import Chapter4.IGraph;
import Chapter4.IPaths;

import java.util.Arrays;

public class GraphProperties {
    private int[]eccentricity;
    private int radius;
    private int diameter;
    private int center;
    public GraphProperties(IGraph G) {
        //如果不是连通的，抛出异常
        eccentricity=new int[G.V()];
        for (int i = 0; i < eccentricity.length; i++) {
            IPaths paths=new BreadthFirstPaths(G,i);
            eccentricity[i]=paths.distTo(0);
            for (int j = 0; j <G.V() ; j++) {
                if(eccentricity[i]<paths.distTo(i)){
                    eccentricity[i]=paths.distTo(i);
                }
            }
        }
        diameter=Arrays.stream(eccentricity).max().getAsInt();
        radius=Arrays.stream(eccentricity).min().getAsInt();
        for (int i = 0; i < eccentricity.length; i++) {
            if(radius==eccentricity[i]){
                IPaths paths=new BreadthFirstPaths(G,i);
                center=0;
                for (int j = 0; j < G.V(); j++) {
                    if(paths.distTo(center)<=paths.distTo(j)){
                        center=j;
                    }
                }
            }
        }
    }

    /**
     * v的离心率
     * @param v
     * @return
     */
    public int eccentricity(int v){
        return eccentricity[v];
    }

    /**
     * G的直径
     * @return
     */
    public int diameter(){
        return diameter;
    }

    /**
     * G的半径
     * @return
     */
    public int radius(){
        return radius;
    }

    /**
     * G的某个中点
     * @return
     */
    public int center(){
        return center;
    }
}
