package 好未来.复原ip地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 回溯
    private List<String> res = new ArrayList<>();
    private int[] nums = new int[4];
    public List<String> restoreIpAddresses(String s) {
        backTrack(s, 0, 0);
        return res;
    }

    public void backTrack(String s, int start, int segmentId){
        if(start == s.length()){
            if(segmentId == 4){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < 4; ++i){
                    if(i != 3)
                        sb.append(nums[i] + ".");
                    else
                        sb.append(nums[i]);
                }
                res.add(sb.toString());
            }
            return;
        }
        if(segmentId == 4)
            return;
        for(int i = start; i < start + 3 && i < s.length(); ++i){
            if(s.charAt(start) == '0'){
                nums[segmentId] = 0;
                backTrack(s, start + 1, segmentId + 1);
                break;
            }else{
                int num = Integer.parseInt(s.substring(start, i + 1));
                if(num > 0 && num <= 255){
                    nums[segmentId] = num;
                    backTrack(s, i + 1, segmentId + 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.restoreIpAddresses("1111");
    }

}
