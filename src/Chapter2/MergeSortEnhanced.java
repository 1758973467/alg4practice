package Chapter2;

public class MergeSortEnhanced extends Example {
    private static int CUTOFF = 15;
    @Override
    public void sort(Comparable[] a) {
        Comparable[]aux=new Comparable[a.length];
        sort(a,0,a.length-1,aux);
    }

    private void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {

        if(lo+CUTOFF>=hi){
            //invoke insertionSort
            for (int i = lo+1; i <=hi ; i++) {
                for (int j = i; j >lo; j--) {
                    if(less(a[j],a[j-1])){
                        exch(a,j,j-1);
                    }else {
                        break;
                    }
                }
            }
            return;
        }
        int mid=(lo+hi)/2;
        sort(a,lo,mid,aux);
        sort(a,mid+1,hi,aux);

        if(less(a[mid],a[mid+1])){
            return;
        }
        merge(a,lo,mid,hi,aux);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
        //a[lo..mid],[mid+1..hi]
        int i=lo,j=mid+1;
        for (int k = lo; k <=hi ; k++) {
            aux[k]=a[k];
        }
        for (int k = lo; k <=hi; k++) {
            if(i>mid){
                a[k]=aux[j++];
            }else if(j>hi){
                a[k]=aux[i++];
            }else if(less(aux[i],aux[j])){
                a[k]=aux[i++];
            }else{
                a[k]=aux[j++];
            }
        }
    }
}
