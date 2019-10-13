package Chapter2;

/**
 * 自底向上的Merge
 * 比较适合链表数据
 */
public class MergeBUSort extends Example {
    private static Comparable[]aux=null;
    @Override
    public void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz=sz*2) {//sz子数组的大小
            for (int lo = 0; lo <a.length-sz ; lo+=sz*2) {//lo 子数组索引
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-sz));
            }
        }
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
