import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        return new ConnectedComponents().getNumberOfComponents(adj);
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
        System.out.println(numberOfComponents(adj));
    }

    public int getNumberOfComponents(ArrayList<Integer>[] adj) {
        boolean[] visitedVertices = new boolean[adj.length];

        int numComponents = 0;

        for (int i = 0; i < adj.length; i++) {
            if(!visitedVertices[i]){
                numComponents++;
            }

            visitNodes(adj, i, visitedVertices);
        }

        return numComponents;
    }

    private void visitNodes(ArrayList<Integer>[] adj, int vertexIndex, boolean[] visitedVertices) {
        if(visitedVertices[vertexIndex]){
            return;
        }

        visitedVertices[vertexIndex] = true;

        for(int adjVertex : adj[vertexIndex]){
            visitNodes(adj, adjVertex, visitedVertices);
        }
    }
}