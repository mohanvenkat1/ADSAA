import java.util.*;
public class Dfs {
    static void DFSrec(List<List<Integer>>adj,boolean[] visited,int s){
        visited[s]=true;
        System.out.print(s + " ");
        for(int i : adj.get(s)){
            if (!visited[i]) {
                DFSrec(adj,visited,i);    
            }
            
        }
    }
    static void DFS(List<List<Integer>>adj,int s){
        boolean[] visited = new boolean[adj.size()];
        DFSrec(adj,visited,s);
    }

    static void addEdge(List<List<Integer>>adj,int s,int t){
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void main(String[] args){
        /*int V=5;
        List<List<Integer>>adj = new ArrayList<>(V);
        for(int  i=0; i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{1,2},{1,0},{2,0},{2,4}};
        for(int[]  e : edges){
            addEdge(adj, e[0], e[1]);
        }
        int s=0;
        System.out.println("DFS from source : " + s);
        DFS(adj,s);*/
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int V = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter the edges (u v) separated by spaces:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }

        System.out.println("Enter the starting vertex for DFS: ");
        int s = sc.nextInt();
        System.out.println("DFS from source: " + s);
        DFS(adj, s);
    }
    
}
