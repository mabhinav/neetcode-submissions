class Twitter {
    private static int timestamp = 0;

    static class Tweet {
        private int tweetId;
        private int time;
        private Tweet next;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }

    static class User {
        private int userId;
        private Set<Integer> followed;
        private Tweet tweetHead;

        User(int userId) {
            this.userId = userId;
            followed = new HashSet<>();
            follow(userId);
        }

        void follow(int userId) {
            followed.add(userId);
        }

        void unfollow(int userId) {
            if (userId != this.userId) {
                followed.remove(userId);
            }
        }

        void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    private final Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        addUserIfNotPresent(userId);
        userMap.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return newsFeed;
        }

        Set<Integer> uids = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        for (int uid : uids) {
            User user = userMap.get(uid);
            if (user != null && user.tweetHead != null) {
                pq.offer(user.tweetHead);
            }
        }

        while (!pq.isEmpty() && newsFeed.size() < 10) {
            Tweet tweet = pq.poll();
            newsFeed.add(tweet.tweetId);
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        addUserIfNotPresent(followerId);
        addUserIfNotPresent(followeeId);
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        addUserIfNotPresent(followerId);
        addUserIfNotPresent(followeeId);
        userMap.get(followerId).unfollow(followeeId);
    }

    private void addUserIfNotPresent(int userId) {
        userMap.putIfAbsent(userId, new User(userId));
    }
}
