package 双指针.水果成蓝;

import java.util.HashSet;
import java.util.Set;


public class Solution {
    // 双指针方法
    public int totalFruit(int[] tree) {
        int n = tree.length;
        if(n == 1)
            return 1;
        // left表示第一类水果 right表示第二类水果
        int left = 0, right = 1;
        Set<Integer> set = new HashSet<>();
        set.add(tree[0]);
        // 找到第二类水果
        while (right < n && set.contains(tree[right]))
            ++right;
        if(right == n)
            return n;
        set.add(tree[right]);
        ++right;
        int max = 0;
        while (right < n){
            // 如果当前水果类型包含在记录的两类水果中，移动right
            if(set.contains(tree[right]))
                ++right;
            else {
                // 如果不包含 清除set，更新水果树最大总量
                set.clear();
                max = Math.max(right - left, max);
                left = right - 1;
                // left移动到与tree[right-1]相同的最小的位置
                while ( left > 1 && tree[left-1] == tree[left] )
                    --left;
                set.add(tree[left]);
                set.add(tree[right]);
                ++right;
            }

        }
        // max还需再更新一次 加入tree中只有两种类型，那么while循环中将不更新max的值
        return Math.max(right - left, max);
    }
    // 三指针方法 固定第一种类型left和第二种类型right的位置，移动第三个指针i，如果i是两种类型之一，则移动i；否则，更新left，right位置

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] a = new int[]{0,1,6,6,4,4,6};
        sl.totalFruit(a);

    }
}
