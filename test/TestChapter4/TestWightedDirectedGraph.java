package TestChapter4;

import Chapter4.DirectedWeightGraph.*;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestWightedDirectedGraph {
    @Test
    public void testShortestPath(){
        IEdgeWeightedDigraph g=new EdgeWightedDigraph(new In("test/TestChapter4/tinyEWD.txt"));
        int s=0;
        ISP sp=new DijkstraSP(g,s);
        for (int t = 0; t < g.V(); t++) {
            StdOut.print(s+" to "+t);
            StdOut.printf(" (%4.2f):",sp.distTo(t));
            if(sp.hasPathTo(t)){
                for (var edge:sp.pathTo(t)){
                    StdOut.print(edge+" ");
                }
            }
            StdOut.println();
        }
    }

    @Test
    public void testSPDAG(){
        IEdgeWeightedDigraph g=new EdgeWightedDigraph(new In("test/TestChapter4/tinyEWDAG.txt"));
        int s=0;
        ISP sp=new AcyclicSP(g,s);
        for (int t = 0; t < g.V(); t++) {
            StdOut.print(s+" to "+t);
            StdOut.printf(" (%4.2f):",sp.distTo(t));
            if(sp.hasPathTo(t)){
                for (var edge:sp.pathTo(t)){
                    StdOut.print(edge+" ");
                }
            }
            StdOut.println();
        }
    }
    @Test
    public void testAcyclicSP(){
        In in=new In("test/TestChapter4/tinyEWDAG.txt");
        IEdgeWeightedDigraph G = new EdgeWightedDigraph(in);
        int s=5;
        ISP sp = new AcyclicSP(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (sp.hasPathTo(v)) {
                StdOut.printf("%d to %d (%.2f)  ", s, v, sp.distTo(v));
                for (DirectedEdge e : sp.pathTo(v)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, v);
            }
        }
    }
    @Test
    public void testAcyclicLP(){
        In in=new In("test/TestChapter4/tinyEWDAG.txt");
        IEdgeWeightedDigraph G = new EdgeWightedDigraph(in);
        int s=5;
        AcyclicLP lp = new AcyclicLP(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (lp.hasPathTo(v)) {
                StdOut.printf("%d to %d (%.2f)  ", s, v, lp.distTo(v));
                for (DirectedEdge e : lp.pathTo(v)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, v);
            }
        }
    }
    @Test
    public void testCPM(){
        In in=new In("test/TestChapter4/jobsPC.txt");
        // number of jobs
        int n = in.readInt();

        // source and sink
        int source = 2*n;
        int sink   = 2*n + 1;

        // build network
        IEdgeWeightedDigraph G = new EdgeWightedDigraph(2*n + 2);
        for (int i = 0; i < n; i++) {
            double duration = in.readDouble();
            G.addEdge(new DirectedEdge(source, i, 0.0));
            G.addEdge(new DirectedEdge(i+n, sink, 0.0));
            G.addEdge(new DirectedEdge(i, i+n,    duration));

            // precedence constraints
            int m = in.readInt();
            for (int j = 0; j < m; j++) {
                int precedent = in.readInt();
                G.addEdge(new DirectedEdge(n+i, precedent, 0.0));
            }
        }

        // compute longest path
        AcyclicLP lp = new AcyclicLP(G, source);

        // print results
        StdOut.println(" job   start  finish");
        StdOut.println("--------------------");
        for (int i = 0; i < n; i++) {
            StdOut.printf("%4d %7.1f %7.1f\n", i, lp.distTo(i), lp.distTo(i+n));
        }
        StdOut.printf("Finish time: %7.1f\n", lp.distTo(sink));
    }
}
