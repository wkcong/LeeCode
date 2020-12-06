//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 409 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    //当j是第一个元素和最后一个元素时，值为1
                    list.add(1);
                }else{
                    //第i排的第j个元素，是i-1排的第j-1个元素+第j个元素
                    int sum = lists.get(i-1).get(j-1)+lists.get(i-1).get(j);
                    list.add(sum);
                }
            }
            //将每一层的list都添加进lists中
            lists.add(list);
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
