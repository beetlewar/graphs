import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        return new Acyclicity().containsCycle(adj) ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }

    public boolean containsCycle(ArrayList<Integer>[] adj) {
        for(int i = 0; i < adj.length; i++){
            if(containsCycle(adj, i, new boolean[adj.length], new boolean[adj.length])){
                return true;
            }
        }

        return false;
    }

    private boolean containsCycle(ArrayList<Integer>[] adj, int currentIndex, boolean[] visiting, boolean[] visited){
        if(visiting[currentIndex]){
            return visited[currentIndex] == false;
        }

        visiting[currentIndex] = true;

        for(int adjVertex : adj[currentIndex]){
            if(containsCycle(adj, adjVertex, visiting, visited)){
                return true;
            }
        }

        visited[currentIndex] = true;

        return false;
    }
}