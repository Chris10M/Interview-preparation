import java.util.LinkedList;
import java.util.ListIterator;

class dfsgraph{
    private LinkedList<Integer>[] adjList;
    private int V;

    public dfsgraph(int v){
        V = v;
        
        adjList = new LinkedList[V];

        for(int i = 0;i<V;i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u ,int v){
        adjList[u].add(v);       
        adjList[v].add(u);

    }

    private void dfsUtil(int src,boolean[] isVisited){
        isVisited[src] = true;
        System.out.print(src + " ");

        ListIterator<Integer> i = adjList[src].listIterator();

        while(i.hasNext()){
            int t = i.next();

            if(isVisited[t] != true){
                dfsUtil(t,isVisited);
            }
        }
        
    }
    public void dfs(){
        boolean[] isVisited = new boolean[V];

        for(int i =0 ;i<V;i++){
            if(isVisited[i] != true ){
                dfsUtil(i,isVisited);
            }
        }
    }

    public static void main(String[] args ) throws Exception{
        dfsgraph G = new dfsgraph(8);

        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(0, 7);
        G.addEdge(1, 3);
        G.addEdge(0, 3);
        G.addEdge(0, 4);

        G.dfs();
    }


}
