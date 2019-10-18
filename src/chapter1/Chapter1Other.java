package chapter1;

import stdlib.StdRandom;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Chapter1Other {
    /**
     * 比较输入的三个整形数是否相等，相等 eaual,反之 not equal
     * @param args
     * @return
     */
    public static String Practice113(String[] args){
        int []array=new int[3];
        array[0]=Integer.parseInt(args[0]);
        array[1]=Integer.parseInt(args[1]);
        array[2]=Integer.parseInt(args[2]);

        for (int i = 0; i < array.length; i++) {
            if(array[i]!=array[0]){
                return ("not equal");
            }
        }
        return ("equal");
    }

    /**
     * 判断是否位于【0，1】之间
     * @param a
     * @return
     */
    public static boolean Practice115(double a){
        if(a<=1&&a>=0){
            return true;
        }else return false;
    }

    /**
     * 矩阵转置
     * @param matrix
     * @return
     */
    public static int[][]Practice1113(int [][]matrix){
        int[][] resultmatrix=new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultmatrix[j][i]=matrix[i][j];
            }
        }
        return resultmatrix;
    }

    /**
     * 返回不大于log2N的最大整数
     * @param N
     * @return
     */
    public static int Practice1114(int N){
        int num=1;
        int power=0;
        while (2*num<=N){
            num*=2;
            power++;
        }
        return power;
    }
    public static int[]Practice1115(int []a,int M){
        int []histortgram=new int[M];
        for (int i = 0; i < a.length; i++) {

        }
        return histortgram;
    }

    public static String Practice1116(int n){
        if(n<=0)return "";
        else return Practice1116(n-3)+n+Practice1116(n-2)+n;
    }

    public static int Practice1118(int a,int b){
        if(b==0)return 0;
        else if(b%2==0) return Practice1118(a+a,b/2);
        else return Practice1118(a+a,b/2)+a;
    }

    /**
     * 斐波那契数列
     * @param N
     * @return
     */
    public static long Practice1119(int N){
        if(N==0)return 0;
        if (N==1)return 1;
        return Practice1119(N-1)+Practice1119(N-2);
    }
    /**
     * 斐波那契数列
     * @param N
     * @return
     */
    public static long Practice1119Better(int N){
        if(N==0)return 0;
        long[]array=new long[N+1];
        array[0]=0;
        array[1]=1;
        for (int i = 2; i < N+1; i++) {
            array[i]=array[i-2]+array[i-1];
        }
        return array[N];
    }

    public static double Practice1120(int N){
        if(N==1)return 0;
        else return Math.log(N)+Practice1120(N-1);
    }

    public static void Practice1121(String filename) throws FileNotFoundException {
        Scanner scanner=new Scanner(new FileReader(filename));
        while (scanner.hasNext()){
            String line=scanner.nextLine();
            String[]splits=line.split(",");
            var str=String.format(splits[0]+"\t"+splits[1]+"\t"+splits[2]+"\t.3f",Integer.parseInt(splits[1])/Integer.parseInt(splits[2]));
            System.out.println(str);
        }
    }

    /**
     * 最大公约数
     * @param p
     * @param q
     */
    public static int Euclid(int p,int q){
        int max=Math.max(p,q);
        int min=Math.min(p,q);
        while (max%min!=0){
            int temp=max%min;
            max=min;
            min=temp;
            System.out.println("p:"+max+"q:"+min);
        }
        return min;
    }

    public static double binomial(int N,int k,double p){
        if(N==0&&k==0)return 1.0;
        if(N<0||k<0)return 0;
        return (1-p)*binomial(N-1,k,p)+p*binomial(N-1,k-1,p);
    }

    public static double binomial2(int N,int k,double p){
        double[][]result=new double[N+1][k+1];

        for (int i = 0; i < N; i++) {
            result[i][0]=Math.pow(1-p,i);
        }
        result[0][0]=1;
        //[0][x]=0
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < k; j++) {
                result[i][j]=(1-p)*result[i-1][j]+p*result[i-1][j-1];
            }
        }
        return result[N][k];
    }

    public static void shuffle(double []a){
        int N=a.length;
        for (int i = 0; i < N; i++) {
            int r=i+ StdRandom.uniform(N-i);
            double temp=a[i];
            a[i]=a[r];
            a[r]=temp;
        }
    }
}
