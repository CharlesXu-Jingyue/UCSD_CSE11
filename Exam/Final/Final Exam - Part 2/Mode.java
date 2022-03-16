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
}