package 一点资讯提前批.肝;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /*public int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        // write code here
        timeSchedule.sort(Comparator.comparing(o -> o.get(1)));
        int len = timeSchedule.size();
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int count = 1;
        for(int i = 0; i < len; ++i){
            ArrayList<String> time = timeSchedule.get(i);
            String start = time.get(0);
            for(int j = 0; j < i; ++j){
                String end = timeSchedule.get(j).get(1);
                if(start.compareTo(end) >= 0){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            count = Math.max(count, dp[i]);
        }
        return count;
    }*/
    public int countMaxActivity(ArrayList<ArrayList<String>> timeSchedule) {
        timeSchedule.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                if (o1.get(1).compareTo(o2.get(1)) == 0)
                    return -o1.get(0).compareTo(o2.get(0));
                else
                    return o1.get(1).compareTo(o2.get(1));
            }
        });

        int count = 1;
        String end = timeSchedule.get(0).get(1);
        int size = timeSchedule.size();
        for (int i = 1; i < size; ++i) {
            String start = timeSchedule.get(i).get(0);
            if(start.compareTo(end) >= 0){
                end = timeSchedule.get(i).get(1);
                ++count;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String >> timeSchedule = new ArrayList<>();
        timeSchedule.add(new ArrayList<>(Arrays.asList("10:00", "12:00")));
        timeSchedule.add(new ArrayList<>(Arrays.asList("03:00", "11:30")));
        timeSchedule.add(new ArrayList<>(Arrays.asList("11:30", "14:00")));
        Solution sl = new Solution();
        System.out.println(sl.countMaxActivity(timeSchedule));
    }

}