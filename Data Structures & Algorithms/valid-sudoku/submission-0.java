class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int r = 0 ; r < 9 ; r++){
            for(int c = 0 ; c < 9 ; c ++){
                if(board[r][c] == '.'){
                    continue;
                }
                char num = board[r][c];
                String row = num+"-row-"+r;
                String col = num+"-col-"+c; 
                String box = num+"-box-"+(r/3)+"-"+(c/3);

                if(set.contains(row)|| set.contains(col) || set.contains(box)){
                    return false;
                } else {
                    set.add(row);
                    set.add(col);
                    set.add(box);
                }
            }
        }
        return true;
    }
}
