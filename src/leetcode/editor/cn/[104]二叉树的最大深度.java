//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 756 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public int maxDepth(TreeNode root) {
        //当为null时，返回0
        if(root==null){
            return 0;
        }
        //左右子树为null时，深度为自己本身，为1
        if(root.left==null && root.right==null){
            return 1;
        }
        //先遍历左右子树,得到左右子树的深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //对于父节点来说，他的深度是左右子树的最大深度+1
        return Math.max(left,right)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
