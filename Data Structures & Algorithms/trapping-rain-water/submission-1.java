class Solution {
    public int trap(int[] height) {
        // int n = height.length;
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];
        // leftMax[0] = height[0];
        // for(int i = 1 ; i < n ; i++){
        //     leftMax[i] = Math.max(leftMax[i-1], height[i]);
        // }
        // rightMax[n-1] = height[n-1];
        // for(int i = n-2 ; i >= 0 ; i--){
        //     rightMax[i]= Math.max(rightMax[i+1],height[i]);
        // }
        // int water = 0;
        // for(int i = 0 ; i < n ; i++){
        //     water += Math.min(leftMax[i],rightMax[i]) - height[i];
        // }
        // return water;
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;
        while(left<right){
            if(leftMax<rightMax){
                left++;
                leftMax = Math.max(leftMax,height[left]);
                water += leftMax - height[left];
                
            } else{
                right--;
                rightMax = Math.max(rightMax,height[right]);
                water+= rightMax - height[right];
              
            }
        }
        return water;
    }
}
