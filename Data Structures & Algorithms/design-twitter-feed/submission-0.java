class Twitter {

    // Global timestamp to keep track of tweet order
    private int time;

    // user -> users they follow
    private Map<Integer, Set<Integer>> followMap;

    // user -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    // Tweet class
    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(new Tweet(tweetId, time));

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        // Max Heap based on timestamp
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[1] - a[1]);

        // User should follow himself
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Add latest tweet of every followed user
        for (int followee : followMap.get(userId)) {

            if (!tweetMap.containsKey(followee))
                continue;

            List<Tweet> tweets = tweetMap.get(followee);

            int index = tweets.size() - 1;

            Tweet tweet = tweets.get(index);

            // {tweetId, time, followeeId, index}
            pq.offer(new int[]{
                    tweet.id,
                    tweet.time,
                    followee,
                    index
            });
        }

        while (!pq.isEmpty() && result.size() < 10) {

            int[] current = pq.poll();

            result.add(current[0]);

            int followee = current[2];
            int index = current[3];

            if (index > 0) {

                Tweet previous = tweetMap.get(followee).get(index - 1);

                pq.offer(new int[]{
                        previous.id,
                        previous.time,
                        followee,
                        index - 1
                });
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}