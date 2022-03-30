package 猿辅导提前批.卡片交换;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] nums = s.split(" ");
        for(int i = 0; i < nums.length - 1; ++i){
            if(Integer.parseInt(nums[i]) > Integer.parseInt(nums[i + 1]) ){
                int tmp = i + 1;
                System.out.print(tmp);
                System.out.print(" ");
                break;
            }
        }
        for(int i = nums.length - 1; i >= 1; --i){
            if(Integer.parseInt(nums[i]) < Integer.parseInt(nums[i - 1])){
                int tmp = i + 1;
                System.out.print(tmp);
                break;
            }
        }


    }
}
