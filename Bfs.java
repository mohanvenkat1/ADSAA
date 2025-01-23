import java.util.*;

class Bfs{
    static void bfs(List<List<Integer>>adj,int s){
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr + " ");
            for(int x:adj.get(curr)){
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
            addEdge(adj,1,2);
            addEdge(adj,0,2);
            addEdge(adj,1,3);
            addEdge(adj,2,4);*/
            printGraph(adj);
    
        }
    }
    static void addEdge(List<List<Integer>>adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void printGraph(List<List<Integer>> adj) {
        System.out.println("Graph representation (Adjacency List):");
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
                addEdge(adj,1,2);
                addEdge(adj,0,2);
                addEdge(adj,1,3);
                addEdge(adj,2,4);*/
                printGraph(adj);
        
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the graph size: ");
        int V = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            addEdge(adj,1,2);
            addEdge(adj,0,2);
            addEdge(adj,1,3);
            addEdge(adj,2,4);*/
            printGraph(adj);
    
        }

        System.out.println("Enter the number of edges: ");
        int E = sc.nextInt(); // Read the number of edges
        System.out.println("Enter the edges (u v) separated by spaces:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }
        /*addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,2,4);*/
        printGraph(adj);

        System.out.println(" BFS starts from 0:  ");
        bfs(adj,0);
    }
}