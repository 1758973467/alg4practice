package Chapter2;

public class QuickSort extends Example {
    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if(lo>=hi)return;
        int p=paration(a,lo,hi);
        sort(a,lo,p-1);
        sort(a,p+1,hi);
    }

    private int paration(Comparable[] a, int lo, int hi) {
        int i=lo,j=hi+1;

        Comparable v=a[lo];
        while (true){
            while (less(a[++i],v)){
                if(i==hi){
                    break;
                }
            }
            while (less(v,a[--j])){

            }
            if(i>=j)break;
            exch(a,i,j);
        }

        exch(a,lo,j);
        return j;
    }
}
