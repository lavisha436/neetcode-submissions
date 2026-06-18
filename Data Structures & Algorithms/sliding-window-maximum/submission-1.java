class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int left = 0;
        int ansIndex = 0;
        // for(int right = 0 ; right < n ; right++){
        //     pq.offer(new int[]{nums[right],right}); //add
        //     while(pq.peek()[1]<left){ //index ko left se compare kr rhe h
        //         pq.poll();
        //     }
        //     if(right-left+1 == k){
        //         result[ansIndex] = pq.peek()[0];
        //         ansIndex++;
        //         left++;
        //     }
        // }
        // return result;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int right = 0 ; right < n ; right++){
            while(!dq.isEmpty() && dq.peekFirst() < left){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(right-left+1 == k){
                result[ansIndex] = nums[dq.peekFirst()];
                ansIndex++;
                left++;
            }
        }
        return result;
    }
}
