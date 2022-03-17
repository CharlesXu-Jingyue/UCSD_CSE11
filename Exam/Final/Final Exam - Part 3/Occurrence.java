import java.util.ArrayList;
import java.util.*;
import java.io.IOException;
import java.nio.file.*;

class Occurrence {
    // Task 2: main method
    // Your code here
    public static void main(String[] args) throws IOException {
        Path[] paths = new Path[args.length]; // Create paths
        for(int i = 0; i < paths.length; i ++) {
            paths[i] = Paths.get(args[i]);
        }

        HashMap<String, Integer> data = new HashMap<String, Integer>(); // Read data
        for(int i = 0; i < args.length; i ++) {
            List<String> lines = new ArrayList<String>();
            lines.addAll(Files.readAllLines(paths[i]));
            for(String s : lines) {
                List<String> words = new ArrayList<String>();
                // s = s.toLowerCase();
                s = s.replaceAll(",", "");
                s = s.replaceAll("\\.", "");
                s = s.replaceAll("\\?", "");
                s = s.replaceAll("\"", "");
                s = s.replaceAll(":", "");
                s = s.replaceAll("!", "");
                s = s.replaceAll(";", "");
                words.addAll(Arrays.asList(s.split(" ")));
                for(int j = 0; j < words.size(); j ++) {
                    if(data.get(words.get(j)) == null) {
                        data.put(words.get(j), 1);
                    } else {
                        data.put(words.get(j), data.get(words.get(j)) + 1);
                    }
                }
            }
        }

        Map.Entry<String, Integer> max = null;
        for(Map.Entry<String, Integer> e : data.entrySet()) {
            if(max == null || e.getValue() > max.getValue()) {
                max = e;
            }
        }
        for(Map.Entry<String, Integer> e : data.entrySet()) {
            if(e.getValue() == max.getValue()) {
                System.out.println(e.getKey() + ", " + e.getValue());
            }
        }
    }
}