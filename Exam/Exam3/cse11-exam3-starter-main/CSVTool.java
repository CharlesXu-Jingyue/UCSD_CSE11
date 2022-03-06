// Import HashMap
import java.util.*;
import java.nio.file.*;
import java.nio.*;
import java.io.IOException;

class CSVTool {
    // Task 2: CSVTool Implementation
    // Your code here
    public static void main(String[] args) throws IOException{
        Path[] paths = new Path[args.length];
        for(int i = 0; i < paths.length; i ++) {
            paths[i] = Paths.get(args[i]);
        }

        List<String> query = Files.readAllLines(paths[0]);
        List<HashMap<String, List<Integer>>> mapList = new ArrayList<HashMap<String, List<Integer>>>(); // Initiate list of hash maps
        List<String> dataAll = new ArrayList<String>(); // Collect all data read to one list
        for(int i = 1; i < paths.length; i++) { // Read data files one-by-one
            dataAll.addAll(Files.readAllLines(paths[i]));
            List<String> data = Files.readAllLines(paths[i]);
            List<String> keys = new ArrayList<String>(); // Initialize list of keys
            List<Integer> values = new ArrayList<Integer>(); // Initialize list of values
            HashMap<String, List<Integer>> indivMap = new HashMap<String, List<Integer>>(); // Create a hash map for each individual data file, with lists of values for each instance of keys
            for(String s : data) { // Split String data to keys and values
                String[] parts = s.split(",");
                keys.add(parts[0]);
                values.add(Integer.valueOf(parts[1]));
            }
            for(int j = 0; j < keys.size(); j ++) {
                if(indivMap.containsKey(keys.get(j)) == false) {
                    List<Integer> iValue = new ArrayList<Integer>();
                    for(int k = j; k < keys.size(); k ++) { // For each new key encountered, go through the rest of data list to find other values matching the key
                        if(keys.get(k).equals(keys.get(j))) {
                            iValue.add(values.get(k));
                        }
                    }
                    indivMap.put(keys.get(j), iValue);
                }
            }
            mapList.add(indivMap);
        }
        
        HashMap<String, List<Integer>> dataMap = new HashMap<String, List<Integer>>(); // Initiate single hash map for all data, same mechanism as that for indivMap above
        List<String> keysAll = new ArrayList<String>();
        List<Integer> valuesAll = new ArrayList<Integer>();
        for(String s : dataAll) {
            String[] parts = s.split(",");
            keysAll.add(parts[0]);
            valuesAll.add(Integer.valueOf(parts[1]));
        }
        for(int i = 0; i < keysAll.size(); i ++) {
            if(dataMap.containsKey(keysAll.get(i)) == false) {
                List<Integer> iValue = new ArrayList<Integer>();
                for(int j = i; j < keysAll.size(); j ++) {
                    if(keysAll.get(j).equals(keysAll.get(i))) {
                        iValue.add(valuesAll.get(j));
                    }
                }
                dataMap.put(keysAll.get(i), iValue);
            }
        }

        HashMap<String, Integer> sumMap = new HashMap<String, Integer>();
        for(String indivKey : dataMap.keySet()) {
            Integer sum = sum(dataMap.get(indivKey));
            sumMap.put(indivKey, sum);
        }

        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        for(String indivKey : dataMap.keySet()) {
            Integer count = dataMap.get(indivKey).size();
            countMap.put(indivKey, count);
        }

        // Query-related variables
        HashMap<String, List<String>> queryMap = new HashMap<String, List<String>>(); // Create a hash map for queries
        HashMap<String, List<String>> dataFileMap = new HashMap<String, List<String>>(); // Create a hash map for data files

        String greatestQuery = query.get(0);
        String mostCommonQuery = query.get(0);
        String fileMostMatches = args[1];
        int nMatch = 0;

        for(String i : query) {
            if(dataMap.containsKey(i)) {
                if(sumMap.get(i) > sumMap.get(greatestQuery)) {
                    greatestQuery = i;
                }
                if(countMap.get(i) > countMap.get(mostCommonQuery)) {
                    mostCommonQuery = i;
                }
                List<Integer> iContains = new ArrayList<Integer>();
                for(HashMap<String, List<Integer>> j : mapList) {
                    if(j.containsKey(i)) {
                        iContains.add(mapList.indexOf(j));
                    }
                }
                List<String> fileContatins = new ArrayList<String>();
                for(int j : iContains) {
                    fileContatins.add(args[j + 1]);
                }
                queryMap.put(i, fileContatins);
            }
        }
        int f = 0;
        for(HashMap<String, List<Integer>> i : mapList) {
            if(i.get(mostCommonQuery).size() > nMatch) {
                nMatch = i.get(mostCommonQuery).size();
                f = mapList.indexOf(i);
            }
            List<String> queryContained = new ArrayList<String>();
            for(String j : query) {
                if(i.containsKey(j)) {
                    queryContained.add(j);
                }
            }
            dataFileMap.put(args[mapList.indexOf(i) + 1], queryContained);
        }
        fileMostMatches = args[f + 1];
        int greatestValue = sumMap.get(greatestQuery);
        int timesOccured = countMap.get(mostCommonQuery);

        // Output
        System.out.println("Greatest query is " + greatestQuery + " with value " + greatestValue);
        System.out.println("Most common query is " + mostCommonQuery + " and occured " + timesOccured + " time(s)");
        System.out.println("The file with the most query matches is " + fileMostMatches + " with " + nMatch + " matches");

        System.out.println();
        System.out.println("Stats:");
        // For each query
        for(String i : query) {
            if(queryMap.containsKey(i)) {
                System.out.println(queryMap.get(i).size() + " " + i + " " + queryMap.get(i));
            }
        }

        System.out.println();

        // For each data file
        for(int i = 1; i < args.length; i ++) {
                System.out.println(dataFileMap.get(args[i]).size() + " " + args[i] + " " + dataFileMap.get(args[i]));
        }
    }

    // Helper methods
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }           
}