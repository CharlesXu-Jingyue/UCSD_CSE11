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
            Query[] indQuery = new Query[indQueryStr.length]; // Create query array
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
            for(String s : contentsMatched) {

            }
        }
    }

    // Helper methods
    public static void printArray(String[] contents) {
        for(String s : contents) {
            System.out.println(s);
        }
    }

    public static Query readQuery(String q) {
        if(q.substring(0, 3).equals("not")) {
            String indQAndP = q.substring(q.indexOf("(") + 1, q.indexOf(")"));
            return new Not(indQAndP);
        } else {
            String[] indQAndP = q.split("=");
            if(indQAndP[0].equals("contains")) {
                return new Contains(indQAndP[1].substring(1, indQAndP[1].length() - 1));
            } else if(indQAndP[0].equals("length")) {
                return new Length(indQAndP[1]);
            } else if(indQAndP[0].equals("greater")) {
                return new Greater(indQAndP[1]);
            } else if(indQAndP[0].equals("less")) {
                return new Less(indQAndP[1]);
            } else if(indQAndP[0].equals("starts")) {
                return new Starts(indQAndP[1].substring(1, indQAndP[1].length() - 1));
            } else {
                return new Ends(indQAndP[1].substring(1, indQAndP[1].length() - 1));
            }
        }
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

    public static Transform readTransform(String t) {
        String[] indTAndP = t.split("=||;");
        if(indTAndP[0].equals("upper")) {
            return new Upper();
        } else if(indTAndP[0].equals("lower")) {
            return new Lower();
        } else if(indTAndP[0].equals("first")) {
            return new First(indTAndP[1]);
        } else if(indTAndP[0].equals("last")) {
            return new Last(indTAndP[1]);
        } else {
            return new Replace(indTAndP[1], indTAndP[2]);
        }
    }

    public static String applyAll(Transform[] ts, String s) {

    }
}

// Build queries
interface Query {
    boolean matches(String s);
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

class Length implements Query { // dont forget to parseInt
    int length;

    Length(String length) {
        this.length = Integer.parseInt(length);
    }

    public boolean matches(String s) {
        return s.length() == this.length;
    }
}

class Greater implements Query { // dont forget to parseInt
    int greaterThan;

    Greater(String greaterThan) {
        this.greaterThan = Integer.parseInt(greaterThan);
    }

    public boolean matches(String s) {
        return s.length() > this.greaterThan;
    }
}

class Less implements Query { // dont forget to parseInt
    int lessThan;

    Less(String lessThan) {
        this.lessThan = Integer.parseInt(lessThan);
    }

    public boolean matches(String s) {
        return s.length() < this.lessThan;
    }
}

class Starts implements Query {
    String startsWith;

    Starts(String startsWith) {
        this.startsWith = startsWith;
    }

    public boolean matches(String s) {
        return s.substring(0, startsWith.length()).equals(startsWith);
    }
}

class Ends implements Query {
    String endsWith;

    Ends(String endsWith) {
        this.endsWith = endsWith;
    }

    public boolean matches(String s) {
        return s.substring(s.length() - endsWith.length()).equals(endsWith);
    }
}

class Not implements Query {
    String notQuery;

    Not(String notQuery) {
        this.notQuery = notQuery;
    }

    public boolean matches(String s) {
        // Construct new (other) query object based on this.notQuery and implement Query.matches(s), return the opposite of what's returned
        Query notQuery = StringSearch.readQuery(this.notQuery);
        return notQuery.matches(s) == false;
    }
}

// Build tranformations
interface Transform {
    String transform(String s);
}

class Upper implements Transform {
    public String transform(String s) {
        return s.toUpperCase();
    }
}

class Lower implements Transform {
    public String transform(String s) {
        return s.toLowerCase();
    }
}

class First implements Transform {
    int firstN;

    First(String firstN) {
        this.firstN = Integer.parseInt(firstN);
    }

    public String transform(String s) {
        if(firstN < s.length()) {
            return s.substring(0, firstN);
        } else {
            return s;
        }
    }
}

class Last implements Transform {
    int lastN;

    Last(String lastN) {
        this.lastN = Integer.parseInt(lastN);
    }

    public String transform(String s) {
        if(lastN < s.length()) {
            return s.substring(s.length() - lastN);
        } else {
            return s;
        }
    }
}

class Replace implements Transform {
    String find;
    String replace;

    Replace(String find, String replace) {
        this.find = find;
        this.replace = replace;
    }

    public String transform(String s) {
        return s.replaceAll(this.find, this.replace);
    }
}