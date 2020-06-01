package day5_31_20;

// TODO: 5/31/2020  题目描述:将一个字符串中的空格替换成 "%20"。
//    Input: "A B"
//    Output: "A%20B"

/*insert(int offset,char ch),在offset位置插入字符ch。
例如：StringBuffer s=new StringBuffer("wecome");
s.insert(2,'l'),则s为"welcome"*/

// 遇到了一个问题 给字符串更换元素用(setCharAt)而不是insert() insert自动扩容

// 总结 : 总结StringBuffer 中用到的两个方法 setLength() setCharAt()

public class Review {
    public static void main(String[] args) {
        // 三种方法我都复习一下
        StringBuffer sb = new StringBuffer("A B C ");
        //System.out.println(sb.insert(6,'D')); // offset指的是偏移量，这里指的就是在“数组下标”为6的位置插入D字符
        System.out.println(solution1(sb));
        System.out.println(solution2(sb));
        System.out.println(solution3(sb));
    }

    private static String solution3(StringBuffer sb) {
        // 1.计算空格个数
        int spacenum = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)==' '){
                spacenum++;
            }
        }
        // 2.当前字符串长度
        int old_len = sb.length();
        // 3.当前字符串索引
        int old_index = sb.length()-1;

        // 4.新字符串长度
        int new_len = old_len + spacenum * 2;
        sb.setLength(new_len);
        // 5.新字符串索引
        int new_index = new_len -1;

        // 6.准备开始插入
        for (; old_index>=0 && old_len<new_len; old_index--) {
            if(sb.charAt(old_index) == ' '){
                sb.setCharAt(new_index--,'0');
                sb.setCharAt(new_index--,'2');
                sb.setCharAt(new_index--,'%');
            }else if(sb.charAt(old_index) != ' '){
                sb.setCharAt(new_index--,sb.charAt(old_index));
            }
        }
        return sb.toString();
    }

    // 遍历字符串 for + charAt()
    // charAt返回的是字符，而不是字符串
    private static String solution2(StringBuffer sb) {
        int len = sb.length();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < len ; i++) {
            if(sb.charAt(i)==' '){
                sb2.append("%20");
            }else if(sb.charAt(i)!=' '){
                sb2.append(sb.charAt(i));
            }
        }
        return sb2.toString();
    }

    // 系统自带的replace方法
    private static String solution1(StringBuffer sb) {
        return sb.toString().replace(" ","%20");
    }



}
