package Chapter5.RegExp;

import stdlib.StdIn;
import stdlib.StdOut;

public class Grep {
    private Grep(){}

    public static void main(String[]args){
        String regexp="(.*"+args[0]+".*)";
        NFA nfa=new NFA(regexp);
        while (StdIn.hasNextLine()){
            String line=StdIn.readLine();
            if(nfa.recognizes(line)){
                StdOut.println(line);
            }
        }
    }
}
