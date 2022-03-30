package 贪心.种花问题;

public class Solution {
    // 贪心策略：只考虑当前位置种花是否符合规则，保证在当前位置上种花不会影响已种花的情况。
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return false;
        if(flowerbed.length == 1){
            if (flowerbed[0] == 1 && n == 1)
                return false;
            else
                return true;
        }

        for(int i = 0; i < flowerbed.length; ++i){

            if(i == 0){
                // 左边界
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    flowerbed[0] = 1;
                    n--;
                }
            }else if(i == flowerbed.length - 1){
                if(flowerbed[i] == 0 && flowerbed[i-1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }else if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                // 中间位置
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0)
                return true;
        }
        return false;
    }
}
