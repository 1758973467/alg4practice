package TestChapter2;

import Chapter2.Example;
import Chapter2.MergeBUSort;
import Chapter2.MergeSort;
import Chapter2.MergeSortEnhanced;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;

public class TestChapter22 {

    @Test
    public void TestMergeSort(){
        In in=new In("test/TestChapter2/tiny.txt");
        String[] a=in.readAllStrings();
        Example example=new MergeSort();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }

    @Test
    public void TestMergeBUSort(){
        In in=new In("test/TestChapter2/tiny.txt");
        String[] a=in.readAllStrings();
        Example example=new MergeBUSort();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }

    @Test
    public void TestMergeEnhanced(){
        In in=new In("test/TestChapter2/largeW.txt");
        String[] a=in.readAllStrings();
        Example example=new MergeSortEnhanced();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }

}
