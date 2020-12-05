package leetcode.editor.cn;//给定一个非空二叉树，返回其最大路径和。
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 795 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.tree.TreeNode;

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

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        //节点为空的话返回0
        if(root==null){
            return 0;
        }
        //找到左右节点的最大路径值，当值小于0，舍弃掉
        int leftSum = Math.max(0,dfs(root.left));
        int rightSum= Math.max(0,dfs(root.right));

        //当前节点的最大路径值
        int path = root.val + leftSum +rightSum;
        //更新max为最大值
        max=Math.max(max,path);
        //返回一条当前节点的最大路径值，只可能有如下三个选择
        //父节点  父+左  父+右
        return root.val+Math.max(leftSum,rightSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
