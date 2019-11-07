package Chapter4.UnDirectGraph;

import stdlib.StdIn;
import stdlib.StdOut;

public class DegreesOfSeparation {
    public static void main(String[]args){
        SymbolGraph sg=new SymbolGraph(args[0],args[1]);
        Graph g=sg.G();
        String source=args[2];
        if(!sg.contains(source)){
            StdOut.println(source+" NOT in database");
            return;
        }
        int s=sg.index(source);
        BreadthFirstPaths bfs=new BreadthFirstPaths(g,s);
        while (!StdIn.isEmpty()){
            String sink=StdIn.readLine();
            if(sg.contains(sink)){
                int t=sg.index(sink);
                if(bfs.hasPathTo(t)){
                    for (int v:bfs.pathTo(t)){
                        StdOut.println("  "+sg.name(v));
                    }
                }else StdOut.println("NOT connected");
            }
        }
    }
}
