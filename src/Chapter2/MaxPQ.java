package Chapter2;

public class MaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key>{
    private Key[]pq;
    private int N=0;

    public MaxPQ(){

    }
    public MaxPQ(int max){
        pq=(Key [])new Comparable[max+1];
    }

    @Override
    public void insert(Key v){
        pq[++N]=v;
        swim(N);
    }


    @Override
    public Key max(){
        return pq[1];
    }

    @Override
    public Key deleteMax(){
        Key max=pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }

    private void sink(int k) {
        while (2*k<=N){
            int j=2*k;
            if(j<N&&less(j,j+1)){
                j++;
            }
            if(!less(k,j))break;
            exch(k,j);
            k=j;
        }
    }

    @Override
    public boolean isEmpty(){
        return N==0;
    }

    @Override
    public int size(){
        return N;
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

