import java.util.*;

interface Summable<T> {
    int getVal(T t);
}

class Sum {
    // Task 1: sum method
    // Your code here
    <T> int sum(List<T> list, Summable<T> t) {
        if(list.size() == 0) {
            return 0;
        } else {
            int n = 0;
            for(int i = 0; i < list.size(); i ++) {
                n += t.getVal(list.get(i));
            }
            return n;
        }
    }
}