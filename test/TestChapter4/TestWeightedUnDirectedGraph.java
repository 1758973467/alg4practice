package TestChapter4;

import Chapter4.WeightedUnDirectedGraph.*;
import chapter1.CaseStudy.IUF;
import chapter1.CaseStudy.UFFaster;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestWeightedUnDirectedGraph {

    private static final double FLOATING_POINT_EPSILON = 1e-12;

    @Test
    public void testMST(){
        In in=new In("test/TestChapter4/tinyEWG.txt");
        IEdgeWeightedGraph g=new EdgeWeightedGraph(in);
        IMST mst=new LazyPrimeMST(g);
        for (var e:mst.edges()){
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }

}
