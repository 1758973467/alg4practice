package Chapter2;

public class MaxPQArrayOrdered<Key extends Comparable<Key>> implements IMaxPQ<Key> {
    private int N=0;
    private Key[]pq=(Key[]) new Comparable[1];

    public MaxPQArrayOrdered(){

    }

    @Override
    public Key deleteMax() {
        if(N>0&&pq.length/4==N){
            Key[]temp=(Key[])new Comparable[pq.length/2];
            for (int i = 0; i < N; i++) {
                temp[i]=pq[i];
            }
            pq=temp;
        }
        Key max=pq[--N];
        return max;
    }

    @Override
    public void insert(Key key) {
        if(N>=pq.length){
            Key[]temp=(Key[])new Comparable[pq.length*2];
            for (int i = 0; i < N; i++) {
                temp[i]=pq[i];
            }
            pq=temp;

        }
        //insert sort内循环
        pq[N++]=key;
        for (int i = N-1; i >=1&&less(i,i-1); i--) {
            exch(i,i-1);
        }
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public Key max() {
        return pq[N-1];
    }

    private void exch(int i,int j){
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }

    private boolean less(int v,int w){
        return pq[v].compareTo(pq[w])<0;
    }
}
