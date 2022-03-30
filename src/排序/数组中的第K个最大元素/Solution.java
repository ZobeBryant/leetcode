package 排序.数组中的第K个最大元素;

public class Solution {
    // 自建堆
    public int findKthLargest(int[] nums, int k) {
        int heapsize = nums.length;
        buildMaxHeap(nums, heapsize);
        int i = nums.length - 1;
        while (k > 1){
            swap(nums, 0, i);
            --i;
            --k;
            --heapsize;
           maxHeapify(nums, 0, heapsize);
        }
        return nums[0];
    }

    public void  buildMaxHeap(int[] a, int heapsize){
        // 其实是从右至左 从上到下
        for(int i = heapsize / 2 - 1; i >= 0; --i){
            maxHeapify(a, i, heapsize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapsize ){
        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
        if(l < heapsize && a[l] > a[largest]){
            largest = l;
        }
        if(r < heapsize && a[r] > a[largest]){
            largest = r;
        }
        swap(a, i, largest);
        if(i != largest){
            maxHeapify(a, largest, heapsize);
        }
    }


    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
