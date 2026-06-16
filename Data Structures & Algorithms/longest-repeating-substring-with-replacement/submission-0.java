class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int result = 0;
        for(int right = 0; right<s.length() ; right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            } else {
                map.put(ch,1);
            }
            maxFreq = Math.max(maxFreq,map.get(ch));

          while((right-left+1) - maxFreq > k){
            char leftChar = s.charAt(left);
            map.put(leftChar,map.get(leftChar)-1);
            left++;
          }
          result = Math.max(result,right-left+1);
        }
        return result; 
    }
}
