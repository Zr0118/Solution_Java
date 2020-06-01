package day5_31_20;

// TODO: 5/31/2020  题目描述:将一个字符串中的空格替换成 "%20"。
//    Input: "A B"
//    Output: "A%20B"

// 总结：
// 字符串的题在做的时候最好用StringBuiler/StringBuffer去做 String不可变 , StringBuiler/StringBuffer可变
// 字符串遍历可以用for + charAt(int index)的方式进行遍历

// 方法总结
// 本题可能会用到java自带的str，replace方法 （可以替换字符/字符串）

public class Day5_31_20 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("A B");
        System.out.println(solution(str));
    }

    // Java自带函数
    private static String solution(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }

    // 遍历字符串（新建字符串）
    private static String solution2(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 字符串扩容的方式（扩展在原字符串中）
    // 利用stringbuffer进行字符串扩容
    class Solution3 {
        public String replaceSpace(StringBuffer str) {
            int spacenum = 0; //统计空格数量
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == ' '){
                    spacenum++;
                }
            }
            int oldLength = str.length(); // 原字符串的长度
            int oldIndex = oldLength - 1; // 原字符串下标最大值
            int newLength = oldLength + spacenum*2; // 新字符串长度 = 原字符串长度+空格长度*2
            str.setLength(newLength); // 给原字符串扩容到新字符串的长度
            int newIndex = newLength - 1; // 新字符串下标最大值
            for(; oldIndex >= 0 && oldLength < newLength; oldIndex--){
                if(str.charAt(oldIndex) == ' '){
                    str.setCharAt(newIndex--, '0'); // 反序加入字符
                    str.setCharAt(newIndex--, '2');
                    str.setCharAt(newIndex--, '%');
                }else{
                    str.setCharAt(newIndex--, str.charAt(oldIndex));
                }
            }
            return str.toString();
        }
    }
}

