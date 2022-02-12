import tester.*;

interface Tweet {
    public boolean isReplyTo(Tweet other);
    public int totalLikes();
    public String allAuthors();
    public boolean textAppearsOnThread(String text);
    public int countPopularTweet(int minNumLikes);
}

class User {
    // uninitiated fields
    String username;
    String displayName;
    int nFollowers;

    // constructor
    User(String username, String displayName, int nFollowers) {
        this.username = username;
        this.displayName = displayName;
        this.nFollowers = nFollowers;
    }

    // method definition
    String toText() {
        return this.displayName + " @" + this.username;
    }
}

class TextTweet implements Tweet {
    String contents;
    User author;
    int likes;

    TextTweet(String contents, User author, int likes) {
        this.contents = contents;
        this.author = author;
        this.likes = likes;
    }

    public boolean isReplyTo(Tweet other) {
        return false;
    }

    public int totalLikes() {
        return this.likes;
    }

    public String allAuthors() {
        return this.author.username;
    }

    public boolean textAppearsOnThread(String text) {
        return this.contents.contains(text);
    }

    public int countPopularTweet(int minNumLikes) {
        if(this.likes > minNumLikes) {
            return 1;
        } else {
            return 0;
        }
    }
}

class ReplyTweet implements Tweet {
    String contents;
    User author;
    int likes;
    Tweet replyTo;

    ReplyTweet(String contents, User author, int likes, Tweet replyTo) {
        this.contents = contents;
        this.author = author;
        this.likes = likes;
        this.replyTo = replyTo;
    }

    public boolean isReplyTo(Tweet other) {
        return this.replyTo == other;
    }

    public int totalLikes() {
        return this.likes + this.replyTo.totalLikes();
    }

    public String allAuthors() {
        return this.author.username + ";" + this.replyTo.allAuthors();
    }

    public boolean textAppearsOnThread(String text) {
        return this.contents.contains(text) || this.replyTo.textAppearsOnThread(text);
    }

    public int countPopularTweet(int minNumLikes) {
        if(this.likes > minNumLikes) {
            return 1 + this.replyTo.countPopularTweet(minNumLikes);
        } else {
            return this.replyTo.countPopularTweet(minNumLikes);
        }
    }
}

class ExampleTweets {
    User greg = new User("gregory_miranda", "Greg Miranda", 9999);
    User sanmi = new User("sanmi_adeleye", "Sanmi Adeleye", 999);
    User sangeetha = new User("sangeetha_viswanathan_sakthivel", "Sangeetha Viswanathan Sakthivel", 1000000);
    Tweet t1 = new TextTweet("Java 17 has a cool feature called records", this.sanmi, 77);
    Tweet t2 = new ReplyTweet("Hmm I wonder if we could use it for CSE11", this.greg, 12, this.t1);
    Tweet t3 = new ReplyTweet("Thought about this more, probably not yet, too new.", this.greg, 73, this.t2);
    Tweet t4 = new ReplyTweet("Yeah, good point. Maybe in 2022.", this.sanmi, 10, this.t3);
    Tweet t5 = new ReplyTweet("Yeah... I don't want to rewrite the book right this minute", this.sangeetha, 1005, this.t2);

    void testIsReplyTo(Tester t) {
        t.checkExpect(this.t1.isReplyTo(this.t2), false);
        t.checkExpect(this.t2.isReplyTo(this.t1), true);
        t.checkExpect(this.t5.isReplyTo(this.t2), true);
        t.checkExpect(this.t2.isReplyTo(this.t2), false);
        t.checkExpect(this.t4.isReplyTo(this.t3), true);
    }

    void testTotalLikes(Tester t) {
        t.checkExpect(this.t5.totalLikes(), 1005 + 12 + 77);
        t.checkExpect(this.t4.totalLikes(), 10 + 73 + 12 + 77);
        t.checkExpect(this.t1.totalLikes(), 77);
    }

    void testAllAuthors(Tester t) {
        t.checkExpect(this.t1.allAuthors(), "sanmi_adeleye");
        t.checkExpect(this.t2.allAuthors(), "gregory_miranda;sanmi_adeleye");
        t.checkExpect(this.t3.allAuthors(), "gregory_miranda;gregory_miranda;sanmi_adeleye");
        t.checkExpect(this.t5.allAuthors(), "sangeetha_viswanathan_sakthivel;gregory_miranda;sanmi_adeleye");
    }

    void testTextAppearsOnThread(Tester t) {
        t.checkExpect(this.t1.textAppearsOnThread("sanmi_adeleye"), false);
        t.checkExpect(this.t1.textAppearsOnThread("2022"), false);
        t.checkExpect(this.t1.textAppearsOnThread("cool"), true);
        t.checkExpect(this.t4.textAppearsOnThread("wonder"), true);
        t.checkExpect(this.t4.textAppearsOnThread("Java"), true);
        t.checkExpect(this.t4.textAppearsOnThread("rewrite"), false);
        t.checkExpect(this.t4.textAppearsOnThread("2022"), true);
    }

    void testCountPopularTweet(Tester t) {
        t.checkExpect(this.t1.countPopularTweet(100), 0);
        t.checkExpect(this.t2.countPopularTweet(10), 2);
        t.checkExpect(this.t3.countPopularTweet(70), 2);
        t.checkExpect(this.t5.countPopularTweet(0), 3);
    }

    /*
    // My own examples
    
    User thomas = new User("tomoxl", "Thomas Oxley", 9399);
    User adam = new User("AdamArthurMD", "Adam Arthur MD MPH", 2947);
    User bianca = new User("bianca_okeefe", "bianca", 20);
    Tweet tweet1 = new TextTweet("no need for keystrokes or voices. I created this tweet just by thinking it. #helloworldbci", this.thomas, 11500);
    Tweet tweet2 = new ReplyTweet("Welcome to Twitter! What do you want the world to know about you, and what this has been like for you?", this.adam, 50, this.tweet1);
    Tweet tweet3 = new ReplyTweet("Dad says he's just a regular guy who was given an opportunity and that it's been quite an amazing journey", this.bianca, 133, this.tweet2);
    Tweet tweet4 = new ReplyTweet("Regular guys make the best heroes.", this.adam, 23, this.tweet3);
    Tweet tweet5 = new ReplyTweet("… and regular gals, of course. Bonus point when those guys/gals are forward-looking and can see the future coming.", this.adam, 6, this.tweet3);

    void testIsReplyTo(Tester t) {
        t.checkExpect(this.tweet1.isReplyTo(this.tweet2), false);
        t.checkExpect(this.tweet2.isReplyTo(this.tweet1), true);
        t.checkExpect(this.tweet5.isReplyTo(this.tweet3), true);
        t.checkExpect(this.tweet5.isReplyTo(this.tweet2), false);
        t.checkExpect(this.tweet4.isReplyTo(this.tweet3), true);
    }

    void testTotalLikes(Tester t) {
        t.checkExpect(this.tweet5.totalLikes(), 6 + 133 + 50 + 11500);
        t.checkExpect(this.tweet4.totalLikes(), 23 + 133 + 50 + 11500);
        t.checkExpect(this.tweet1.totalLikes(), 11500);
    }

    void testAllAuthors(Tester t) {
        t.checkExpect(this.tweet1.allAuthors(), "tomoxl");
        t.checkExpect(this.tweet2.allAuthors(), "AdamArthurMD;tomoxl");
        t.checkExpect(this.tweet3.allAuthors(), "bianca_okeefe;AdamArthurMD;tomoxl");
        t.checkExpect(this.tweet5.allAuthors(), "AdamArthurMD;bianca_okeefe;AdamArthurMD;tomoxl");
    }

    void testTextAppearsOnThread(Tester t) {
        t.checkExpect(this.tweet1.textAppearsOnThread("Thomas Oxley"), false);
        t.checkExpect(this.tweet1.textAppearsOnThread("tweet"), true);
        t.checkExpect(this.tweet2.textAppearsOnThread("tweet"), true);
        t.checkExpect(this.tweet2.textAppearsOnThread("Twitter"), true);
        t.checkExpect(this.tweet3.textAppearsOnThread("Daddy"), false);
        t.checkExpect(this.tweet4.textAppearsOnThread("hero"), true);
        t.checkExpect(this.tweet5.textAppearsOnThread("of course"), true);
    }

    void testCountPopularTweet(Tester t) {
        t.checkExpect(this.tweet1.countPopularTweet(10000), 1);
        t.checkExpect(this.tweet2.countPopularTweet(100), 1);
        t.checkExpect(this.tweet3.countPopularTweet(20), 3);
        t.checkExpect(this.tweet5.countPopularTweet(0), 4);
    }
    */
}