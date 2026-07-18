class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used  = new boolean[nums.length];
        backtrack(nums , used , new ArrayList<>());
        return result;
    }
    void backtrack(int[] nums , boolean[] used , List<Integer> current){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i]){
                continue;
            }
            //choose
            used[i] = true;
            current.add(nums[i]);
            //explore
            backtrack(nums , used , current);
            //backtrack
            current.remove(current.size()-1);
            used[i] = false;
        }
    }
}
