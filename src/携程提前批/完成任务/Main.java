package 携程提前批.完成任务;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] s = new int[n];
        int[] m = new int[n];
        int index = 0;
        while (index < n){
            s[index] = sc.nextInt();
            m[index] = sc.nextInt();
            ++index;
        }

    }
}
