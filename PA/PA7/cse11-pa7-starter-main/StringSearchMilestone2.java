/*
Your program should take in the name of the file and a single contains
query, and print all the lines that match that single contains query.
*/

import java.nio.file.*;
import java.nio.*;
import java.io.IOException;
import java.util.*;

class StringSearch {
    public static void main(String[] args) throws IOException {
        if(args.length == 1) {
            // Process args[0] to file path
            List<String> fileRead = Files.readAllLines(Paths.get(args[0]));
            String[] contents = new String[fileRead.size()];
            contents = fileRead.toArray(contents);

            printArray(contents);
        } else if(args.length == 2) {
            // Process args[0] to file path
            List<String> fileRead = Files.readAllLines(Paths.get(args[0]));
            String[] contents = new String[fileRead.size()];
            contents = fileRead.toArray(contents);
            
            // Process args[1] to queries
            String[] indQueryStr = args[1].split("&");
            Query[] indQuery = new Query[indQueryStr.length];
            for(int i = 0; i < indQueryStr.length; i ++) {
                indQuery[i] = readQuery(indQueryStr[i]);
            }

            List<String> matchContents = new ArrayList<>();
            for(String s : contents) {
                if(matchesAll(indQuery, s)) {
                    matchContents.add(s);
                }
            }
            String[] contentsMatched = new String[matchContents.size()];
            contentsMatched = matchContents.toArray(contentsMatched);

            printArray(contentsMatched);
        } else if (args.length == 3) {
            // Process args[0] to file path
            List<String> fileRead = Files.readAllLines(Paths.get(args[0]));
            String[] contents = new String[fileRead.size()];
            contents = fileRead.toArray(contents);
            
            // Process args[1] to queries
            String[] indQueryStr = args[1].split("&");
            Query[] indQuery = new Query[indQueryStr.length];
            for(int i = 0; i < indQueryStr.length; i ++) {
                indQuery[i] = readQuery(indQueryStr[i]);
            }

            List<String> matchContents = new ArrayList<>();
            for(String s : contents) {
                if(matchesAll(indQuery, s)) {
                    matchContents.add(s);
                }
            }
            String[] contentsMatched = new String[matchContents.size()];
            contentsMatched = matchContents.toArray(contentsMatched);

            // Process args[2] to transformations
        }
    }

    // Helper methods
    public static void printArray(String[] contents) {
        for(String s : contents) {
            System.out.println(s);
        }
    }

    public static Query readQuery(String q) {
        String[] indQAndP = q.split("=");
        return new Contains(indQAndP[1].substring(1, indQAndP[1].length() - 1));
    }

    public static boolean matchesAll(Query[] qs, String s) {
        boolean matchesAll = true;
        for(Query q : qs) {
            matchesAll = q.matches(s);
            if(matchesAll) {
                continue;
            } else {
                break;
            }
        }
        return matchesAll;
    }
}

// Build queries
interface Query {
    boolean matches(String s);
}

class AndQuery implements Query {
    Query q1, q2;
    AndQuery(Query q1, Query q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    public boolean matches(String s) {
        return this.q1.matches(s) && this.q2.matches(s);
    }
}

class Contains implements Query {
    String contained;

    Contains(String contained) {
        this.contained = contained;
    }

    public boolean matches(String s) {
        return s.contains(this.contained);
    }
}