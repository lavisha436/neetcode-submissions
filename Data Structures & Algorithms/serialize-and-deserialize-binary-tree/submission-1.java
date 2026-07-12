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

public class Codec {
    void dfs(TreeNode root , StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left , sb);
        dfs(root.right , sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    int index = 0;
    TreeNode build(String[] values){
        if(values[index].equals("null")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        index++;
        root.left = build(values);
        root.right = build(values);
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return build(values);
    }
}
