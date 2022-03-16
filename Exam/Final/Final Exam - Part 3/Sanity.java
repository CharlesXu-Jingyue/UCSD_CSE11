import tester.*;
import java.util.*;

class FinalPart3_Sanity {
    void testSum(Tester t) {
        Sum s = new Sum();
        List<String> l = new ArrayList();
        l.add("a");
        l.add("aa");
        l.add("");

        t.checkExpect(3, s.sum(l, new StringLengthSum()));
    }
}

class StringLengthSum implements Summable<String> {
    public int getVal(String s) {
        return s.length();
    }
}

// java Occurrence data_1.txt data_2.txt data_3.txt
// a, 11