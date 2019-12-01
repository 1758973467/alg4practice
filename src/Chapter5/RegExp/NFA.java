package Chapter5.RegExp;

import Chapter4.DirectedGraph.Digraph;
import Chapter4.DirectedGraph.DirectedDFS;
import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

public class NFA {
    private Digraph digraph;
    private String regexp;
    private final int m;

    public NFA(String regexp) {
        this.regexp = regexp;
        m=regexp.length();
        Stack<Integer>ops=new LinkedListStack<>();
        digraph=new Digraph(m+1);
        for (int i = 0; i < m; i++) {
            int lp=i;
            if(regexp.charAt(i)=='('||regexp.charAt(i)=='|'){
                ops.push(i);
            }else if(regexp.charAt(i)==')'){
                int or=ops.pop();

                if(regexp.charAt(or)=='|'){
                    lp=ops.pop();
                    digraph.addEdge(lp,or+1);
                    digraph.addEdge(or,i);
                }else if(regexp.charAt(or)=='C'){
                    lp=or;
                }else assert false;
            }

            if(i<m-1&&regexp.charAt(i+1)=='*'){
                digraph.addEdge(lp,i+1);
                digraph.addEdge(i+1,lp);
            }
            if(regexp.charAt(i)=='('||regexp.charAt(i)=='*'||regexp.charAt(i)==')'){
                digraph.addEdge(i,i+1);
            }
        }

        if(ops.size()!=0){
            throw new IllegalArgumentException("invalid regular expression");
        }
    }


    public boolean recognizes(String txt){
        DirectedDFS dfs = new DirectedDFS(digraph, 0);
        Bag<Integer> pc = new LinkedListBag<>();
        for (int v = 0; v < digraph.V(); v++)
            if (dfs.marked(v)) pc.add(v);

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '*' || txt.charAt(i) == '|' || txt.charAt(i) == '(' || txt.charAt(i) == ')')
                throw new IllegalArgumentException("text contains the metacharacter '" + txt.charAt(i) + "'");

            Bag<Integer> match = new LinkedListBag<Integer>();
            for (int v : pc) {
                if (v == m) continue;
                if ((regexp.charAt(v) == txt.charAt(i)) || regexp.charAt(v) == '.')
                    match.add(v+1);
            }
            dfs = new DirectedDFS(digraph, match);
            pc = new LinkedListBag<Integer>();
            for (int v = 0; v < digraph.V(); v++)
                if (dfs.marked(v)) pc.add(v);

            if (pc.size() == 0) return false;
        }

        for (int v : pc)
            if (v == m) return true;
        return false;
    }
}
