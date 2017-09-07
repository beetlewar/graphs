import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        return new Reachability().canReach(adj, x, y) ? 1 : 0;
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }

    public boolean canReach(ArrayList<Integer>[] adj, int x, int y) {
        return canReach(adj, x, y, new boolean[adj.length]);
    }

    private boolean canReach(ArrayList<Integer>[] adj, int x, int y, boolean[] visited) {
        if (visited[x]) {
            return false;
        }

        ArrayList<Integer> xAdj = adj[x];

        visited[x] = true;

        if(hasAdj(xAdj, y)){
            return true;
        }

        for(Integer vertex : xAdj){
            boolean canReach = canReach(adj, vertex, y, visited);

            if(canReach){
                return true;
            }
        }

        return false;
    }

    private boolean hasAdj(ArrayList<Integer> adj, int vertex) {
        for (Integer i : adj) {
            if (i == vertex) {
                return true;
            }
        }

        return false;
    }
}