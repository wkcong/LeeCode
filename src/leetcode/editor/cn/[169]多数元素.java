//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 809 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        //方法1.按照题目描述，我们可以先将数组排序，那么n/2处总是我们需要的多数元素
        /*Arrays.sort(nums);
        return nums[nums.length/2];*/
        //以上方法的时间复杂度为O(n*logn)，因为sort方法是使用的快排算法
        //方法2.分治算法：将数组nums分成左右两部分，那么众数一定是左右数组中最多的
        //时间复杂度为O(n*logn)
        return findMajorNumber(nums,0,nums.length-1);
    }

    /*
    *从数组nums的第left个元素到第right元素中，找到最多的众数
    */
    public int findMajorNumber(int nums[],int left,int right){
        //如果只有一个元素，那么该元素就是众数
        if(left==right){
            return nums[left];
        }
        int mid = (left+right)/2 ;
        //得到左右两边数组的众数
        int leftCount = findMajorNumber(nums,left,mid);
        int rightCount = findMajorNumber(nums,mid+1,right);

        //如果两边的众数一样的话，那么就返回其中一个众数
        if(leftCount==rightCount){
            return leftCount;
        }
        //众数不同的话，分别得到众数的个数
        int leftNumber = count(nums,leftCount,left,right);
        int rightNumber= count(nums,rightCount,left,right);
        //众数个数一样的话，随便返回哪个众数都行
        if(leftNumber==rightNumber){
            return leftCount;
        }
        //哪个众数的个数多，就返回哪个众数
        return leftNumber>rightNumber?leftCount:rightCount;
    }

    public int count(int nums[],int num,int left,int right){
        int count=0;
        for(int i=left;i<=right;i++){
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
