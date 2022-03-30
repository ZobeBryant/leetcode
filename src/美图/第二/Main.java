package 美图.第二;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.next());
        int n = sc.nextInt();
        while (n-- > 0) {
            int opt = sc.nextInt();
            if (opt == 1) {
                s.append(sc.next());
            } else if (opt == 2) {
                int pos = sc.nextInt();
                int res = find(s.toString().toCharArray(), pos - 1);
                System.out.println(res);
            }
        }
    }

    private static int find(char[] s, int pos) {
        int len = s.length;
        int i = pos + 1;
        while (i < len && s[i] != s[pos]) {
            i++;
        }
        int j = pos - 1;
        while (j >= 0 && s[j] != s[pos]) {
            j--;
        }
        if (i >= len && j < 0) {
            return -1;
        }
        if (i >= len) {
            return pos - j;
        }
        if (j < 0) {
            return i - pos;
        }
        return Math.min(i - pos, pos - j);
    }
}
