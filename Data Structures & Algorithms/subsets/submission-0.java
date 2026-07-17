class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0 , nums , new ArrayList<>());
        return result;
    }
    void backtrack(int index , int[] nums , List<Integer> subset){
        //base case
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        //choice 1
        subset.add(nums[index]);//take
        backtrack(index+1,nums,subset);
        //backtrack
        subset.remove(subset.size() -1);//not take
        //choice 2
        backtrack(index+1 , nums, subset);
    }
}
