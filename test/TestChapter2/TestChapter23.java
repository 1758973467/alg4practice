package TestChapter2;

import Chapter2.Example;
import Chapter2.QuickSort;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;

public class TestChapter23 {


    @Test
    public void TestQuickSort(){
        String[] strs =new String[]{
                "E","A","S","Y","Q","U","E","S","T","I","O","N"
        };
        In in=new In("test/TestChapter2/tiny.txt");
        String[] a=in.readAllStrings();
        Example example=new QuickSort();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }
}

