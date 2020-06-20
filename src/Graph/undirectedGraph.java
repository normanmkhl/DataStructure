package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class undirectedGraph {
    int v;
    int e;
    int[][] adjacentMatrix;
    LinkedList<Integer>[] adj;

    public undirectedGraph(int quantity){
        this.v = quantity;
        this.e = 0;
        this.adjacentMatrix = new int [quantity][quantity];
        this.adj = new LinkedList[quantity];
        for(int i = 0 ; i < quantity; i++){
            this.adj[i] = new LinkedList<>();
        }
    }
    public void addEdges(int u, int v){
        this.adj[u].add(v);
        this.adj[v].add(u);
        this.e++;
    }
    public void addNodes(int r, int c){
        this.adjacentMatrix[r][c] = 1;
        this.adjacentMatrix[c][r] = 1;
        this.e++;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(v + " vertices, " + e + " edges\n");
        for(int i = 0; i < v; i++){
            sb.append(i + ": ");
            for(int w : adj[i]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void bfs(int s){
        boolean[] visited = new boolean[s];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.println(u + " ");
            for (int v : adj[u]){
                if(!visited[u]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }
   public void dfs(int s){
        boolean[] visited = new boolean[s];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.println(u + " ");
                for(int v : adj[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        undirectedGraph g = new undirectedGraph(4); //4 x 4 matrices
        g.addEdges(0,1);
        g.addEdges(1,2);
        g.addEdges(2,3);
        g.addEdges(3,0);
        System.out.println(g);
    }
}
