package offer;

/**
 *剑指offer-旋转数组的最小数
 *题目描述
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 *
 */

public class ReverseArrayGetMin {
    public static int getMin(int[] array) {
        if (null == array || array.length < 2) {
            throw new IllegalArgumentException("input array length more than 2 ");
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]) {
            if (right-left==1) {
                return array[right];
            }
            mid = left + (right - left) / 2;
            if (array[left] == array[mid] && array[mid] == array[right] && array[left] == array[right]) {
                return getMinNumber(array, left, right);
            }
            if (array[left] < array[mid]) {
                left = mid;
            } else {
                right = mid;
            }

        }
        return array[mid];
    }


    public static int getMinNumber(int arr[], int start, int end) {
        int result = arr[start];
        for (int n = start + 1; n <= end; n++) {
            if (arr[n] < result) {
                result = arr[n];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={21,22,23,7,8,9};
      int num=getMin(arr);
        System.out.println("min="+num);
    }
}
