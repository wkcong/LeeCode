//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 557 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //用max来表示最大路径
    int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        //深度优先搜索遍历
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        //当root为null时，返回0
        if(root==null){
            return 0;
        }
        //分别求出父节点到左右子树的路径贡献值
        int left = dfs(root.left);
        int right= dfs(root.right);
        //和最大路径进行比较
        max = Math.max(left+right,max);

        //返回最大的一条路径，注意路径只能从父节点-->左子树 和 父节点-->右子树,选择其中的最大值
        //不管选择哪条路径，左或右子树到父节点都会有一条边存在
        return Math.max(left,right)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
