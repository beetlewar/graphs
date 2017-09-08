import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConnectedComponentsTests {
    @Test
    public void should_return_expected_number_of_components(){
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[5];

        adj[0] = new ArrayList<Integer>();
        adj[1] = new ArrayList<Integer>();
        adj[2] = new ArrayList<Integer>();
        adj[3] = new ArrayList<Integer>();
        adj[4] = new ArrayList<Integer>();

        adj[0].add(1);
        adj[1].add(0);

        adj[1].add(2);
        adj[2].add(1);

        ConnectedComponents connectedComponents = new ConnectedComponents();
        int number = connectedComponents.getNumberOfComponents(adj);

        Assert.assertEquals(3, number);
    }
}
