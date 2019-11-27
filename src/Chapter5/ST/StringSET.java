package Chapter5.ST;

public class StringSET {

    private IStringST<Integer> stringST;
    private int n;//size
    public StringSET() {
        stringST=new TrieST<>();
    }

    public void add(String key){
        stringST.put(key,n++);
    }

    public void delete(String key){
        if(contains(key)){
            n--;
        }
        stringST.delete(key);
    }

    public boolean contains(String key){
        return contains(key);
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return n;
    }

    @Override
    public String toString() {
        return "StringSET{" +
                "stringST=" + stringST +
                ", n=" + n +
                '}';
    }
}
