package leetcode.editor.cn;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2670 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int b=0;
        for(int i=0;i<nums.length;i++){
            if(b>0){
                b+=nums[i];
            }else{
                b=nums[i];
            }
            sum=Math.max(sum,b);
        }
        return sum;
        //用分治法写的话代码比较多，方法是将数组一分而二，那么原来数组的最大和可能有三种情况
        //1.在左边数组里面  2.在右边数组里面   3.部分在左边数组，部分在右边数组
        //比较三种情况的最大和的大小，取最大的即可
    }
}
//leetcode submit region end(Prohibit modification and deletion)
