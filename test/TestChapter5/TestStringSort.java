package TestChapter5;

import Chapter5.StringSort.LSD;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestStringSort {

    @Test
    public void testLSDFixWidthSort(){
        String[]a={
                "ABC",
                "BDC",
                "ACD"
        };
        LSD.sort(a,3);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testLSDFixableSort(){
        String[]a={
                "ABC",
                "BDC",
                "ACD"
        };

        LSD.sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testMSDsort(){

    }

    @Test
    public void testQuick3StringSort(){

    }
}
