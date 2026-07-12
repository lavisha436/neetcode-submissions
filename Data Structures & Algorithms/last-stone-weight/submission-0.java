class Solution {
    //tc = nlogn , sc = n
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            if(first != second){
                pq.offer(first-second);
            }
            if(pq.isEmpty()){ // eg = 5,5,3,3
                return 0;
            }
        }
        return pq.peek();
    }
}
