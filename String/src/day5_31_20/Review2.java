package day5_31_20;
/*
* day6/5/2020  题目描述:将一个字符串中的空格替换成 "%20"。
    Input: "A B"
    Output: "A%20B"  递归
* */
public class Review2 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("A B");
        String out = solution1(s);
        System.out.println(out);
        String out2 = solution2(s);
        System.out.println(out2);
        String out3 = solution3(s);
        System.out.println(out3);
    }

    private static String solution3(StringBuffer s) {
        if(s==null) return null;
        // 统计空格字数
        int spacenum = 0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) == ' '){
                spacenum++;
            }
        }
        int oldsize = s.length();
        int oldindex = oldsize-1;
        int newsize = oldsize + spacenum*2;
        s.setLength(newsize); // 扩容
        int newindex = newsize-1;
        while (oldindex>=0 && oldindex<=newindex){
            if (s.charAt(oldindex) == ' '){
                s.setCharAt(newindex--,'0');
                s.setCharAt(newindex--,'2');
                s.setCharAt(newindex--,'%');
            }else {
                s.setCharAt(newindex--,s.charAt(oldindex));
            }
            oldindex--;
        }
        return s.toString();
    }

    private static String solution2(StringBuffer s) {
        if(s==null)return null;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    private static String solution1(StringBuffer s) {
        return s.toString().replace(" ","%20");
    }


}
