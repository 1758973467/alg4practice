package Chapter3;

import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

import java.io.File;

/**
 * 文件索引
 */
public class FileIndex {
    public static void main(String []args){
        IST<String,ISET<File>>st=new LinearProbingHashST<>();
        for (String filename:args){
            File file=new File(filename);
            In in=new In(file);
            while (!in.isEmpty()){
                String word=in.readString();
                if(!st.contains(word)){
                    st.put(word,new HashSET<>());
                }
                var set=st.get(word);
                set.add(file);
            }
        }
        while (!StdIn.isEmpty()){
            String query=StdIn.readString();
            if(st.contains(query)){
                for (File file :st.get(query)){
                    StdOut.println("  "+file.getName());
                }
            }
        }
    }
}
