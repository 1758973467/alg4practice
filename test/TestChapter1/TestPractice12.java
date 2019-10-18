package TestChapter1;

import chapter1.*;
import chapter1.BinarySearch;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.StdIn;
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StopwatchCPU;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TestPractice12 {
    @Test
    public void Test121(){
        int N=10;
        Point2D[] arrayPoint=new Point2D[N];
        for (int i = 0; i < arrayPoint.length; i++) {
            arrayPoint[i]=new Point2D(StdRandom.uniform(0,1.0),StdRandom.uniform(0,1.0));
        }

        double minLength=Double.POSITIVE_INFINITY;
        for (int i = 0; i < arrayPoint.length; i++) {
            for (int j = i+1; j < arrayPoint.length; j++) {
                if(arrayPoint[i].distanceTo(arrayPoint[j])<minLength){
                    minLength=arrayPoint[i].distanceSquaredTo(arrayPoint[j]);
                }
            }
        }
        StdOut.println(minLength);
    }
    @Test
    public void Test122(){
        int N=5;
        Interval1D[]arrayLine=new Interval1D[N];
        for (int i = 0; i < arrayLine.length; i++) {
            arrayLine[i]=new Interval1D(StdRandom.uniform(0.0,15),StdRandom.uniform(15.0,30));
        }
        for (int i = 0; i < arrayLine.length; i++) {
            for (int j = i+1; j < arrayLine.length; j++) {
                if(arrayLine[i].intersects(arrayLine[j])){
                    StdOut.println("intersects :"+i+"\t"+j);
                }
            }
        }
    }

    @Test
    public void Test123(){
        int N=10;

        Interval2D[]array2d=new Interval2D[N];
        for (int i = 0; i < array2d.length; i++) {
            Interval1D xInterval = new Interval1D(StdRandom.uniform(.0,0.2), StdRandom.uniform(.2,1));
            Interval1D yInterval = new Interval1D(StdRandom.uniform(.0,0.2), StdRandom.uniform(.2,1));
            array2d[i]=new Interval2D(xInterval, yInterval);
            array2d[i].draw();
        }
        Counter counter = new Counter("hits");
        for (int i = 0; i < array2d.length; i++) {
            for (int j = i+1; j < array2d.length; j++) {
                if(array2d[i].intersects(array2d[j])){
                    counter.increment();
                }

            }
        }

        StdOut.println(counter);
    }

    @Test
    public void Test127(){
        Assert.assertEquals(mystery("abc"),"abc");
    }
    private static String mystery(String s){
        int N=s.length();
        if(N<=1)return s;
        String a=s.substring(0,N/2);
        String b=s.substring(N/2,N);
        return mystery(a)+mystery(b);
    }

    @Test
    public static void Test129() throws IOException {
        String whiteListFile="test/TestChapter1/largeW.txt";
        String testFile="test/TestChapter1/largeT.txt";
        var whiteListReader=new FileInputStream(whiteListFile);
        System.setIn(whiteListReader);
        int []array= StdIn.readAllInts();
        whiteListReader.close();
        Arrays.sort(array);
        StopwatchCPU stopwatchCPU=new StopwatchCPU();
        Counter keyCounter=new Counter("keyCounter");
        Scanner scanner=new Scanner(new FileReader(testFile));
        while (scanner.hasNext()){
            int testInt=scanner.nextInt();
            BinarySearch.rank(testInt,array,keyCounter);
        }
        scanner.close();

        StdOut.println("BinarySearch:"+stopwatchCPU.elapsedTime());
        StdOut.println("Check Key:"+keyCounter.tally());
    }

    @Test
    public static void Test1211And1212(){
        var class1=new IllegalArgumentException().getClass();
        Assert.assertThrows(class1,()->new SmartDate(2000,0,1));
        Assert.assertThrows(class1,()->new SmartDate(2019,2,29));
        //
        Assert.assertEquals(new SmartDate(2019,2,1).dayOfWeek(),"Friday");
        Assert.assertEquals(new SmartDate(2019,9,28).dayOfWeek(),"Saturday");
    }

    @Test
    public void Test1216(){
        Rational a=new Rational(3,2);
        Rational b=new Rational(4,8);
        Assert.assertEquals(a.plus(b),new Rational(2,1));
        Assert.assertEquals(a.minus(b),new Rational(1,1));
        Assert.assertEquals(a.times(b),new Rational(3,4));
        Assert.assertEquals(a.divides(b),new Rational(3,1));

    }

    @Test
    public void Test1218(){
        int length=5;
        double[]array=new double[length];

        for (int i = 0; i < array.length; i++) {
            array[i]=StdRandom.uniform(5,10);
        }
        Accumulator acc=new Accumulator();
        double mean=0;
        double var=0;
        for (var item :array){
            StdOut.print(item+"\t");
            acc.addDataValue(item);
            mean+=item;
        }
        mean/=length;
        for (var item :array){
            var+=(item-mean)*(item-mean);
        }
        var=var/(length-1);
        StdOut.println();
        StdOut.println(var);
        StdOut.println(acc.var());
    }

    @Test
    public void Test1219(){
        String s="Turing 5/22/1939 11.99";
        String[] parts=s.split("\\s+");
        String timeParts[]=parts[1].split("/");
        Date date=new Date(Integer.parseInt(timeParts[0]),Integer.parseInt(timeParts[1]),Integer.parseInt(timeParts[2]));
        Transaction transaction=new Transaction(parts[0],date,Double.parseDouble(parts[2]));
        Assert.assertEquals(transaction,new Transaction("Turing",new Date(5,22,1939),11.99));
    }
}
