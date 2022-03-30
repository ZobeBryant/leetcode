package 网易实习.电动车;

public class Solution2 {
    public static int test(int [] e, int [] c) {
        // 记录当前符合题意的最小坐标
        int minIndex = Integer.MAX_VALUE;
        // 差值总和
        int sum = 0;
        // 差值当前和
        int cur_sum = 0;
        for (int i = 0; i < e.length; i++) {
            // 计算差值
            int minus = e[i] - c[i];
            sum += minus;
            cur_sum += minus;
            // 如果当前和>=0，且当前标记的最小坐标没有被找到
            if (cur_sum >= 0) {
                // 更新当前最小坐标
                minIndex = Math.min(minIndex, i);
            }
            // 如果当前和<0，不可能走，重置所有状态
            else {
                minIndex = Integer.MAX_VALUE;
                cur_sum = 0;
            }
        }
        // 最后判断差值总和，如果差值总和小于0，也不可能走
        if (sum < 0)
            return -1;
        return minIndex;
    }

    public static void main(String[] args) {
        Solution2 sl = new Solution2();
        int[] e = {1,2,3,4,5};
        int[] c = {3,4,5,1,2};
        System.out.println(sl.test(e,c));

    }
}
