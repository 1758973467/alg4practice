package TestChapter5;

import Chapter5.StringSort.LSD;
import Chapter5.StringSort.MSD;
import Chapter5.StringSort.Quick3String;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;

import java.util.Arrays;

public class TestStringSort {

    @Test
    public void testLSDFixWidthSort(){
        In in=new In("test/TestChapter5/words3.txt");
        String[]a=in.readAllStrings();
        LSD.sort(a,3);
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(isSorted(a));
    }


    @Test
    public void testLSDFixableSort(){
        In in=new In("test/TestChapter5/shells.txt");
        String[]a=in.readAllStrings();

        LSD.sort(a);
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void testMSDsort(){
        In in=new In("test/TestChapter5/shells.txt");
        String[]a=in.readAllStrings();
        MSD.sort(a);
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void testQuick3StringSort(){
        In in=new In("test/TestChapter5/shells.txt");
        String[]a=in.readAllStrings();
        Quick3String.sort(a);
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(isSorted(a));
    }

    private static boolean isSorted(Comparable[]a){
        for (int i = 1; i < a.length; i++) {
            if(a[i].compareTo(a[i-1])<0){
                return false;
            }
        }
        return true;
    }
}
