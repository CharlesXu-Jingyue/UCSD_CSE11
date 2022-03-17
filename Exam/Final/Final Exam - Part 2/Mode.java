import java.util.HashMap;

class Mode {
    // Task 1: mode method
    // Your code here
    int mode(int[] array) {
        HashMap<Integer, Integer> intMap = new HashMap<>();
        int max = 0;
        int mode = 0;
        if(array.length == 0) {
            return 0;
        } else {
            for(int i = 0; i < array.length; i ++) {
                /*
                iteration | i | max start | max end | mode start | mode end
                1         | 0 | 0         | 1       | 0          | 1
                2         | 1 | 1         | 1       | 1          | 1
                3         | 2 | 1         | 1       | 1          | 1 
                4         | 3 | 1         | 2       | 1          | 3
                5         | 4 | 2         | 2       | 3          | 3
                */
                if(intMap.get(array[i]) == null) {
                    intMap.put(array[i], 1);
                } else {
                    int count = intMap.get(array[i]);
                    count ++;
                    intMap.put(array[i], count);
                    if(count > max) {
                        max = count;
                        mode = array[i];
                    }
                }
            }
            return mode;
        }
    }

    int[] tArray = new int[]{1, 4, 3, 3, 5};
    int t = this.mode(tArray);
}