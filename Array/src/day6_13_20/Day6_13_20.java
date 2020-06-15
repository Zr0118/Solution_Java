package day6_13_20;
/*
* 题目描述
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
* */


public class Day6_13_20 {

    // 这道题思路还是利用二分去做 -- 二分查找变种 比较right
    public int minNumberInRotateArray(int [] array) {
        /* NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/
        if(array.length==0 || array == null)return 0;
        // 1.设置frist 与 end
        int left = 0, right=array.length-1;
        while (left < right){
            // 2.每次都要重新定义mid
            int middle = (left + (right-1))/2; // 防止下标越界
            if (array[middle] == array[left] && array[middle]== array[right]){
                for (int i = left; i < right; i++)
                    if (array[i] > array[i + 1])
                        return array[i + 1];
                return array[left];
            }else if(array[middle]>array[right]){
                left = middle+1;
            } else if(array[middle] <= array[right] ){
                right = middle;
            }
        }

        return array[left];
    }
}
