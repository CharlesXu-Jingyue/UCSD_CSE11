class Interest {
    // Task 1: simpleInterest method
    // Your code here
    double simpleInterest(double P, double r, double t) { // The method calculates the simple interest and rounds it to two decimal places
        double rounded = Math.round(P*r*t);
        return rounded/100;
    }

    double t1 = this.simpleInterest(100, 5, 5); // Expected: 25.0
    double t2 = this.simpleInterest(400, 1.5, 2); // Expected: 12.0

    // Task 2: compoundInterest method
    // Your code here
    double compoundInterest(double P, double r, double t, double n) { // Mark
        double C = P*(Math.pow((1 + (r/100)/n), t*n) - 1); // Calculate
        double roundedC = Math.round(C*100); // Round
        return roundedC/100; // Return
    }

    double t3 = this.compoundInterest(100, 5, 2, 6); // Expected: 10.47
    double t4 = this.compoundInterest(300, 1.5, 5.13, 9.2); // Expected: 23.98
}
