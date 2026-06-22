class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width;
                if(stack.isEmpty()){
                   width = i;
                } else{
                   width= i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width;
            if(stack.isEmpty()){
                   width = n;
                } else{
                    width = n - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
