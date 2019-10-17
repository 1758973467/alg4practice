package Chapter2;

public class HeapSort extends Example{
    @Override
    public void sort(Comparable[] a) {
        int N=a.length;
        //构造最大堆
        for (int k = N/2; k >=0 ; k--) {
            sink(k,a,a.length);
        }
        //逐步破坏堆并完成排序
        for (int i = N-1; i >=1 ; --i) {
            //将最大的与顶部元素交换，堆的长度减一，重新构造堆
            exch(a,0,i);
            sink(0,a,i);
        }
    }

    /**
     *
     * @param k
     * @param a
     * @param N 长度
     */
    private void sink(int k,Comparable[]a,int N) {

        while (2*k+1<N){
            int j=2*k+1;
            if(j+1<N&&
            a[j].compareTo(a[j+1])<=0){
                j++;
            }
            if(a[k].compareTo(a[j])>=0)break;
            exch(a,k,j);
            k=j;
        }
    }
}
