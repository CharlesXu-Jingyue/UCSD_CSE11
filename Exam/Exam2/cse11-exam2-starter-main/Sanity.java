// Provided Sanity Tests

import tester.*;

class ProvidedArrayTests {
    ExampleArrays ea = new ExampleArrays();

    void testAverageWithoutLowest(Tester t) {
		Number[] test1 = {new WholeNumber(1) , new Fraction(4, 2), new WholeNumber(3)};
		
        t.checkExpect(ea.averageWithoutLowest(test1).toDouble(), 2.5);
	}

    void testSumPairs(Tester t) {
        Pair[] p1 = {new Pair(1,2), new Pair(3,4), new Pair(5,6)};
        Pair[] p2 = {new Pair(1,2), new Pair(3,6)};

        Pair[] expect_p1_p2 = {new Pair(2, 4), new Pair(6, 10) };
        Pair[] result_p1_p2 = ea.sumPairs(p1, p2);
        
        t.checkExpect(result_p1_p2, expect_p1_p2);
    }

    void testSumPairsEmpty(Tester t) {
        Pair[] p1 = {new Pair(1,2), new Pair(3,4), new Pair(5,6)};
        Pair[] p2 = new Pair[0];

        Pair[] expect_p1_p2 = new Pair[0];
        Pair[] result_p1_p2 = ea.sumPairs(p1, p2);

        t.checkExpect(result_p1_p2, expect_p1_p2);
    }

    void testOnRegionEdge(Tester t) {
        Region[] r1 = {new RectRegion(new Point(0,1), new Point(6,6)), new CircleRegion(new Point(0, 0), 1), new RectRegion( new Point(5,5), new Point(10, 10))};
        
        Region[] expect_r1 = {new RectRegion(new Point(0, 1), new Point(6, 6)), new CircleRegion(new Point(0, 0), 1)};
        Region[] result_r1 = ea.onRegionEdge(r1, new Point(0,1));

        t.checkExpect(result_r1, expect_r1);
    }
}

class ProvidedTweetTests {
    User u1 = new User("greg", "Greg", 12);
    User u2 = new User("greg2", "Greg2", 12);

    Tweet t1 = new TextTweet("We're already halfway through with the quarter", u1, 12);
    Tweet t2 = new ReplyTweet("Yeah, can you believe it. It still feel like the beginning of the quarter", u2, 13, t1);

    void testMostPopularAuthorOnThread(Tester t) {
        t.checkExpect(t2.mostPopularAuthorOnThread(), u2);
    }

    void testShortestTweetOnThread(Tester t) {
        t.checkExpect(t2.shortestTweetOnThread(), t1);
    }
}

class myNumberTests {
    ExampleArrays ea = new ExampleArrays();
    Number[] numbersExample = {new WholeNumber(2), new Fraction(2, 10), new WholeNumber(1), new Fraction(3, 2)};

    void testAverageWithoutLowest(Tester t) {
        t.checkExpect(ea.averageWithoutLowest(this.numbersExample).toDouble(), 1.5);
    }
}

class MyTweetTests {
    User thomas = new User("tomoxl", "Thomas Oxley", 9399);
    User adam = new User("AdamArthurMD", "Adam Arthur MD MPH", 2947);
    User bianca = new User("bianca_okeefe", "bianca", 20);
    Tweet tweet1 = new TextTweet("no need for keystrokes or voices. I created this tweet just by thinking it. #helloworldbci", this.thomas, 11500);
    Tweet tweet2 = new ReplyTweet("Welcome to Twitter! What do you want the world to know about you, and what this has been like for you?", this.adam, 50, this.tweet1);
    Tweet tweet3 = new ReplyTweet("Dad says he's just a regular guy who was given an opportunity and that it's been quite an amazing journey", this.bianca, 133, this.tweet2);
    Tweet tweet4 = new ReplyTweet("Regular guys make the best heroes.", this.adam, 23, this.tweet3);
    Tweet tweet5 = new ReplyTweet("… and regular gals, of course. Bonus point when those guys/gals are forward-looking and can see the future coming.", this.adam, 6, this.tweet3);

    void testShortestTweetOnThread(Tester t) {
        t.checkExpect(this.tweet5.shortestTweetOnThread(), tweet1);
    }
}