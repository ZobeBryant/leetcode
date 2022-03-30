package 剑指Offer.最小的k个数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0; i < k; ++i){
            res[i] = arr[i];
        }
        return res;
    }

    // 大根堆
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if(k == 0)
            return res;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < k; ++i){
            queue.offer(arr[i]);
        }
        for(int i = k; i < arr.length; ++i){
            if(queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for(int i = 0; i < k; ++i){
            res[i] = queue.poll();
        }
        return res;
    }

    // 快排思想
    public int[] getLeastNumbers3(int[] arr, int k) {
        if(arr.length == 0 || k == 0)
            return new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSearch(int[] nums, int l, int r, int k){
        int j = partition(nums,l, r);
        if(j == k){
            return Arrays.copyOf(nums, j + 1);
        }
        return j > k ? quickSearch(nums, l,j - 1, k) :quickSearch(nums,j+1, r, k );
    }

    public int partition(int[] nums, int l, int r){
        int pivot = nums[l];
        int i = l, j = r;
        while (i < j){
            while (nums[j] >= pivot && i < j) --j;
            while (nums[i] <= pivot && i < j) ++i;
            if(i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums,l,j);
        return j;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
