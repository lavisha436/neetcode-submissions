class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else{
                map.put(nums[i],1);
            }
        }
       //     List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
      //     list.sort((a,b) -> b.getValue() - a.getValue());
      //     int[] result = new int[k];
      //     for(int i = 0 ; i < k ; i ++){
      //         result[i] = list.get(i).getKey();
      //     }
      // return result;
    List <Integer>[] bucket = new ArrayList[nums.length+1];
    for(int key:map.keySet()){
        int freq = map.get(key);
        if(bucket[freq] == null){
            bucket[freq] = new ArrayList<>();
        }
        bucket[freq].add(key);
    } 
    int [] result = new int[k];
    int index = 0 ;
    for(int i = bucket.length-1; i >+ 0 && index < k ; i--){
        if(bucket[i] != null){
            for(int num : bucket[i]){
                result[index++] = num;

                if(index == k){
                    return result;
                }
            }
        }
    } return result;   
}
}
