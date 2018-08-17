import java.util.Arrays;

/**
 * 对数器
 */
public class RandomArray {
    public static int[] getRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random() - (int) (value * Math.random()));
        }
        return arr;
    }

    public static int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static Boolean isEqual(int[] a, int[] b) {
        if ((null == a || a.length < 2) || (null == b || b.length < 2)) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }


}
