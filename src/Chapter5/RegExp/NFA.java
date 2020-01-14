package Chapter5.RegExp;

import Chapter4.DirectedGraph.Digraph;
import Chapter4.DirectedGraph.DirectedDFS;
import chapter1.BagQueueStack.Bag;
import chapter1.BagQueueStack.LinkedListBag;
import chapter1.BagQueueStack.LinkedListStack;
import chapter1.BagQueueStack.Stack;

public class NFA {
    private Digraph digraph;
    private String pattern;
    private final int m;

    public NFA(String pattern) {
        this.pattern = pattern;
        m=pattern.length();
        Stack<Integer>ops=new LinkedListStack<>();
        digraph=new Digraph(m+1);
        for (int i = 0; i < m; i++) {
            int lp=i;
            if(pattern.charAt(i)=='('||pattern.charAt(i)=='|'){
                ops.push(i);
            }else if(pattern.charAt(i)==')'){
                int or=ops.pop();
                //fix 多个| 会导致错误
                while (pattern.charAt(or)=='|'){
                    lp=ops.pop();
                    digraph.addEdge(lp,or+1);
                    digraph.addEdge(or,i);
                    or=lp;
                }
                lp = or;
            }

            if(i<m-1&&pattern.charAt(i+1)=='*'){
                digraph.addEdge(lp,i+1);
                digraph.addEdge(i+1,lp);
            }
            if(pattern.charAt(i)=='('||pattern.charAt(i)=='*'||pattern.charAt(i)==')'){
                digraph.addEdge(i,i+1);
            }
            System.out.printf(digraph.toString());
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
                if ((pattern.charAt(v) == txt.charAt(i)) || pattern.charAt(v) == '.')
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
