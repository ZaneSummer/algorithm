/**
 * 2*i+1 左孩子
 * 2*i+2 右孩子
 * (i-1)/2 父节点
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if(null==arr||arr.length<1){
            return;
        }
        for(int i=0;i<arr.length;i++){
            heapInseart(arr,i);
        }
        int heapSize=arr.length;
//        Utils.swap(arr,0,--heapSize);
        while (heapSize>0){
            Utils.swap(arr,0,--heapSize);
            heapify(arr,0,heapSize);
        }

    }

    public static void heapInseart(int[] arr, int end) {
        while (arr[end] > arr[(end - 1) / 2]) {
            Utils.swap(arr, end, (end - 1) / 2);
            end = (end - 1) / 2;
        }

    }

    public static void heapify(int[] arr, int end, int heapSize) {
        int left = 2 * end + 1;
        while (left < heapSize) {
            int longest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            longest = arr[longest] > arr[end] ? longest : end;
            if (longest == end) {
                break;
            }
            Utils.swap(arr, longest, end);
            end = longest;
            left = end * 2 + 1;
        }
    }
}
