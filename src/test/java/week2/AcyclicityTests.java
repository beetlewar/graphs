import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AcyclicityTests {
    @Test
    public void should_return_false_if_no_cycle(){
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[3];

        adj[0] = new ArrayList<Integer>();
        adj[1] = new ArrayList<Integer>();
        adj[2] = new ArrayList<Integer>();

        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(2);

        boolean b = new Acyclicity().containsCycle(adj);

        Assert.assertFalse(b);
    }

    @Test
    public void should_return_true_if_cycle_exists(){
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[4];

        adj[0] = new ArrayList<Integer>();
        adj[1] = new ArrayList<Integer>();
        adj[2] = new ArrayList<Integer>();
        adj[3] = new ArrayList<Integer>();

        adj[1].add(2);
        adj[2].add(3);
        adj[3].add(1);

        boolean b = new Acyclicity().containsCycle(adj);

        Assert.assertTrue(b);
    }
}
