package chapter1;

import stdlib.StdRandom;

public class DoublingTest {
    public static int ThreeSum(int []a){
        Stopwatch stopwatch=new Stopwatch();
        int count=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                for (int k = j+1; k < a.length; k++) {
                    if(a[i]+a[j]+a[k]==0){
                        //StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static double timeTrial(int N){
        int MAX=1000000;
        int []a=new int[N];
        for (int i = 0; i < N;  i++) {
            a[i]= StdRandom.uniform(-MAX,MAX);
        }
        Stopwatch stopwatch=new Stopwatch();
        int count=ThreeSum(a);
        return stopwatch.elapsedTime();
    }
}
