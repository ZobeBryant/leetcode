package 网易实习.买煎饼果子;

public class Solution2 {
    private static int solve(int[] money) {
        int five = 2;
        int ten = 0;
        int res = 0;
        for (int m : money) {
            if (m == 5) {
                five++;
            } else if (m == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return res;
                }
            } else if (m == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else {
                    return res;
                }
            }
            res++;
        }
        return res;
    }
}
