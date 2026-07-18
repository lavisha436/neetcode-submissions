class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0 , nums , new ArrayList<>());
        return result;
    }
    void backtrack(int index , int[] nums , List<Integer> subset){
        result.add(new ArrayList<>(subset));
        for(int i = index ; i < nums.length ; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            backtrack(i+1 , nums , subset);
            subset.remove(subset.size() - 1);
        }
    }
}
