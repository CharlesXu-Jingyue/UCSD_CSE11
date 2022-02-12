interface Number {
    // Methods from PA4 - DO NOT MODIFY
    int numerator();
    int denominator();
    Number add(Number n);
    Number multiply(Number n);
    double toDouble();
    String toText();

    // Task 1.1: compare
    // Your code here
    int compare(Number n);
}

class WholeNumber implements Number {

    // Task 1.1: compare 
    // Your code here
    int n;

    WholeNumber(int n) {
        this.n = n;
    }

    public int numerator() {
        return this.n;
    }

    public int denominator() {
        return 1;
    }

    public Number add(Number other) {
        return new Fraction(this.denominator()*other.numerator() + this.numerator()*other.denominator(), this.denominator()*other.denominator());
    }

    public Number multiply(Number other) {
        return new Fraction(this.numerator()*other.numerator(), this.denominator()*other.denominator());
    }

    public String toText() {
        return Integer.toString(this.n);
    }

    public double toDouble() {
        return Double.valueOf(this.n);
    }

    public int compare(Number other) {
        if(this.toDouble() > other.toDouble()) {
            return 1;
        } else if(this.toDouble() < other.toDouble()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Fraction implements Number {

    // Task 1.1: compare 
    // Your code here
    int n;
    int d;

    Fraction(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public int numerator() {
        return this.n;
    }

    public int denominator() {
        return this.d;
    }

    public Number add(Number other) {
        return new Fraction(this.denominator()*other.numerator() + this.numerator()*other.denominator(), this.denominator()*other.denominator());
    }

    public Number multiply(Number other) {
        return new Fraction(this.numerator()*other.numerator(), this.denominator()*other.denominator());
    }

    public String toText() {
        return Integer.toString(this.n) + "/" + Integer.toString(this.d);
    }

    public double toDouble() {
        return (double) n/d;
    }

    public int compare(Number other) {
        if(this.toDouble() > other.toDouble()) {
            return 1;
        } else if(this.toDouble() < other.toDouble()) {
            return -1;
        } else {
            return 0;
        }
    }
}