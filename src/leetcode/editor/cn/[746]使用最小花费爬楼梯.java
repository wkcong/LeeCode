package leetcode.editor.cn;
//数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//
// 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。 
//
// 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。 
//
// 示例 1: 
//
// 输入: cost = [10, 15, 20]
//输出: 15
//解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
// 
//
// 示例 2: 
//
// 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出: 6
//解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
// 
//
// 注意： 
//
// 
// cost 的长度将会在 [2, 1000]。 
// 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。 
// 
// Related Topics 数组 动态规划 
// 👍 409 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //从后往前看，对于第i步来说，可以从第i+1来，也可以从第i+2步来
        //用变量min来保存最小的花费，a表示i+2步，b表示i+1步
        int a=0;
        int b=0;
        for(int i=cost.length-1;i>=0;i--){
            int min = cost[i]+Math.min(a,b);
            //对于上一步来说，此时b是i+2步，min是i+1步，所以要做如下赋值
            b=a;
            a=min;
        }
        return Math.min(a,b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
