//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 567 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        //若s以0开始，则无法解码
        if(s.startsWith("0")){
            return 0;
        }
        int length = s.length();
        //考虑状态转移方程
        //用dp[i] 和nodp[i]分别记录第i个字符合并和不合并的情况，那么两个值相加就是总的情况了
        //若第i位不和上一位合并，则该位一定不为0,则总数就是i-1位的情况
        //nodp[i]=dp[i-1]+nodp[i-1]
        //若合并，则和上一位的值小于等于26，并且上一位没和上上位合并
        //dp[i]=nodp[i-1]
        //总数为 dp[i]+nodp[i]

        //1.将string 转换为数组,这样处理的时候会方便点，只能一个字符一个字符的转
        int numbers[] = new int[length];
        for(int i=0;i<length;i++){
            numbers[i]=Integer.valueOf(s.charAt(i)+"");
        }
        //2.初始化dp和nodp数组
        int dp[]=new int[length];
        int nodp[]=new int[length];
        //只有一个元素时，是无法合并的情况，因为没有上一个元素
        dp[0]=0;
        nodp[0]=1;
        for(int i=1;i<length;i++){
            nodp[i]=dp[i-1]+nodp[i-1];
            dp[i]=nodp[i-1];
            if(numbers[i]==0){
                //当第i个字符为0时，则一定是合并的情况
                nodp[i]=0;
            }
            if((numbers[i]+numbers[i-1]*10)>26){
                //当和上一个字符组成的数字大于26时，则一定是不合并的情况
                dp[i]=0;
            }
        }
        return dp[length-1]+nodp[length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
