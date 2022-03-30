package 华为秋招.仪器云;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] nums = new int[k][2];
        for(int i = 0; i < k; ++i){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int res = solve(n, k, nums);
        System.out.println(res);
    }
    private static int solve(int n, int k, int [][] nums){
        Arrays.sort(nums, ((o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o2[0] - o1[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for(int i = 0; i < n && i < k; ++i){
            minHeap.offer(new int[]{i, nums[i][0]});
        }
        int i = n;
        while (i < k){
            int[] device = minHeap.poll();
            device[1] += nums[i][0];
            minHeap.offer(device);
            ++i;
        }
        int res = 0;
        while (!minHeap.isEmpty()){
            res = Math.max(res, minHeap.poll()[1]);
        }
        return res;
    }
}
