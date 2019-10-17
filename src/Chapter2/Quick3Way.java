package Chapter2;

public class Quick3Way extends Example {
    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if(lo>=hi)return;
        int lt=lo,i=lo+1,gt=hi;
        Comparable v=a[lo];
        while (i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0){
                exch(a,lt++,i++);
            }else if(cmp>0){
                exch(a,i,gt--);
            }else{
                i++;
            }
        }

        //a[lo..lt-1] [lt..gt] [gt+1..hi]
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
}
