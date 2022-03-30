package 字符串.翻转字符串里的单词;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String reverseWords(String s){
        //出去开头和末尾的空白符
        s=s.trim();
        //正则匹配连续的空白字符作为分隔符分割
        List<String> wordList= Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);

    }


}
