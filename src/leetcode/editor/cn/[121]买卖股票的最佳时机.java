//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1324 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        //方法1.可以采用暴力遍历的方法,时间复杂度为O(n^2)
        //方法2.只能从前往后,那么我们可以用一个变量来记录买入的最小值
        if(prices.length==0){
            return 0;
        }
        int profit=0;
        int min = prices[0];
        for (int i=1;i<prices.length;i++){
            //如果利润差比profit大，则赋值给profit
            profit=Math.max(profit,prices[i]-min);
            //如果price[i]比min还要小,那就赋值给min
            min=Math.min(min,prices[i]);
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
