import java.util.*;

interface Summable<T> {
    int getVal(T t);
}

class Sum {
    // Task 1: sum method
    // Your code here
    <T> int sum(List<T> list, Summable<T> t) {
        if(list.size() == 0 || list.contains(null)) {
            return 0;
        } else {
            int n = 0;
            for(int i = 0; i < list.size(); i ++) {
                n += t.getVal(list.get(i)); // this line on the stack
            }
            return n;
        }
    }
}

class CharaCountSum implements Summable<String> {
    public int getVal(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == 'a') {
                count ++;
            }
        }
        return count; // this line on the stack
    }
}

class Test {
    public static void main(String[] args) {
        Sum s = new Sum();
        List<String> list = new ArrayList<String>();
        list.add("abcde");
        list.add("abc");
        list.add("what a beautiful day");

        System.out.println(s.sum(list, new CharaCountSum())); // this line on the stack
    }
}
/*
class             method        this reference      other variables
Test              main          ignore              s = :1; list = :2; new CharaCountSum() = :3; "abcde" = :4; "abc" = :5; "what a beautiful day" = :6
Sum               sum           :1                  n = :7; t = :3
CharaCountSum     getVal        :3                  count = :8; :4
CharaCountSum     getVal        :3                  :8; :5
*/