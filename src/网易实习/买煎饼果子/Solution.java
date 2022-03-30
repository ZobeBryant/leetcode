package 网易实习.买煎饼果子;

public class Solution {
    public static int test(int[] bills) {
        if (bills.length == 0){
            return 0;
        }
        int bill5 = 2;
        int bill10 = 0;
        int ans = 0;
        for (int i = 0; i < bills.length;i++) {
            if (bills[i] == 5) {
                bill5++;
                ans++;
            } else if (bills[i] == 10) {
                if (bill5 == 0) {
                    return ans;
                } else {
                    bill5--;
                    bill10++;
                    ans++;
                }
            } else {
                if (bill10 > 0) {
                    if (bill5 > 0) {
                        bill10--;
                        bill5--;
                        ans++;
                    }
                } else {
                    if (bill5 < 3) {
                        return ans;
                    } else {
                        bill5 -= 3;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
