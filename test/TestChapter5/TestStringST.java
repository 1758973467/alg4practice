package TestChapter5;

import Chapter5.IStringST;
import Chapter5.TrieST;
import org.testng.annotations.Test;
import stdlib.In;

public class TestStringST {
    @Test
    public void testLSDFixWidthSort(){
        In in=new In("test/TestChapter5/words3.txt");
        String[]a=in.readAllStrings();
        IStringST<Integer> stringST=new TrieST<>();
        for (int i = 0; i < a.length; i++) {
            stringST.put(a[i],i);
        }

    }

}
