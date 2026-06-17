class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character,Integer> target = new HashMap<>();
        for(char ch:t.toCharArray()){
            target.put(ch,target.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> window = new HashMap<>();
        
        int left = 0;
        int have = 0;
        int need = target.size();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0 ; right < s.length() ;right++){
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(target.containsKey(ch) && window.get(ch).equals(target.get(ch))){
                have++;
            }
            while(have == need){
                if((right-left+1)< minLength){
                    minLength = right-left+1;
                    start = left;
                }
                char lChar = s.charAt(left);
                window.put(lChar,window.get(lChar)-1);
                if(target.containsKey(lChar)&&window.get(lChar)<target.get(lChar)){
                    have--;
                } 
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return"";
        }
        return s.substring(start,start+minLength);
    }
}
