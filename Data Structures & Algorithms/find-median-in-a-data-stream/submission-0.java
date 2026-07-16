class MedianFinder {
    PriorityQueue<Integer> left;//max heap
    PriorityQueue<Integer> right;//min heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.isEmpty() || num <= left.peek()){
            left.offer(num);
        } else {
            right.offer(num);
        }
        if(left.size() > right.size()+1){//left ka size 1 greater rkhna h
            right.offer(left.poll());
        } else if(left.size()<right.size()){
            left.offer(right.poll());
        }
        
    }
    
    public double findMedian() {
        if(left.size()>right.size()){
            return left.peek();
        }
        return (left.peek()+right.peek()) / 2.0;
    }
}
