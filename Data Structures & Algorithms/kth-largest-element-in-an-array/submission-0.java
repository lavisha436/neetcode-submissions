class Solution {
    int partition(int[] nums , int l , int r){
        int p = nums[l];
        int i = l;
        int j = r;
        // while(i<=j){
        //     if(nums[i] < p && nums[j] > p){
        //         swap(nums, i, j);
        //         i++;
        //         j--;
        //     }
        //     if(nums[i] >= p){
        //         i++;
        //     }
        //     if(nums[j]<=p){
        //         j--;
        //     }
        // }
        while (i <= j) {
            while (i <= j && nums[i] >= p) {
                i++;
            }
            while (i <= j && nums[j] < p) {
                j--;
            }
            if (i < j) {
              swap(nums, i, j);
            }
        }
        swap(nums, l, j);
        return j;
    }

    void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int pivotIndex = 0;
        while(true){
           pivotIndex = partition(nums, l, r);
           if(pivotIndex == k-1){
            break;
           } else if(pivotIndex < k-1){
            l= pivotIndex + 1;
           } else{
            r = pivotIndex - 1;
           }
        }
        return nums[pivotIndex];
    }
}
