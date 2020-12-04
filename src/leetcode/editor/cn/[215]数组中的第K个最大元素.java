package leetcode.editor.cn;//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 806 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //1.用快速排序的思想来做，sort方法就是利用快排来做的
        /*Arrays.sort(nums);
        return nums[nums.length-k];*/
        //2.快排的简化
        //我们只需要得到位置就行了，不需要关心数组是不是有序
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }
    public int quickSort(int nums[],int left,int right,int k){
        int p = partition(nums,left,right);
        if(p==k){
            return nums[p];
        }else {
            //当p>k，就只用计算左边的数组；反之就计算右边的数组
            return p>k?quickSort(nums,left,p-1,k):quickSort(nums,p+1,right,k);
        }
    }

    public int partition(int nums[],int left,int right){
        //标准的快排方法
        int i=left;
        int j=right;
        int temp = nums[left];
        while(i<j){
            while(i<j && nums[j]>temp){
                j--;
            }
            nums[i]=nums[j];
            while(i<j && nums[i]<=temp){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=temp;
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
