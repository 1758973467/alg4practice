package TestChapter4;

import Chapter4.Graph;
import Chapter4.IGraph;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;

public class TestUndirectedGraph {

    @Test
    public void TestToString(){
        In in =new In("test/");
        IGraph g=new Graph(in);
        StdOut.println(g.toString());

    }

    @Test
    public void TestISearch(){

    }

    @Test
    public void TestIPaths(){

    }

    @Test
    public void TestICC(){

    }

    @Test
    public void TestGraphRestrict(){

    }
}
