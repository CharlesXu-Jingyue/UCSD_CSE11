import tester.*;

class DesignRecipeExamples {
    
    // Problem 1

    int perimeter(int width, int height) {

        return (width + height) * 2;

    }

    int recPeri1 = this.perimeter(2, 5);
    // Expected return: 14

    int recPeri2 = this.perimeter(8, 7);
    // Expected return: 30

    ///

    // Problem 2

    int borderArea(int smallRecWidth, int smallRecHeight,
    int largeRecWidth, int largeRecHeight) {
        
        return largeRecWidth * largeRecHeight -
        smallRecWidth * smallRecHeight;

    }

    int borA1 = this.borderArea(4, 6, 7, 12);
    // Expected return: 60

    int borA2 = this.borderArea(2, 8, 5, 10);
    // Expected return: 34

    ///

    // Problem 3
    
    // Dollar to Yuan currency converter
    int dollarToYuan(int dollar) {
        
        return dollar * 6;

    }

    int tuition = this.dollarToYuan(14500);
    /*
    This example converts the quarterly tuition of an international
    student from US dollar to Chinese Yuan (approximately)

    Expected return: 87000
    */

    int rent = this.dollarToYuan(600);
    /*
    This example converts my monthly rent from US dollar to Chinese Yuan

    Expected return: 3600
    */

    ///

    // Problem 4

    // Feet & inches to inches converted
    int feetAndInchesToInches(int feet, int inches) {

        return feet * 12 + inches;

    }

    int myHeight = this.feetAndInchesToInches(5, 9);
    /*
    This example converts my height from feet and inches to just inches

    Expected return: 69
    */

    int myDadHeight = this.feetAndInchesToInches(5, 10);
    /*
    This example converts my dad's height from feet and inches to just inches

    Expected return: 70
    */

}