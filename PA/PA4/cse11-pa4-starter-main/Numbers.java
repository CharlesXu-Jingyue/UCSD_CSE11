import tester.*;

interface Number {
    int numerator();
    int denominator();
    Number add(Number other);
    Number multiply(Number other);
    String toText();
    double toDouble();
}

class WholeNumber implements Number {
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
}

class Fraction implements Number {
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
}

class Decimal implements Number {
    int mantissa;
    int exponent;

    Decimal(String decimalNumber) {
        this.mantissa = Integer.parseInt(decimalNumber.substring(0, decimalNumber.indexOf(".")) + decimalNumber.substring(decimalNumber.indexOf(".") + 1, decimalNumber.length()));
        this.exponent = decimalNumber.length() - decimalNumber.indexOf(".") - 1;
    }

    public int numerator() {
        return this.mantissa;
    }

    public int denominator() {
        return (int) Math.pow(10, exponent);
    }

    public Number add(Number other) {
        return new Fraction(this.denominator()*other.numerator() + this.numerator()*other.denominator(), this.denominator()*other.denominator());
    }

    public Number multiply(Number other) {
        return new Fraction(this.numerator()*other.numerator(), this.denominator()*other.denominator());
    }

    public String toText() {
        return Integer.toString(this.mantissa).substring(0, String.valueOf(this.mantissa).length() - this.exponent) + "." + Integer.toString(this.mantissa).substring(String.valueOf(this.mantissa).length() - this.exponent, String.valueOf(this.mantissa).length());
    }

    public double toDouble() {
        return this.mantissa/Math.pow(10, this.exponent);
    }
}

class ExampleNumbers {
    Number n1 = new WholeNumber(5);
    Number n2 = new WholeNumber(7);
    Number n3 = new Fraction(7, 2);
    Number n4 = new Fraction(1, 2);
    Number n5 = new Decimal("3.25");
    Number n6 = new Decimal("5.5");

    void testAdd(Tester t) {
        t.checkExpect(this.n1.add(this.n2).toDouble(), 12.0);
        t.checkExpect(this.n1.add(this.n3).toDouble(), 5 + 7.0/2.0);
        t.checkExpect(this.n3.add(this.n3).toDouble(), 7.0);
        t.checkExpect(this.n5.add(this.n4).toDouble(), 3.75);
    }

    void testMultiply(Tester t) {
        t.checkExpect(this.n1.multiply(this.n4).toDouble(), 2.5);
        t.checkExpect(this.n3.multiply(this.n4).toDouble(), 7.0/4.0);
        t.checkExpect(this.n6.multiply(this.n1).toDouble(), 27.5);
    }

    void testNumDem(Tester t) {
        t.checkExpect(this.n3.numerator(), 7);
        t.checkExpect(this.n1.numerator(), 5);
        t.checkExpect(this.n5.numerator(), 325);
        t.checkExpect(this.n4.denominator(), 2);
        t.checkExpect(this.n2.denominator(), 1);
        t.checkExpect(this.n6.denominator(), 10);
    }

    void testToString(Tester t) {
        t.checkExpect(this.n4.toText(), "1/2");
        t.checkExpect(this.n3.toText(), "7/2");
        t.checkExpect(this.n2.toText(), "7");
        t.checkExpect(this.n5.toText(), "3.25");
    }

    // Exploration

    // Exploration 1
    double exploration1 = 0.1 + 0.2 + 0.3;

    // Exploration 2
    double exploration2 = 0.1 + (0.2 + 0.3);

    // Initialize for explorations 3 and 4
    Number expNum1 = new Decimal("0.1");
    Number expNum2 = new Decimal("0.2");
    Number expNum3 = new Decimal("0.3");

    // Exploration 3
    String exploration3 = this.expNum3.add(this.expNum1.add(this.expNum2)).toText();

    // Exploration 4
    String exploration4 = this.expNum1.add(this.expNum2.add(this.expNum3)).toText();
}
