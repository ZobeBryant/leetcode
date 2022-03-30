package 网易实习最后一批.公交车站;/*
package 网易实习最后一批.公交车站;

import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {
    // 滑动窗口
    public  int test(int[] a, int k){
        int w = 2*k+1;
        int n = a.length;
        int left, right;
        int res = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < w; ++i ){
            left = i;
            right = left + w - 1;
            int r = 0;
            while (right < n){
                int temp = sum(a,left, right);
                if(q.size() < 4){
                    q.offer(temp);
                }else{
                    if(q.peek() < temp){
                        q.poll();
                        q.offer(temp);
                    }
                }
                left = right + 1;
                right = left + w - 1;
            }
            if(q.size() == 4){
                for(int j = 0; j < 4; ++j){
                    r += q.poll();
                }
                res = Math.max(res, r);
            }

        }

        return res;
    }
    public int sum(int[] a, int i, int j){
        int res = 0;
        while (i <= j){
            res += a[i];
            ++i;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int res = sl.test(a, 1);
        System.out.println(res);
    }
}
*/

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18} ;
        int len = 1;
        getMaxNum(arr,len);

    }


    static public void getMaxNum(int[] arr,int k){
        int len = k*2;
        int max = 0;
        int maxindex = 0;
        int res = 0;
        HashMap unreceiveMap = new HashMap();
        for(int i=0;i<arr.length-len;i++){
            int temp = 0;
            for(int j = 1;j<=len ;j++){
                int index = i+j;
                temp += arr[index];
            }
            arr[i] += temp;
            if(arr[i] > max){
                max = arr[i];
                maxindex = i;
            };
            temp = 0;
        }
        res = max;
        for(int count = 1;count <=3;count++){
            unreceiveMap.put(maxindex,max);
            //left
            for(int left=1;left<=len;left++){
                if(maxindex - left >=0){
                    unreceiveMap.put(maxindex-left,max);
                }
            }
            ////right
            for(int right=1;right<=len;right++){
                if(maxindex + right <arr.length-len){
                    unreceiveMap.put(maxindex+right,max);
                }
            }

            max = 0;
            maxindex = 0;
            for(int i=0;i<arr.length-len;i++){
                if(unreceiveMap.containsKey(i)){
                    continue;
                }
                if(arr[i] > max){
                    max = arr[i];
                    maxindex = i;
                };
            }
            res +=max;

        }

        System.out.println(res);
    }
}