package TestChapter1;

import chapter1.DoublingTest;
import chapter1.Stopwatch;
import com.company.BinarySearch;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.In;
import stdlib.StdOut;
import stdlib.StdRandom;

import java.util.Arrays;

public class TestChapter14 {
    @Test
    public void testDoublingTest(){
        for (int N = 250;N<1000000 ; N+=N) {
            double time=DoublingTest.timeTrial(N);
            StdOut.printf("%7d %f\n",N,time);
        }
    }
    @Test
    public void testThreeSum(){
        String[]files={
                "test/TestChapter1/1Kints.txt",
                "test/TestChapter1/2Kints.txt",
                "test/TestChapter1/4Kints.txt",
                "test/TestChapter1/8Kints.txt",
                "test/TestChapter1/16Kints.txt",
                "test/TestChapter1/32Kints.txt"
        };
        for(var file :files){

            In in=new In(file);
            int[] a=in.readAllInts();
            Stopwatch stopwatch=new Stopwatch();
            int count=DoublingTest.ThreeSum(a);
            StdOut.printf(" %f\n",stopwatch.elapsedTime());

        }

    }
    @Test
    public void test148(){
        //相等整数对数量
        In in=new In("test/TestChapter1/32Kints.txt");
        int[] a=in.readAllInts();
        int count=0;
        //brute-force
        Stopwatch stopwatch=new Stopwatch();
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]==a[j]){
                    count++;
                }
            }
        }
        StdOut.printf("brute-force %f\n",stopwatch.elapsedTime());
        StdOut.println("sum:"+count);
        count=0;
        stopwatch=new Stopwatch();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            int found=BinarySearch.rank(a[i],a);
            if(found!=-1&&found!=i){
                count++;
            }
        }
        StdOut.printf("brute-force %f\n",stopwatch.elapsedTime());
        StdOut.println("sum:"+count);
    }

    @Test
    public void Test1410(){
        int []array={1,1,2,3,4,5,5};
        Assert.assertEquals(BinarySearch.rankAdvanced(1,array),0);
        Assert.assertEquals(BinarySearch.rankAdvanced(5,array),5);
        Assert.assertEquals(BinarySearch.rankAdvanced(3,array),3);
    }
    @Test
    //4sum brute-force
    public void Test1414(){

        In in=new In("test/TestChapter1/1Kints.txt");
        int[] a=in.readAllInts();
        int count=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                for (int k = j+1; k < a.length; k++) {
                    for (int l = k+1; l < a.length; l++) {
                        if(a[i]+a[j]+a[k]+a[l]==0){
                            StdOut.println(a[i] + " " + a[j] + " " + a[k] + " " + a[l]);
                            count++;

                        }
                    }
                }
            }
        }
        StdOut.print("4sum:"+count);
    }

    @Test
    //3sum faster
    public void Test1415(){
        In in=new In("test/TestChapter1/1Kints.txt");
        int[] a=in.readAllInts();
        int count=0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int found= BinarySearch.rank(-a[i]-a[j],a);
                if(found>j){
                    count++;
                }
            }
        }
        StdOut.print("3sumfaster:"+count);
    }

    @Test
    public void test1416(){
        int N=10;
        double[]a=new double[N];

        for (int i = 0; i < a.length; i++) {
            a[i]= StdRandom.uniform(20,100);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
        System.out.println();
        //find
        int mini=0;
        int minj=1;
        Arrays.sort(a);
        double min=Double.POSITIVE_INFINITY;
        for (int i = 1; i < a.length; i++) {
            if(Math.abs(a[i]-a[i-1])<min){
                min=Math.abs(a[i]-a[i-1]);
                mini=i;
                minj=i-1;
            }

        }
        System.out.println(a[mini]+" "+a[minj]);
    }
}
