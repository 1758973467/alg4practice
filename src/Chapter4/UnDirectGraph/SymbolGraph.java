package Chapter4.UnDirectGraph;

import Chapter3.IST;
import Chapter3.LinearProbingHashST;
 import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

public class SymbolGraph  {
    private IST<String ,Integer> st;//符号-》索引
    private String[]keys;//索引--》符号
    private Graph G;//图
    public SymbolGraph(String filename,String sp) {
        st=new LinearProbingHashST<>();
        In in=new In(filename);
        while (in.hasNextLine()){
            String[]a=in.readLine().split(sp);
            for (int i = 0; i <a.length; i++) {
                st.put(a[i],st.size());
            }
        }
        keys=new String[st.size()];
        for (String name:st.keys()){
            keys[st.get(name)]=name;
        }
        G=new Graph(st.size());
        in=new In(filename);
        while (in.hasNextLine()){
            String[]a=in.readLine().split(sp);
            int v=st.get(a[0]);
            for (int i = 0; i < a.length; i++) {
                G.addEdge(v,st.get(a[i]));
            }
        }
    }

    public boolean contains(String s){
        return st.contains(s);
    }

    public int index(String key){
        return st.get(key);
    }

    public String name(int v){
        return keys[v];
    }

    public Graph G(){
        return G;
    }

    public static void main(String []args){
        String filename=args[0];
        String delim=args[1];
        SymbolGraph sg=new SymbolGraph(filename,delim);
        Graph g=sg.G();
        while (StdIn.hasNextLine()){
            String source=StdIn.readLine();
            for(int w:g.adj(sg.index(source))){
                StdOut.println(" "+sg.name(w));
            }
        }
    }
}
