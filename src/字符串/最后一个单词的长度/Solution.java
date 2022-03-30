package 字符串.最后一个单词的长度;

public class Solution {
    //从字符串末尾开始向前遍历
    public int lengthOfLastWord(String s){
        int end=s.length()-1;
        while(end>=0 && s.charAt(end)==' ') --end;
        if(end<0) return 0;

        int start=end;

        while(start>=0 && s.charAt(start)!=' ') --start;
        return end-start;


    }


}
