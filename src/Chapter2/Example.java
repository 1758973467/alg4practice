package Chapter2;

import stdlib.StdOut;

public abstract class Example {
    public abstract void sort(Comparable[]a);
    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    protected static void exch(Comparable[]a,int i,int j){
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void show(Comparable[]a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]+"\t");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[]a){
        for (int i = 1; i < a.length; i++) {
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

}
