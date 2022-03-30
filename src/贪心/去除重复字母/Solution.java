package 贪心.去除重复字母;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //腾讯一面  选定当前字符，与之前选定的字符比较大小。如果大于前一个字符或者小于前一个字符但前一个字符在字符串中只有一个，则加入StringBuilder，否则，删除前一个字符，重复之前操作。
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> count = new HashMap<>();
        Map<Character,Boolean> visited  =new HashMap<>();

        for(int i = 0;i<s.length();++i){
            if(!count.containsKey(s.charAt(i))){
                count.put(s.charAt(i),1);
                visited.put(s.charAt(i),false);
            }else{
                count.put(s.charAt(i),count.get(s.charAt(i))+1);
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();++i){

            if(!visited.get(s.charAt(i))){

                while (sb.length()>0 && sb.charAt(sb.length()-1)>s.charAt(i)){
                    if(count.get(sb.charAt(sb.length()-1))>0){
                        visited.put(sb.charAt(sb.length()-1),false);
                        sb.deleteCharAt(sb.length()-1);

                    }else{
                        break;
                    }
                }
                visited.put(s.charAt(i),true);
                sb.append(s.charAt(i));

            }
            count.put(s.charAt(i),count.get(s.charAt(i))-1);

        }
        return sb.toString();


    }

    public String removeDuplicateLetters2(String s) {

        boolean[] visited = new boolean[26];
        int[] nums = new int[26];

        for(int i=0;i<s.length();++i){
            nums[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            if(!visited[ch-'a']){

                while (sb.length()>0&&sb.charAt(sb.length()-1)>ch){
                    if(nums[sb.charAt(sb.length()-1)-'a']>0){
                        visited[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                    }else {
                        break;
                    }
                }
                sb.append(ch);
                visited[ch-'a']=true;

            }
            nums[ch-'a']--;

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.removeDuplicateLetters("bcabc");
    }

}
