class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        // String cleaned = "";
        // String rev = "";
        StringBuilder cleaned = new StringBuilder();
        StringBuilder rev = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                // cleaned += ch;
                cleaned.append(ch);
            }
        }
        for(int i = cleaned.length()-1 ; i >= 0 ; i--){
            rev.append(cleaned.charAt(i));
        }
        // return cleaned.equals(rev);
        return cleaned.toString().equals(rev.toString());
    }
}
