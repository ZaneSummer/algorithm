public class Main {
    static int[] array = {2, 9, 5, 5,5,11, 10,5, 3, 0};

    //2 5 1 9 3 0 10
    public static void main(String[] args) {
        int[] ay = RandomArray.getRandomArray(50, 100);
        int[] by = ay.clone();
//        testBymodel(inseartSort(ay), ay);
//        bubbleSort(ay);
//        bubbleSort2(ay);
//        selectSort(ay);
//        mergeSort(ay, 0, ay.length - 1);
//        testBymodel(ay, by);
//        int[] ary = {1, 3, 4, 2, 5};
//        mergeSort(ary, 0, 4);
//        LandFlag.partition(ay, 0, ay.length - 1, 23);
//        quickSort(ay,0,ay.length-1);
//        HeapSort.heapSort(ay);
//        CommonUtils.testByModel(ay,by);
//        printArray(ay);
//        CommonUtils.print(MaxGap.maxGap(array)+"");
        ArrayQueue as=new ArrayQueue(3);
        as.push(1);
        as.push(2);
        as.push(3);

        CommonUtils.print( as.pop()+"");
        CommonUtils.print( as.pop()+"");
        CommonUtils.print( as.pop()+"");
        as.push(4);
        as.push(5);
        CommonUtils.print( as.pop()+"");
        CommonUtils.print( as.pop()+"");
    }


    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {//-1为了防止溢出
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    private static void bubbleSort2(int[] arr) {
        if (null == arr || arr.length < 2) return;
        for (int end = arr.length - 1; end > 0; end--) {
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        if (null == arr || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min)
                swap(arr, i, min);
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static int[] inseartSort(int[] arr) {
        if (null == arr || arr.length < 2) return new int[0];
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        return arr;
    }

    //{2, 9, 5, 1, 10, 3, 0};

    /**
     * mid= 0+6/2=3 l=0 r=6 getMax(arr,0,3)
     * mid=0+3/2=1 l=0 r=3 getMax(aar ,0,1)
     * mid=0+1/2=0 l=0 r=1 getMax(0,0) arr[0]=2
     * maxleft=2
     */
    private static int getMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int maxleft = getMax(arr, l, mid);
        int maxright = getMax(arr, mid + 1, r);
        return Math.max(maxleft, maxright);
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int pl = l, pr = m + 1, k = 0;
        while (pl <= m && pr <= r) {
           /* 逆序对问题
           if (arr[pl] > arr[pr]) {
                for (int i = pl; i <pr; i++) {
                    print("【" + arr[i] + "," + arr[pr] + "】");
                }
            }*/
            temp[k++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }

        while (pl <= m) {
            temp[k++] = arr[pl++];
        }
        while (pr <= r) {
            temp[k++] = arr[pr++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[l++] = temp[i];
        }
    }

    /**
     * 归并排序 最小和问题
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int minSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
//        int mid = (l + r) / 2;
        int mid = l + ((r - l) >> 1);
        return minSum(arr, l, mid) +
                minSum(arr, mid + 1, r) +
                mergeNum(arr, l, mid, r);
    }

    private static int mergeNum(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int pl = l, pr = m + 1, k = 0;
        int res = 0;
        while (pl <= m && pr <= r) {
            res += arr[pl] < arr[pr] ? (r - pr + 1) * arr[pl] : 0;
            temp[k++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }

        while (pl <= m) {
            temp[k++] = arr[pl++];
        }
        while (pr <= r) {
            temp[k++] = arr[pr++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[l++] = temp[i];
        }
        return res;
    }


    /**
     * 快速排序
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr,l+(int)Math.random()*(r-l+1),r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);

        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int  pr = r;
        while (l < pr) {
            if (arr[l] <=arr[r]) {
                l++;
            } else if (arr[l] > arr[r]) {
                swap(arr, --pr, l);
            }

        }
        swap(arr,pr,r);
        return new int[]{l,pr};
    }






    private static void swap(int arr[], int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + ",");
        }
    }

    private static void print(String array) {

        System.out.print(array + ",");

    }
}
