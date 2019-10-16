package TestChapter2;

import Chapter2.Quick;
import org.testng.annotations.Test;
import org.testng.reporters.jq.INavigatorPanel;
import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;
import stdlib.StdRandom;

public class TestChapter23 {

    @Test
    public void TestQuickSort(){
        String[] a =new String[]{
                "E","A","S","Y","Q","U","E","S","T","I","O","N"
        };
        Quick.sort(a);
        Quick.show(a);
        assert Quick.isSorted(a);
    }

    @Test
    public void TestChapter235(){
        String[] a =new String[]{
                "E","E","S","S","S","S","E","S","E","E","E","E"
        };
        Quick.sort(a);
        Quick.show(a);
        assert Quick.isSorted(a);
    }

}
