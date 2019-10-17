package Chapter2;

public class MaxPQArray<Key extends Comparable<Key>> implements IMaxPQ<Key>{
    //数组实现无序
    private Key[]pq;
    private int N=0;
    public MaxPQArray(){
        pq=(Key[])new Comparable[1];
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
        int maxIndex=0;
        for (int i = 0; i < N; i++) {
            if(pq[i].compareTo(pq[maxIndex])>0){
                maxIndex=i;
            }
        }
        //swap N,0
        Key max=pq[maxIndex];
        exch(maxIndex,--N);

        return max;
    }

    @Override
    public void insert(Key key) {
        //
        if(N>=pq.length){
            Key[]temp=(Key[])new Comparable[pq.length*2];
            for (int i = 0; i < N; i++) {
                temp[i]=pq[i];
            }
            pq=temp;

        }
        pq[N++]=key;
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
        Key max=pq[0];
        for (int i = 0; i < N; i++) {
            if(pq[i].compareTo(max)>0){
                max=pq[i];
            }
        }
        return max;
    }

    private void exch(int i,int j){
        Key temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }
}
