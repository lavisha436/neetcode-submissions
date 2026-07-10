/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int dfs(TreeNode root , int maxSoFar){
        if(root == null){
            return 0;
        }
        int good = 0;
        if(root.val >= maxSoFar){
            good = 1;
        }
        int newMax = Math.max(root.val , maxSoFar);
        int left = dfs(root.left , newMax);
        int right = dfs(root.right , newMax);

        return good+left+right;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root , root.val);
    }
}
