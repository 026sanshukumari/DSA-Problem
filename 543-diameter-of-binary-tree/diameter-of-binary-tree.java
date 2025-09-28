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
    int ans = 0;
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftht = height(root.left);
        int rightht = height(root.right);
        ans = Math.max(ans, leftht + rightht); //currDem of the root node
        return Math.max(leftht, rightht) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
       height(root);
       return ans;
    }
}