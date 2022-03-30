package 排序.存在重复元素3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    //TreeSet 自动平衡二叉树 窗口为k，在窗口内构造自动平衡二叉树
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0; i<nums.length;++i){
            //比nums[i]大的最小数
            Integer s = set.ceiling(nums[i]);

            if(s!=null && (long)s<=(long)nums[i]+(long)t) return true;

            //比nums[i]小的最大数
            Integer g =set.floor(nums[i]);
            if(g!=null && (long)nums[i]<=(long)g+(long)t) return true;

            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    //分配的桶号
    private long getID(long x, long w){
        return x<0?(x+1)/w -1:x/w;
    }
    //桶排序 窗口为k 每个桶的范围为[x,x+t]
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(t<0) return false;
        long w = (long)t+1;
        Map<Long,Long> d =new HashMap<>();
        for(int i=0;i<nums.length;++i){
            long m =getID(nums[i],w);
            if(d.containsKey(m)) return true;
            if(d.containsKey(m-1)&&Math.abs(d.get(m-1)-nums[i])<w) return true;
            if(d.containsKey(m+1)&&Math.abs(d.get(m+1)-nums[i])<w) return true;
            d.put(m,(long) nums[i]);
            if(i>=k) d.remove(getID(nums[i-k],w));
        }
        return false;
    }
}
