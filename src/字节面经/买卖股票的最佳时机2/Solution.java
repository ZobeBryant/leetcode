package 字节面经.买卖股票的最佳时机2;

public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; ++i){
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Solution sl = new Solution();
        sl.maxProfit(prices);
    }
}
