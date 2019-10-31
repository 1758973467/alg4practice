package Chapter3;

/**
 * 稀疏向量
 */
public class SparseVector {
    private IST<Integer,Double>st;

    public SparseVector() {
        st=new LinearProbingHashST<>();
    }
    public  int size(){
        return st.size();
    }
    public void put(int i,double x){
        st.put(i,x);

    }
    public double get(int i){
        if (!st.contains(i)) {
            return 0.0;
        }else return st.get(i);
    }
    public double dot(double[]that){
        double sum=0;
        for(int i:st.keys()){
            sum+=that[i]*this.get(i);
        }
        return sum;
    }

    public SparseVector sum(SparseVector other){
        SparseVector result=new SparseVector();
       //o(a+b)
        for(var index:st.keys()){
            var s=get(index)+other.get(index);
            if(s!=0){
                result.put(index,s);
            }
        }
        for (var index:other.st.keys()){
            var s=get(index)+other.get(index);
            if(s!=0){
                result.put(index,s);
            }
        }
        return result;
    }

}
