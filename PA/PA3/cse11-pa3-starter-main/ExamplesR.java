class R {
    String firstField;
    R secondField;
    R(String firstField, R secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }
}

class ExamplesR {
    R exampleRObject = new R("thisRObject", null);
}

/* Output error message
ExamplesR.java:11: error: cannot find symbol
    R exampleRObject = new R("thisRObject", otherRObject);
                                            ^
  symbol:   variable otherRObject
  location: class ExamplesR
1 error
*/

// I cannot construct an R object when it requires an existing R object to do so.