package 贪心.加油站;

public class Solution {
    // 时间复杂度高
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        //加油和耗油差值
        int[] cache = new int[n];

        int result=0;

        for(int i=0;i<n;++i){
            cache[i]=gas[i]-cost[i];
            result+=cache[i];
        }
        if(result<0)
            return -1;
        int pos=0;
        for(int i=0;i<n;++i){
            //如果当前加油站的加油和耗油差值为负，那么不能达到下一个加油站
            result=0;
            if(cache[i]<0)
                continue;
            for(int j=0;j<=n;++j){
                result+=cache[(i+j)%n];
                if(result<0){
                    break;
                }
            }
            if(result>= 0){
                pos=i;
                break;
            }

        }
        return pos;

    }

    // 时间复杂度o(n) 空间复杂度o(1)
    public int canCompleteCircuit2(int[] gas, int[] cost){
        int n = gas.length;
        int sum = 0;
        int curSum = 0;
        int minIndex = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            int minus = gas[i] - cost[i];
            sum += minus;
            curSum += minus;
            if(curSum < 0){
                curSum = 0;
                minIndex = Integer.MAX_VALUE;
            }else{
                minIndex = Math.min(i, minIndex);
            }
        }
        if(sum < 0)
            return -1;
        else
            return minIndex;
    }

}
