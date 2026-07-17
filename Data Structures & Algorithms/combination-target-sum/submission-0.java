class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0 , nums , target , new ArrayList<>());
        return result;
    }
    void backtrack(int index , int[] nums , int target , List<Integer> combination){
        //base case
        //found valid combination
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        //invalid
        if(index == nums.length || target < 0){
            return;
        }
        //choice 1
        combination.add(nums[index]);
        backtrack(index , nums , target - nums[index] , combination);

        //backtrack
        combination.remove(combination.size() -1);

        //choice 2
        backtrack(index+1 , nums , target ,  combination);
    }
}
