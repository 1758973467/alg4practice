package TestChapter1;

import com.company.BinarySearch;
import com.company.Main;
import org.testng.Assert;
import org.testng.annotations.Test;
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.StopwatchCPU;

import java.io.*;
import java.util.*;

public class TestPractice11 {
    @Test
    public void Test111(){
        Assert.assertEquals(15/2,7);
        Assert.assertEquals(2.0e-6*10000000.1,20.0000002);
        Assert.assertEquals(true&&false||true&&true,true);

    }
    @Test
    public void Test112(){
        //double
        System.out.println((1+2.236)/2);
        //double
        System.out.println(1+2+3+4.0);
        //boolean
        System.out.println(4.1>=4);
        //string
        System.out.println(1+2+"3");

    }
    @Test
    public void Test113(){
        Assert.assertEquals(Main.Practice113(new String[]{"1","2","3"}),"not equal");
        Assert.assertEquals(Main.Practice113(new String[]{"1","1","1"}),"equal");
    }

    @Test
    public void Test115(){
        Assert.assertEquals(Main.Practice115(0.5),true);
        Assert.assertEquals(Main.Practice115(1),true);
        Assert.assertEquals(Main.Practice115(0),true);
        Assert.assertEquals(Main.Practice115(-0),true);
        Assert.assertEquals(Main.Practice115(-0.1),false);
    }

    @Test
    public void Test116(){
        int f=0;
        int g=1;
        int[] array=new int[16];
        for(int i=0;i<=15;++i){
            array[i]=f;
            f=f+g;
            g=f-g;
        }
        int[]results=new int[]{
            0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610
        };
        Assert.assertEquals(array,results);
    }
    @Test
    public void Test117(){
        //sqrt
        double t=9.0;
        while (Math.abs(t-9.0/t)>.001){
            t=(9.0/t+t)/2.0;
        }
        String result=String.format("%.5f\n",t);
        String expect="3.00009\n";
        Assert.assertEquals(result,expect);

        //
        int sum=0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        Assert.assertEquals(sum,499500);

        sum=0;
        for (int i = 1; i <1000 ; i*=2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        //error
        Assert.assertNotEquals(sum,1023);
        Assert.assertEquals(sum,10000);
    }

    @Test
    public void Test118(){

        Assert.assertEquals('b'+"\n","b\n");

        Assert.assertNotEquals('b'+'c'+"\n","bc\n");
        Assert.assertEquals('b'+'c'+"\n","197\n");
        Assert.assertEquals((char)('a'+4)+"\n","e\n");
    }

    @Test
    public void Test1111(){
        boolean[][] matrix=new boolean[5][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("i "+i+" j"+j+""+matrix[i][j]);
            }
        }
    }

    @Test
    public void Test1112(){
        int[]a=new int[10];
        for (int i=0;i<10;++i){
            a[i]=9-i;
        }
        for (int i = 0; i < 10; i++) {
            a[i]=a[a[i]];
        }
        int []results=new int[]{0,1,2,3,4,4,3,2,1,0};

        Assert.assertEquals(a,results);
    }
    @Test
    public void Test1113(){
        //transfrom n*m
        int[][]intput=new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6}
        };
        int[][]output=new int[][]{
                new int[]{1,4},
                new int[]{2,5},
                new int[]{3,6}
        };
        var result=Main.Practice1113(intput);
        for (int i = 0; i <result.length ; i++) {
            Assert.assertEquals(result[i],output[i]);
        }
    }

    @Test
    public void Test1114(){
        Assert.assertEquals(Main.Practice1114(9),3);
        Assert.assertEquals(Main.Practice1114(8),3);
    }

    @Test
    public void Test1116(){
        Assert.assertEquals(Main.Practice1116(6),"311361142246");
    }

    @Test
    public void Test1118(){
        Assert.assertEquals(Main.Practice1118(2,25),50);
        Assert.assertEquals(Main.Practice1118(3,11),33);
    }

    //@Test
    public void Test1119(){
        int count=0;
        for (int i = 0; i < 50; i++) {
            Main.Practice1119(i);
            count++;
        }
    }

    @Test
    public void Test1119Better(){
        int count=0;
        for (int i = 0; i < 100; i++) {
            Main.Practice1119Better(i);
            count++;
        }
    }
    @Test
    public void Test1120(){
        Assert.assertEquals(Main.Practice1120(5),Math.log(5*4*3*2*1));
    }
    @Test
    public void Test1122(){
        Random random=new Random(System.currentTimeMillis());
        int []array=new int[100];
        for (int i = 0; i < 100; i++) {
            array[i]=random.nextInt(300);
        }
        Arrays.sort(array);
        int key=array[random.nextInt(100)];
        Assert.assertEquals(BinarySearch.rank(key,array),BinarySearch.rankRecursion(key,array));
        Assert.assertEquals(BinarySearch.rank(500,array),BinarySearch.rankRecursion(500,array));
    }
    @Test
    public void Test1123() throws IOException {
        String whiteListFileName="test/TestChapter1/tinyW.txt";
        String test="test/TestChapter1/tinyT.txt";
        var scanner=new Scanner(new File(whiteListFileName));
        List<Integer>whitelist=new ArrayList<>();
        while (scanner.hasNext()){
            whitelist.add(scanner.nextInt());
        }
        scanner.close();
        int []array=new int[whitelist.size()];
        for (int i = 0; i < whitelist.size(); i++) {
            array[i]=whitelist.get(i);
        }
        Arrays.sort(array);
        scanner=new Scanner(new File(test));
        while (scanner.hasNext()){
            int key=scanner.nextInt();
            int result=BinarySearch.rank(key,array);
            if(result==-1){
                System.out.println("-"+key);
            }else{
                System.out.println("+"+key);
            }

        }
        scanner.close();
    }

    @Test
    public void Test1124(){
        Assert.assertEquals(Main.Euclid(111,111),111);
        Assert.assertEquals(Main.Euclid(234,567),9);
    }
    @Test
    public void Test1127(){
        Assert.assertEquals(Main.binomial(3,4,0.5),Main.binomial2(3,4,0.5));
        Assert.assertEquals(Main.binomial(30,40,0.5),Main.binomial2(30,40,0.5));
    }

    @Test
    public void Test1128() throws IOException {
        //删除白名单重复的元素
        String whiteListFileName="test/TestChapter1/tinyW.txt";
        String whitelistNoDuplicate="test/TestChapter1/tinyWNoDuplciate.txt";

        int []array=readAllInts(whiteListFileName);

        Arrays.sort(array);
        int len=array.length;
        for (int i = 1; i < len; i++) {
            if(array[i]==array[i-1]){
                for (int j = i+1; j < len; j++) {
                    array[j-1]=array[j];
                }
                len--;
            }
        }
        //print
        BufferedWriter writer=new BufferedWriter(new FileWriter(whitelistNoDuplicate));

        for (int i = 0; i < len; i++) {
            writer.write(""+array[i]);
            writer.newLine();
        }
        writer.close();
    }

    @Test
    public void Test1129(){
        int[]array={1,1,1,2,2,2,5,7,9};
        int i=BinarySearch.rankLower(1,array);
        int j=BinarySearch.count(1,array);
        for (int k = i; k < j; k++) {
            Assert.assertEquals(array[k],1);
        }
    }

    @Test
    public void Test1130(){
        boolean [][]a=new boolean[100][100];
        a[0][0]=true;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(j!=0&&i%j==0){
                    a[i][j]=true;
                }else{
                    a[i][j]=false;
                }
            }
        }
    }
    @Test
    public void Test1135(){
        //testdot
        int SIDES=6;
        double[]dist=new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i+j]+=1.0;
            }
        }
        for (int i = 2; i < 2*SIDES+1; i++) {
            dist[i]/=36.0;
        }
        //

        long N=10000;
        double []occur=new double[2*SIDES+1];
        double[]avg=new double[2*SIDES+1];
        do {
            N+=1000;
            Arrays.fill(occur, 0);
            for (int i = 0; i < N; i++) {
                int a=StdRandom.uniform(1,7);
                int b=StdRandom.uniform(1,7);
                occur[a+b]+=1;
            }

            for (int i = 0; i < 2*SIDES+1; i++) {
                avg[i]=occur[i]/N;
            }
            StdOut.println(N);
        }while (!Check(dist,avg));
        StdOut.println(N);
    }
    private boolean Check(double[]dist,double[]avg){
        for (int i = 0; i < dist.length; i++) {
            if(Math.abs(dist[i]-avg[i])>0.0001){
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test1137(){
        int N=50000;//shuffle count
        int M=10;//数组长度
        long[][]testResult=new long[M][M];

        double[]array=new double[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < array.length; j++) {
                array[j]=j;
            }
            Main.shuffle(array);
            for (int j = 0; j < array.length; j++) {
                testResult[j][(int)array[j]]+=1;
            }
        }

        //print testResult
        for (int i = 0; i < testResult.length; i++) {
            for (int j = 0; j < testResult[i].length; j++) {
                StdOut.print(testResult[i][j]+"\t");
            }
            StdOut.println();
        }

    }


    @Test
    public void TestShuffleError(){
        int N=50000;//shuffle count
        int M=10;//数组长度
        long[][]testResult=new long[M][M];

        double[]array=new double[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < array.length; j++) {
                array[j]=j;
            }
            shuffleError(array);
            for (int j = 0; j < array.length; j++) {
                testResult[j][(int)array[j]]+=1;
            }
        }

        //print testResult
        for (int i = 0; i < testResult.length; i++) {
            for (int j = 0; j < testResult[i].length; j++) {
                StdOut.print(testResult[i][j]+"\t");
            }
            StdOut.println();
        }
    }
    private static void shuffleError(double[]a){
        int N=a.length;
        for (int i = 0; i < N; i++) {
            int r=StdRandom.uniform(N-i);
            double temp=a[i];
            a[i]=a[r];
            a[r]=temp;
        }
    }

    //@Test
    public void TestBruteForceAndBinarySearch() throws FileNotFoundException {
        String whiteListFile="test/TestChapter1/largeW.txt";
        String testFile="test/TestChapter1/largeT.txt";
        int []array=readAllInts(whiteListFile);
        Arrays.sort(array);
        StopwatchCPU stopwatchCPU=new StopwatchCPU();
        Scanner scanner=new Scanner(new FileReader(testFile));
        while (scanner.hasNext()){
            int testInt=scanner.nextInt();
            BinarySearch.rank(testInt,array);
        }
        scanner.close();
        StdOut.println("BinarySearch:"+stopwatchCPU.elapsedTime());
        stopwatchCPU=new StopwatchCPU();
        scanner=new Scanner(new FileReader(testFile));
        while (scanner.hasNext()){
            int testInt=scanner.nextInt();
            BinarySearch.BruteForceSearch(testInt,array);
        }
        scanner.close();
        StdOut.println("BruteForceSearch:"+stopwatchCPU.elapsedTime());
    }

    private int[] readAllInts(String fileName) throws FileNotFoundException {
        Scanner scanner=new Scanner(new FileReader(fileName));
        List<Integer>whitelist=new ArrayList<>();
        while (scanner.hasNext()){
            whitelist.add(scanner.nextInt());
        }
        scanner.close();
        int []array=new int[whitelist.size()];
        for (int i = 0; i < whitelist.size(); i++) {
            array[i]=whitelist.get(i);
        }
        return array;
    }

    @Test
    public void Test1139(){
        long T=1000;//运行次数
        int[]test={(int)1e3,(int)1e4,(int)1e5,(int)1e6};
        double[]testAvg=new double[test.length];
        for (int i = 0; i < test.length; i++) {
            int []a=new int[test[i]];
            int []b=new int[test[i]];
            for (int testIndex = 0; testIndex < T; testIndex++) {
                testAvg[i]+=count(a,b);
            }
            testAvg[i]/=test[i];
        }
        StdOut.println("实验次数\t平均数");
        for (int i = 0; i < testAvg.length; i++) {
            StdOut.println(""+test[i]+"\t"+testAvg[i]);
        }
    }
    private int count(int []a,int []b){

        int count=0;//同时存在于两个数组中的整数的数量

        for (int j = 0; j < a.length; j++) {
            a[j]=StdRandom.uniform((int)1e5+1,(int)1e6);
            b[j]=StdRandom.uniform((int)1e5+1,(int)1e6);
        }
        Arrays.sort(a);
        for (int j = 0; j < a.length; j++) {
            if(BinarySearch.rank(b[j],a)!=-1){
                count++;
            }
        }
        return count;
    }
}
