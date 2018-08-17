public class Utils {

    /**
     * 对数器验证
     * @param arr
     * @param model
     */
    public static void testByModel(int[] arr, int[] model) {
        for (int i = 0; i < 50000; i++) {
            int[] ay = model.clone();
            if (RandomArray.isEqual (arr, RandomArray.sort(ay))) {
                if (i == 49999) {
                    System.out.println("------------匹配正确-----------");
                    printArray(model);
                }
            } else {
                System.out.println("------------匹配失败-----------");
                printArray(model);
                printArray(ay);
                break;
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + ",");
        }
    }

    public static void print(String array) {

        System.out.print(array + ",");

    }
}
