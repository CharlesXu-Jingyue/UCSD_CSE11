import tester.*;

class ArrayExamples{
  static String joinWith(String[] strArray, String strSeparator) {
    String strJoined = "";
    for(String s : strArray) {
      strJoined += s + strSeparator;
    }
    strJoined = strJoined.substring(0,strJoined.length()-strSeparator.length());
    return strJoined;
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
      if(d > low && d < high) {
        nDouble ++;
      }
    }
    return nDouble;
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

  /*
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
  */
}