import tester.*;

class ArrayExamples{
  static String joinWith(String[] stringArray, String stringSeparator) {
    String stringJoined = "";
    for(String s : stringArray) {
      stringJoined += s + stringSeparator;
    }
    stringJoined = stringJoined.substring(0,stringJoined.length()-stringSeparator.length());
    return stringJoined;
  }
  
  static boolean somethingFalse(boolean[] booleanArray) {
    int nFalse = 0;
    if(booleanArray.length == 0) {
      return false;
    } else {
      for(boolean b : booleanArray) {
        if(b == false) {
          nFalse ++;
        }
      }
      if(nFalse > 0) {
        return true;
      } else {
        return false;
      }
    }
  }

  static int countWithinRange(double[] doubleArray, double low, double high) {
    int nDouble = 0;
    for(double d : doubleArray) {
      if(d >= low && d <= high) {
        nDouble ++;
      }
    }
    return nDouble;
  }

  static double[] numsWithinRange(double[] doubleArray, double low, double high) {
    int t = 0;
    for(double d : doubleArray) {
      if(d >= low && d <= high) {
        t ++;
      }
    }

    double[] trueDoubles = new double[t];
    int j = 0;
    for(double d : doubleArray) {
      if(d >= low && d <= high) {
        trueDoubles[j] = d;
        j ++;
      }
    }
    return trueDoubles;
  }

  static Pair maxmin(int[] intArray) {
    int min = intArray[0];
    int max = intArray[0];
    for(int i : intArray) {
      if(i < min) {
        min = i;
      } else if(i > max) {
        max = i;
      }
    }
    Pair pairMaxMin = new Pair(min, max);
    return pairMaxMin;
  }

  static String earliest(String[] stringArray) {
    String earliestString = stringArray[0];
    for(String s : stringArray) {
      if(s.compareTo(earliestString) < 0) {
        earliestString = s;
      }
    }
    return earliestString;
  }
}

class Pair {
  int a;
  int b;

  Pair(int a, int b) {
    this.a = a;
    this.b = b;
  }
}

class ProvidedArrayExamples {
  void testJoinWith(Tester t){
    String[] example1 = {"a", "b","c"};
    t.checkExpect(ArrayExamples.joinWith(example1, ":"), "a:b:c");
  }

  void testSomethingFalse(Tester t){
    boolean[] example1 = {true, false};
    t.checkExpect(ArrayExamples.somethingFalse(example1), true);
  }

  void testCountWithinRange(Tester t){
    double[] example = {0.1, 1.3, 2.6};
    t.checkExpect(ArrayExamples.countWithinRange(example, 1.1, 2.2), 1);
  }

  void testNumsWithinRange(Tester t){
    double[] example = {0.0, 3.0, 1.4, 1.5, 2.7, 9.1, 2.1};
    double[] expected = {1.4, 1.5, 2.1};
    t.checkExpect(ArrayExamples.numsWithinRange(example, 1.1, 2.2), expected);
  }

  void testMaxmin(Tester t){
    int[] example = {4, 5, 2, 3, 1};
    t.checkExpect(ArrayExamples.maxmin(example), new Pair(1, 5));
  }

  void testEarliest(Tester t){
    String[] example = {"aa", "aab", "abcd", "a"};
    t.checkExpect(ArrayExamples.earliest(example), "a");
  }
}