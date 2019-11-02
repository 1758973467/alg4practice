package Chapter3;

public class MathSET<Key>extends HashSET<Key> implements IMathSET<Key> {

    public MathSET() {
    }
    public MathSET(Key[] keys) {
        for (Key key:keys){
            this.add(key);
        }
    }

    @Override
    public void union(IMathSET<Key> a) {
        for (Key key:a){
            if(!st.contains(key)){
                st.put(key,1);
            }
        }
    }

    @Override
    public void intersect(IMathSET<Key> a) {
        for (Key key:a){
            if(!st.contains(key)){
                st.delete(key);
            }
        }
        for (Key key:st.keys()){
            if(!a.contains(key)){
                st.delete(key);
            }
        }
    }


}
