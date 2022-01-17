// import tester.*;

// class definition
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

// class definition
class Tweet {

    // uninitiated fields
    String tweetContent;
    User author; // reference to current User
    int nLikes;
    String tweetID;

    // constructor
    Tweet(String tweetContent, User author, int nLikes, String tweetID) {
        this.tweetContent = tweetContent;
        this.author = author;
        this.nLikes = nLikes;
        this.tweetID = tweetID;
    }

    // method definitions
    boolean longerThan(Tweet other) {
        return this.tweetContent.length() > other.tweetContent.length();
    }
    boolean moreLikes(Tweet other) {
        return this.nLikes > other.nLikes;
    }
    String toText() {
        return this.author.displayName + " @" + this.author.username + ": " + this.tweetContent + ": " + this.nLikes + "Likes";
    }
    String toLink() {
        return "https://twitter.com/" + this.author.username + "/status/" + tweetID;
    }
}

// class definition
class ExampleTweets {

    // construct objects for comparison 1
    User author1 = new User("UCSanDiego", "UC San Diego", 45900);
    Tweet thisTweet1 = new Tweet("In response to the considerable spike in new COVID-19 cases, we are extending the mandatory remote instruction period until the end of January. In-person instruction is scheduled to begin on Monday, January 31. Read the full notice: http://bit.ly/3HIImdu",
    this.author1, 86, "1479249599713976322?cxt=HHwWhIC50Y3rrIcpAAAA");
    // source Tweet: https://twitter.com/UCSanDiego/status/1479249599713976322?cxt=HHwWhIC50Y3rrIcpAAAA
    // answer: No.
    Tweet other1 = new Tweet("Announcing the kickoff of our exceptional 2022 BC3 program with talks from Claudia Jakubzic @claudjak, Marie-Caroline Dieu-Nosjean, and Yasmine Lounici. Please mark your calendars for next week Wednesday, Jan 19. #Bcells #TLS #immunology #CANCER @BcellBruno",
    this.author1, 20, "1482056562113859584?cxt=HHwWgMCqnemlqZEpAAAA");
    // source Tweet: https://twitter.com/hollern_daniel/status/1482056562113859584?cxt=HHwWgMCqnemlqZEpAAAA
    // answer: No.
    
    // 5 examples for comparison 1
    String userInfo1 = this.author1.toText();
    boolean isLonger1 = this.thisTweet1.longerThan(this.other1);
    boolean moreLiked1 = this.thisTweet1.moreLikes(this.other1);
    String displayTweet1 = this.thisTweet1.toText();
    String TweetURL1 = this.thisTweet1.toLink();

    // construct objects for comparison 2
    User author2 = new User("UCSanDiego", "UC San Diego", 45900);
    Tweet thisTweet2 = new Tweet("A pioneering program at UC San Diego Health Sciences serves as a successful model for medical schools looking to improve faculty diversity and success.",
    this.author2, 5, "1482836058450677767?cxt=HHwWjsC-wb3ii5QpAAAA");
    // source Tweet: https://twitter.com/UCSanDiego/status/1482836058450677767?cxt=HHwWjsC-wb3ii5QpAAAA
    // answer: No.
    Tweet other2 = new Tweet("To further develop our commitment to open science, Nature Neuroscience is now opening up our platform by publishing more opinion and commentary from the neuroscience community #Editorial",
    this.author2, 20, "1443243314229174279?cxt=HHwWjoCz0bmJt4coAAAA");
    // source Tweet: https://twitter.com/NatureNeuro/status/1443243314229174279?cxt=HHwWjoCz0bmJt4coAAAA
    // answer: Yes, I couldn't include the emoji at the end.
    
    // 5 examples for comparison 2
    String userInfo2 = this.author2.toText();
    boolean isLonger2 = this.thisTweet2.longerThan(this.other2);
    boolean moreLiked2 = this.thisTweet2.moreLikes(this.other2);
    String displayTweet2 = this.thisTweet2.toText();
    String TweetURL2 = this.thisTweet2.toLink();
}