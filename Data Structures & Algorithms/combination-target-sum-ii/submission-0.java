class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
       backtrack(0 , candidates , target , new ArrayList<>());
       return result; 
    }
    void backtrack(int index , int[] candidates , int target , List<Integer> combination){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index ; i <candidates.length ; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            combination.add(candidates[i]);
            backtrack(i+1 , candidates , target - candidates[i] , combination);
            combination.remove(combination.size()-1);
        }
    }
}
