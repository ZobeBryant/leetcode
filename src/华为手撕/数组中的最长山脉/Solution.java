package 华为手撕.数组中的最长山脉;

public class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
            int tmp = 0;
            int res = 0;
            // 找到极大值点
            for(int i = 1; i < n - 1; ++i){
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1] ){
                // 找到左边边界
                int l = i - 2;
                while (l >= 0 && arr[l] < arr[l + 1]){
                    --l;
                    ++tmp;
                }
                // 找到有边界
                int r = i + 2;
                while (r < n && arr[r] < arr[r - 1]){
                    ++r;
                    ++tmp;
                }
                tmp += 3;
                res = Math.max(tmp, res);
                tmp = 0;
                if(r < n - 1){
                    i = r - 1;
                }
            }
        }
        return res;
    }
    // 简便方法
    public int longestMountain2(int[] arr) {
        int n = arr.length;
        if(n == 0)
            return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        for(int i = 1; i < n; ++i){
            left[i] = arr[i] > arr[i - 1] ? left[i - 1] + 1 : 0;
        }
        for(int i = n - 2;  i >= 0; --i){
            right[i] = arr[i] > arr[i + 1] ? right[i + 1] + 1 : 0;
        }
        for(int i = 1; i < n - 1; ++i){
            if(left[i] > 0 && right[i] > 0)
                res =  Math.max(res, left[i] + right[i] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] arr = new int[] {2,1,4,7,3,2,5};
        sl.longestMountain2(arr);


    }
}
