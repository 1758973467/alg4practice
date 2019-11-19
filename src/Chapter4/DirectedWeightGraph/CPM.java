package Chapter4.DirectedWeightGraph;

import stdlib.StdIn;
import stdlib.StdOut;

/**
 * 关键路径方法的实现
 */
public class CPM {
    public static void main(String[]args){
        int N= StdIn.readInt();
        StdIn.readLine();
        IEdgeWeightedDigraph g=new EdgeWightedDigraph(2*N+2);
        int s=2*N,t=2*N+1;
        for (int i = 0; i < N; i++) {
            String[]a=StdIn.readLine().split("\\s++");
            double duration=Double.parseDouble(a[0]);
            g.addEdge(new DirectedEdge(i,i+N,duration));
            g.addEdge(new DirectedEdge(s,i,0d));
            g.addEdge(new DirectedEdge(i+N,t,0d));

            for (int j = 1; j < a.length; j++) {
                int successor=Integer.parseInt(a[j]);
                g.addEdge(new DirectedEdge(i+N,successor,0d));
            }
        }

        AcyclicLP lp=new AcyclicLP(g,s);
        StdOut.println("Start times:");
        for (int i = 0; i < N; i++) {
            StdOut.printf("%4d:%5.1f\n",i,lp.distTo(i));
        }
        StdOut.printf("Finish time:%5.1f\n",lp.distTo(t));
    }
}
