package Util;
// TODO: 6/5/2020 进行foreach循环时，不能向ArrayList中添加或删除元素
/* 正则匹配
*  数组 转 ArrayList
*  当前工作目录
*  以后可能还会加上json参数设置
*/
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

public class Review {
    static Random ran = new Random();
    public static void main(String[] args) {
        ran_review();
    }

    private static void ran_review() {
        // 复习类型
        // TODO: 6/5/2020 参数传递用json 
        String[] Type ={"Array","ListNode","String","Tree","Recursive"}; // 参数用json传递
        int index = ran.nextInt(Type.length); // [0,len)
        System.out.printf("题目类型:%s\n",Type[index]);

        // 具体题目 day.*?
        String addr = System.getProperty("user.dir")+"\\"+Type[index]+"\\"+"src";  // 输出工作目录
        File file = new File(addr);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(file.list())); // 数组转Arraylist 目的是为了方便remove操作，不然存在缩容的问题
        // System.out.println("origin_list_size:"+list.size());
        String pattern = "day.*?"; // 正则表达式


        for (int i = 0; i < list.size(); i++) { // 遍历当前目录的子目录
            boolean isMatch = Pattern.matches(pattern, list.get(i)); // 利用match方法去除工具包/说明文件
            // System.out.println(list.get(i));
            // System.out.println(isMatch);
            if(isMatch != true){
                list.remove(list.get(i));
            }
        }
        // System.out.println("current_list_size:"+list.size());
        int index2 = ran.nextInt(list.size());
        System.out.println("具体题目:"+ list.get(index2));

    }
}
