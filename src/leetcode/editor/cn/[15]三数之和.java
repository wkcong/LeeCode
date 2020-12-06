//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2802 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //若用暴力解法，那么首先需要保存所有的解，然后再利用hashMap去重，会比较麻烦，时间复杂度为O(n^3)
        //本题采用双指针的方法，所谓双指针，就是一个指针指向前，一个指向后，当两个相遇的时候，循环就结束了
        //1.首先对数组进行排序,排序的目的是方面后面的指针向前移动
        Arrays.sort(nums);
        int length = nums.length;
        //2.定义List<List<Integer>>保存符合要求的结果
        List<List<Integer>> lists = new ArrayList<>();
        //3.开始循环,i表示第一个元素的下标
        for(int i=0;i<length;i++){
            //4 本题是找到不同的元素，因此若元素的值相同的话，就跳过
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //5 用j表示第二个元素的下标，k表示第三个元素的下标
            //那么j从前往后，k从后往前
            int k=length-1;
            //6 target的值即为第二个元素+第三个元素的值，为负的第一个元素的值
            int target = -nums[i];
            for(int j=i+1;j<length;j++){
                //7 同样的，若第二个元素相等的话，也跳过
                if(j>(i+1) && nums[j]==nums[j-1]){
                    continue;
                }
                //8 从后往前，若第二个元素+第三个元素大于target，说明第三个元素需要小点，要往前移动
                while(j<k && nums[j]+nums[k]>target){
                    k--;
                }
                if(j==k){ //当下标相等时，说明没有符合的
                    break;
                }
                if(nums[j]+nums[k] == target){
                    //将符合条件的元素添加到lists中
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                }
            }

        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
