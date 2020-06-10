package day5_29_20;
// 题目描述: 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
//          数组中某些数字是重复的，但不知道有几个数字是重复的，
public class Review2 {
    static int[] arr = {2,3,1,0,2,5};
    static int [] arr2 = new int[1];
    static boolean res = solution(arr,arr2);

    static private boolean solution(int[] arr,int[] arr2) {
        if(arr==null){return false;}
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            while (arr[i] != i){
                if(arr[i] == arr[arr[i]]){
                    arr2[0] = arr[i];
                    return true;
                }
                swap(arr,i,arr[i]);
            }
        }
        return false;
    }

    static private void swap(int[] a,int i, int i1) {
        int i2 = a[i];
        a[i] = a[i1];
        a[i1] = i2;
    }

    public static void main(String[] args) {
        System.out.println(res);
        System.out.println(arr2[0]);
    }
}

