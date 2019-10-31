package Chapter3;

import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.ResizingArrayQueue;
import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

public class LookupIndex {
    public static void main(String[]args){
        In in=new In(args[0]);//index db
        String sp=args[1];//separator
        IST<String, Queue<String>>st=new RedBlackBST<>();
        IST<String,Queue<String>>ts=new RedBlackBST<>();

        while (in.hasNextLine()){
            String[]a=in.readLine().split(sp);
            String key=a[0];
            for (int i = 1; i < a.length; i++) {
                String val=a[i];
                if(!st.contains(key)){
                    st.put(key,new ResizingArrayQueue<>());
                }
                if(!ts.contains(val)){
                    ts.put(val,new ResizingArrayQueue<>());
                }
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }
        while (!StdIn.isEmpty()){
            String query=StdIn.readLine();
            if(st.contains(query)){
                for (String s :st.get(query)){
                    StdOut.println("  "+s);
                }
            }
            if(ts.contains(query)){
                for (String s :ts.get(query)){
                    StdOut.println("  "+s);
                }
            }
        }
    }
}
