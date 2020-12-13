//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 538 👎 0


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
    //用height保存当前树的高度
    private int height;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            height=0;
            return true;
        }
        if(root.left==null && root.right ==null){
            height=1;
            return true;
        }
        //得到左右子树的返回值以及左右子树的高度
        boolean left = isBalanced(root.left);
        int leftHeight=height;
        boolean right = isBalanced(root.right);
        int rightHeight=height;
        //更新高度
        height = Math.max(leftHeight,rightHeight)+1;
        //当满足左右子树均为平衡二叉树，以及左右子树高度的绝对值不超过1时，返回true
        return left && right && Math.abs(leftHeight-rightHeight)<=1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
