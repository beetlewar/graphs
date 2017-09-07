import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReachabilityTests {
    @Test
    public void should_return_false_when_cannot_reach(){
        Reachability reachability = new Reachability();

        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[3];

        adj[0] = new ArrayList<Integer>();
        adj[1] = new ArrayList<Integer>();
        adj[2] = new ArrayList<Integer>();

        adj[0].add(1);
        adj[1].add(0);

        boolean b = reachability.canReach(adj, 0, 2);

        Assert.assertFalse(b);
    }

    @Test
    public void should_return_true_when_can_reach(){
        Reachability reachability = new Reachability();

        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[4];

        adj[0] = new ArrayList<Integer>();
        adj[1] = new ArrayList<Integer>();
        adj[2] = new ArrayList<Integer>();
        adj[3] = new ArrayList<Integer>();

        adj[0].add(1);
        adj[1].add(0);

        adj[1].add(2);
        adj[2].add(1);

        adj[2].add(3);
        adj[3].add(2);

        boolean b = reachability.canReach(adj, 0, 3);

        Assert.assertTrue(b);
    }
}
