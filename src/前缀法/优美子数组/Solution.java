package 前缀法.优美子数组;

public class Solution {
    // 前缀法 超时
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int[]  temp = new int[n + 1];
        int count = 0;
        temp[0] = 0;
        // 以i结尾的子数组奇数的数量
        for(int i = 0; i < n; ++i){
            if(nums[i] % 2 != 0)
                temp[i + 1] =temp[i] + 1;
            else
                temp[i + 1] = temp[i];
//            temp[i + 1] = temp[i] + nums[i] & 1;
        }
        for(int i = 0; i < n; ++i){
            if(i + k -1 >= n + 1 )
                break;
            else{
                for(int j = i + k - 1; j < n + 1; ++j){
                    if(temp[j] - temp[i] == k)
                        ++count;
                }
            }
        }
        return count;
    }

    public int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        // odd变量来记录pre[i-1]
        int odd = 0, ans = 0;
        // cnt来记录pre[i]
        cnt[0] = 1;
        for(int i = 0; i < n; ++i){
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }
}
