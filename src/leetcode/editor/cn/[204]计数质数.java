//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 549 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int countPrimes(int n) {
            //按照官网上,使用厄拉多塞筛法
            //枚举法中有很多数其实都重复计算着是不是质数，而厄拉多塞筛法的一个主要的思想是
            //从小到大，若x是质数，那么2x、3x、4x等一定是合数
            //isPrime数组表示是否是合数，初始值都是false，即表示都是质数
            boolean [] isPrime = new boolean[n];
            int count=0;
            //注意边界条件，题目中是小于n的质数
            for(int i=2;i<n;i++){
                if(!isPrime[i]){
                    count++;
                    if((long)i*i<n){
                        //这里是从i*i开始,是因为在这之前的数已经被2、3、5这些小倍数标记过了
                        for(int j=i*i;j<n;j+=i){
                            isPrime[j]=true;
                        }
                    }
                }
            }
            return count;


            /* //枚举法
            int count=0;
            for(int i=2;i<n;i++){
                if(isPrimeNumber(i)){
                    count++;
                }
            }
            return count;
        }
        *//*
         *判断n是不是质数
         *//*
        public boolean isPrimeNumber(int n){
            if(n==2){
                return true;
            }
            //这里使用i*i降低了时间复杂度，排除了一些不必要验证的数
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    return false;
                }
            }
            return true;*/
        }
}
//leetcode submit region end(Prohibit modification and deletion)
