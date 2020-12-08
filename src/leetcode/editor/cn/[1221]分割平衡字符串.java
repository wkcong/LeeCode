//在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。 
//
// 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。 
//
// 返回可以通过分割得到的平衡字符串的最大数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "RLRRLLRLRL"
//输出：4
//解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
// 
//
// 示例 2： 
//
// 
//输入：s = "RLLLLRRRLR"
//输出：3
//解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
// 
//
// 示例 3： 
//
// 
//输入：s = "LLLLRRRR"
//输出：1
//解释：s 只能保持原样 "LLLLRRRR".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] = 'L' 或 'R' 
// 分割得到的每个字符串都必须是平衡字符串。 
// 
// Related Topics 贪心算法 字符串 
// 👍 73 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedStringSplit(String s) {
        //只要字符串中L和R的数量相等，就是平衡字符串
        //那么我们可以维护一个变量,若出现L，则加1，若出现R，则减1，当变量为0时，说明相等
        int count = 0;
        //用number来统计一共有多少种字符串
        int number=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                count++;
            }else{
                count--;
            }
            if(count==0){
                number++;
            }
        }
        return number;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
