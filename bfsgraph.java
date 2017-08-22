import java.io.*;
import java.util.*;
class bfsgraph{

    private Map<Integer,LinkedList<Integer> > adjList;
    private int V;
    public bfsgraph(int v){
        V = v;
        adjList = new HashMap< Integer,LinkedList<Integer> >();

        for(int i=0 ;i<V;i++){
            adjList.put(i,new LinkedList<Integer>());
        }

    }

    public void addEdge(int u,int v){
        LinkedList<Integer> snode = adjList.get(u);
        snode.add(v);
        LinkedList<Integer> dnode = adjList.get(v);
        dnode.add(u);
    }

    public void bfs(int v){
        Queue<Integer> Q = new LinkedList<Integer>();
        boolean[] isVisited = new boolean[V];

        Q.add(v);

        while(Q.peek() != null ){
            int t = Q.poll();

            LinkedList<Integer> node = adjList.get(t);

            for(Integer i:node)
            {
                if(isVisited[i] == false){
                    isVisited[i] = true;
                    System.out.print(i+" ");
                    Q.add(i);

                }
            }
        }

    }

public static void main(String[] args ) throws Exception{

    bfsgraph G = new bfsgraph(5);

    G.addEdge(0,1);
    G.addEdge(0,2);
    G.addEdge(0,4);
    G.addEdge(1,2);

    G.bfs(1);

}
}
