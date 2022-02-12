import tester.*;

class ExampleArrays {
    
    // Task 1.1: averageWithoutLowest
    // Your code here
    Number averageWithoutLowest(Number[] numbers) {
        if(numbers.length == 0) {
            return new WholeNumber(0);
        } else if (numbers.length == 1) {
            return numbers[0];
        } else {
            Number nLowest = numbers[0];
            for(Number n: numbers) {
                if(n.toDouble() <= nLowest.toDouble()) {
                    nLowest = n;
                }
            }
            Number sum = new WholeNumber(0);
            for(Number n: numbers) {
                if(n.toDouble() != nLowest.toDouble()) {
                    sum = sum.add(n);
                }
            }
            /*
            n start | n end | sum start | sum end
            2 | 2 | 0 | 2
            2/10 | 2/10 | 2 | 2
            1 | 1 | 2 | 3
            3/2 | 3/2 | 3 | 9/6
            */
            return sum.multiply(new Fraction(1, (numbers.length - 1)));
        }
    }

    // Task 1.2: sumPairs
    // Your code here
    Pair[] sumPairs(Pair[] pairs1, Pair[] pairs2) {
        if(pairs1.length <= pairs2.length) {
            Pair[] sumOfPairs = new Pair[pairs1.length];
            for(int i = 0; i < pairs1.length; i++) {
                sumOfPairs[i] = new Pair(pairs1[i].a + pairs2[i].a, pairs1[i].b + pairs2[i].b);
            }
            return sumOfPairs;
        } else {
            Pair[] sumOfPairs = new Pair[pairs2.length];
            for(int i = 0; i < pairs2.length; i = i + 1) {
                sumOfPairs[i] = new Pair(pairs1[i].a + pairs2[i].a, pairs1[i].b + pairs2[i].b);
            }
            return sumOfPairs;
        }
    }

    // Task 1.3: onRegionEdge
    // Your code here
    Region[] onRegionEdge(Region[] regions, Point p) {
        int nOnEdge = 0;
        for(int i = 0; i < regions.length; i++) {
            if(regions[i].onEdge(p)) {
                nOnEdge++;
                //onEdgeRegions[i] = regions[i];
            }
        }
        Region[] onEdgeRegions = new Region[nOnEdge];
        int t = 0;
        for(int i = 0; i < regions.length; i++) {
            if(regions[i].onEdge(p)) {
                onEdgeRegions[t] = regions[i];
                t++;
            }
        }
        return onEdgeRegions;
    }
}

class Pair {
    // Task 1.2: Pair class
    // Your code here
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

