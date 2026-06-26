class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int leftSize = (m+n+1)/2;
        int left = 0;
        int right = m;
        while(left<=right){
            int partition1 = left+(right-left)/2;//mid;
            int partition2 = leftSize-partition1;
            int l1;
            int r1;
            int l2;
            int r2;
            if(partition1 == 0){
                l1 = Integer.MIN_VALUE;
            } else {
                l1 = nums1[partition1-1];
            }
            if(partition1 == m){
                r1 = Integer.MAX_VALUE;
            } else {
                r1 = nums1[partition1];
            }
            if(partition2 == 0){
                l2 = Integer.MIN_VALUE;
            } else {
                l2 = nums2[partition2-1];
            }
             if(partition2 == n){
                r2 = Integer.MAX_VALUE;
            } else {
                r2 = nums2[partition2];
            }
            if(l1<=r2 && l2<=r1){
                if((n+m)%2 == 0){
                   return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                } else {
                   return Math.max(l1,l2);
                }
            } else if(l1>r2){
                right= partition1-1;
            } else {
                left = partition1+1;
            }
        }
        return 0.0;
    }
}
