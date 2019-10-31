package Chapter3;

import chapter1.BagQueueStack.Queue;
import chapter1.BagQueueStack.ResizingArrayQueue;
import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

public class RangeLookupCSV {
    public static void main(String[]args){
        In in=new In(args[0]);
        int keyField=Integer.parseInt(args[1]);
        int valField=Integer.parseInt(args[2]);

        IOrderKeyST<String, Queue> st=new RedBlackBST<>();
        while (in.hasNextLine()){
            String line=in.readLine();
            String[]tokens=line.split(",");
            String key=tokens[keyField];
            String val=tokens[valField];
            if(st.contains(key)){
                st.put(key,new ResizingArrayQueue());
            }
            st.get(key).enqueue(val);
        }
        while (!StdIn.isEmpty()){
            String query1=StdIn.readString();
            String query2=StdIn.readString();
            for(String key:st.keys(query1,query2)){
                StdOut.println(key+" "+st.get(key));
            }

        }
    }


}
