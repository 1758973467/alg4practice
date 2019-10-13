package Chapter2;

/*
* 自顶向下排序
* */
public class MergeSort extends Example{

    private Comparable[]aux=null;//归并所需的辅助数组
    @Override
    public void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //将 a[lo..hi]排序
        if(lo>=hi)return;
        int mid=(lo+hi)/2;
        sort(a,lo,mid);//将左半边排序
        sort(a,mid+1,hi);//将右半边排序
        merge(a,lo,mid,hi);//归并
    }

    private void merge(Comparable[]a,int lo,int mid,int hi){
        //将a[lo..mid] 和a[mid+1..hi]归并
        int i=lo,j=mid+1;
        //将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k]=a[k];
        }

        for (int k = lo; k <=hi ; k++) {
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
