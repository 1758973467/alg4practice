package TestChapter2;

import Chapter2.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdRandom;

public class TestChapter21 {
    @Test
    public void TestSelectionSort(){
        In in=new In("test/TestChapter2/tiny.txt");
        String[] a=in.readAllStrings();
        Example example=new SelectionSort();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }

    @Test
    public void TestInsertSort(){
        In in=new In("test/TestChapter2/tiny.txt");
        String[] a=in.readAllStrings();
        Example example=new InsertionSort();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }

    @Test
    public void TestShellSort(){
        In in=new In("test/TestChapter2/tiny.txt");
        String[] a=in.readAllStrings();
        Example example=new ShellSort();
        example.sort(a);
        Example.show(a);
        Assert.assertTrue(Example.isSorted(a));
    }

    @Test
    public void Test211(){
        String a="EASYQUESTION";
        Character[]array=new Character[a.length()];
        for (int i = 0; i < a.length(); i++) {
            array[i]=a.charAt(i);
        }
        Example example=new ShellSort();
        example.sort(array);
        String result="AEEINOQSSTUY";
        Assert.assertEquals(array,result.toCharArray());
    }

    @Test
    public void Test2111And2112(){
        Example example=new ShellSortAdvanced();
        int num=100;
        for (int i = 0; i < 10; i++) {
            Double[]array=new Double[num*(int)Math.pow(10,i)];
            for (int j = 0; j < array.length; j++) {
                array[j]= StdRandom.uniform(-50.0,50.0);
            }
            example.sort(array);
        }
    }


}
