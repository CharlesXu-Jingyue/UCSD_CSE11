/*
Your program should take in one argument that is the name of the file
to read, and print out all the lines in that file in order.
*/

import java.nio.file.*;
import java.nio.*;
import java.io.IOException;
import java.util.*;

class StringSearch {
    public static void main(String[] args) throws IOException {
        // Process args[0] to file path
        List<String> fileRead = Files.readAllLines(Paths.get(args[0]));
        String[] contents = new String[fileRead.size()];
        contents = fileRead.toArray(contents);
        printArray(contents);

        // Process args[1] to quesries
        // Process args[2] to transformations
    }

    // Helper methods
    public static void printArray(String[] contents) {
        for(String s : contents) {
            System.out.println(s);
        }
    }
}