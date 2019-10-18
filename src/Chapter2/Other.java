package Chapter2;

public class Other {
    /**
     *
     * @param a
     * @param k zero-index
     * @return
     */
    public static Comparable select(Comparable[]a,int k){
        int lo=0,hi=a.length-1;
        while (lo<hi){
            int j= Partition(a,lo,hi);
            if(j==k)return a[k];
            else if(j>k)hi=j-1;
            else lo=j+1;
        }
        return a[k];
    }
    public static Comparable selectRecsive(Comparable[]a,int k){
        return selectRecsive(a,k,0,a.length-1);
    }

    private static Comparable selectRecsive(Comparable[] a, int k, int lo, int hi) {
        if(lo>=hi){
            return a[k];
        }
        int j=Partition(a,lo,hi);
        if(j==k)return a[k];
        else if(j>k)return selectRecsive(a,k,lo,j-1);
        else return selectRecsive(a,k,j+1,hi);
    }

    private static int Partition(Comparable[] a, int lo, int hi) {

        int i=lo,j=hi+1;
        Comparable v=a[lo];
        while (i<=j){
           while (a[++i].compareTo(v)<0){
               if(i==hi){
                   break;
               }
           }
           while (a[--j].compareTo(v)>0){}
           if(i>=j)break;
            exch(a, i, j);
        }
        exch(a,lo,j);
        return j;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}
