//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 793 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    /*
    *用递归的方法来处理
    //用一个List来存储所有的值
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    public void dfs(TreeNode root){
        //中序遍历的顺序是左中右
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }*/
    //用非递归的方式处理
    public List<Integer> inorderTraversal(TreeNode root) {
        //用list保存值
        List<Integer> list = new ArrayList<>();
        //非递归需要用栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root!=null ){
            //首先先遍历左子树
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            //当左子树node为空时,弹出最上面的栈元素(node的父节点)，将值添加到list中，接着遍历右子树
            root = stack.pop();
            list.add(root.val);
            root= root.left;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
