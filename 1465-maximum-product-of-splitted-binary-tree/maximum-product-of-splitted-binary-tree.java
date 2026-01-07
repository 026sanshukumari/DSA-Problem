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
 *     }/
 * }
 */
class Solution {
    long TotalSum = 0;
    long maxP = 0;
    static final int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
       TotalSum = totalSum(root);
       maxproduct(root);
       return (int)(maxP%MOD);
    }
    private long totalSum(TreeNode root){
        if(root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }
    private long maxproduct(TreeNode root){
        if(root == null) return 0;
        long left = maxproduct(root.left);
        long right = maxproduct(root.right);
        long subTreeSum = root.val + left + right;
        maxP = Math.max(maxP, subTreeSum * (TotalSum - subTreeSum));
        return subTreeSum;
    }
}