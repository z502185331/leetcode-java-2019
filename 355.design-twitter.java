/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 *
 * https://leetcode.com/problems/design-twitter/description/
 *
 * algorithms
 * Medium (27.42%)
 * Total Accepted:    34.7K
 * Total Submissions: 126.6K
 * Testcase Example:  '["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]\n[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]'
 *
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 *
 *
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's
 * news feed. Each item in the news feed must be posted by users who the user
 * followed or by the user herself. Tweets must be ordered from most recent to
 * least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 *
 *
 * Example:
 *
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id
 * 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 *
 *
 */
 class Twitter {

     Tweet recentTweet;
     Map<Integer, Set<Integer>> connections;

     /** Initialize your data structure here. */
     public Twitter() {
         connections = new HashMap<>();
     }

     /** Compose a new tweet. */
     public void postTweet(int userId, int tweetId) {
         Tweet tweet = new Tweet(userId, tweetId);

         if (recentTweet == null) {
             recentTweet = tweet;
         } else {
             tweet.previousTweet = recentTweet;
             recentTweet = tweet;
         }
     }

     /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
     public List<Integer> getNewsFeed(int userId) {
         List<Integer> tweets = new ArrayList<>();
         Tweet cur = recentTweet;

         while (cur != null && tweets.size() < 10) {
             if (cur.userId == userId || (connections.containsKey(userId) && connections.get(userId).contains(cur.userId))) {
                 tweets.add(cur.tweetId);
             }
             cur = cur.previousTweet;
         }

         return tweets;
     }

     /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
     public void follow(int followerId, int followeeId) {
         connections.putIfAbsent(followerId, new HashSet<>());
         connections.get(followerId).add(followeeId);
     }

     /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
     public void unfollow(int followerId, int followeeId) {
         if (!connections.containsKey(followerId)) {
             return;
         }

         connections.get(followerId).remove(followeeId);
     }
 }

 class Tweet {
     int userId;
     int tweetId;
     Tweet previousTweet;

     public Tweet(int userId, int tweetId) {
         this.userId = userId;
         this.tweetId = tweetId;
     }
 }
 /**
  * Your Twitter object will be instantiated and called as such:
  * Twitter obj = new Twitter();
  * obj.postTweet(userId,tweetId);
  * List<Integer> param_2 = obj.getNewsFeed(userId);
  * obj.follow(followerId,followeeId);
  * obj.unfollow(followerId,followeeId);
  */

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
