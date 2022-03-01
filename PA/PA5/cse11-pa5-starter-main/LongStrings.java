import tester.*;

class LongStrings {
    String[] longStrings(String[] strings, int n) {
        // Use ticker t to determing array
        int t = 0;
        for(int i = 0; i < strings.length; i ++) {
            if(strings[i].length() >= n) {
                t ++;
            }
        }
        
        // Initialize array and actually create output array
        String[] longerStrings = new String[t];
        int j = 0;
        for(int i = 0; i < strings.length; i ++) {
            if(strings[i].length() >= n) {
                longerStrings[j] = strings[i];
                j ++;
            }
        }
        return longerStrings;
    }

    // Tester methods below
    String[] testStrings1 = {"sdflkjsdflskdj", "asldkfjads", "sdf"};
    int testLength1 = 5;
    String[] expectedStrings1 = {"sdflkjsdflskdj", "asldkfjads"};

    String[] testStrings2 = {"Hello", "Hi", "How are you", "I'm good!"};
    int testLength2 = 3;
    String[] expectedStrings2 = {"Hello", "How are you", "I'm good!"};

    String[] testStrings3 = {"Today I'm going to announce a big success", "Okay", "Yay!"};
    int testLength3 = 10;
    String[] expectedStrings3 = {"Today I'm going to announce a big success"};

    String[] testStrings4 = {"asdf", "asdfg", "asdfgh"};
    int testLength4 = 10;
    String[] expectedStrings4 = {};

    void testLongStrings(Tester t) {
        t.checkExpect(longStrings(testStrings1, testLength1), this.expectedStrings1);
        t.checkExpect(longStrings(testStrings2, testLength2), this.expectedStrings2);
        t.checkExpect(longStrings(testStrings3, testLength3), this.expectedStrings3);
        t.checkExpect(longStrings(testStrings4, testLength4), this.expectedStrings4);
    }
}