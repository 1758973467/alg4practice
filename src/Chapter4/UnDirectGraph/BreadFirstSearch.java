package Chapter4.UnDirectGraph;

import Chapter4.IGraph;
import Chapter4.ISearch;
import chapter1.BagQueueStack.LinkedListQueue;
import chapter1.BagQueueStack.Queue;

public class BreadFirstSearch implements ISearch {
    private boolean marked[];
    private int count;
    public BreadFirstSearch(IGraph g, int s) {
        marked=new boolean[g.V()];
        bfs(g,s);
    }

    //TODO need test
    private void bfs(IGraph g, int s) {
        Queue<Integer>queue=new LinkedListQueue<>();
        queue.enqueue(s);
        marked[s]=true;
        count++;
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            for (int w:g.adj(v)){
                if(!marked[w]){
                    marked[w]=true;
                    count++;
                    queue.enqueue(w);
                }
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
