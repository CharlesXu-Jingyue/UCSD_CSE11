import tester.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class ProvidedQueueTests_Sanity {
    void testAdd(Tester t) {
        Queue<Integer> q = new Queue(new ArrayList(), new IntCompare_Sanity());
        q.add(1);
    }

    void testRemove(Tester t) {
        Queue<Integer> q = new Queue(new ArrayList(), new IntCompare_Sanity());
        q.add(1);
        
        t.checkExpect(q.remove(1), true);
    }

    void testPoll(Tester t) {
        Queue<Integer> q = new Queue(new ArrayList(), new IntCompare_Sanity());
        q.add(2);
        q.add(1);
        
        t.checkExpect(q.poll(), 1);
        t.checkExpect(q.poll(), 2);
    }

    void testContains(Tester t) {
        Queue<Integer> q = new Queue(new ArrayList(), new IntCompare_Sanity());
        q.add(1);
        
        t.checkExpect(q.contains(1), true);
    }
}

class IntCompare_Sanity implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}