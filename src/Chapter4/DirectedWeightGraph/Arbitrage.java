package Chapter4.DirectedWeightGraph;

import stdlib.StdIn;
import stdlib.StdOut;

/**
 * 解决相应的负周期检测问题来识别货币交换网络中的套利机会。
 */
public class Arbitrage {
    public static void main(String[]args){
        int V= StdIn.readInt();
        String[]name=new String[V];
        IEdgeWeightedDigraph g=new EdgeWightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v]=StdIn.readString();
            for (int w = 0; w < V; w++) {
                double rate=StdIn.readDouble();
                DirectedEdge e=new DirectedEdge(v,w,-Math.log(rate));
                g.addEdge(e);
            }
        }
        //
        BellmanFordSP spt=new BellmanFordSP(g,0);
        if(spt.hasNegativeCycle()){
            double stake=1000.0;
            for (DirectedEdge e:spt.negativeCycle()){
                StdOut.printf("%10.5f %s\n",stake,name[e.from()]);
                stake*=Math.exp(-e.weight());
                StdOut.printf("=%10.5f %s\n",stake,name[e.to()]);
            }
        }else {
            StdOut.println("No arbitrage opportunity");
        }
    }
}
