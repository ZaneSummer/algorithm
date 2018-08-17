public class LandFlag {

    public static int[] partition(int[] aar, int L, int R, int num) {
        int rightP = R + 1;
        int currentP = L;
        while (currentP < rightP) {
            if (aar[currentP] <= num) {
                currentP++;
//                swap(aar, ++leftP, currentP++);
            } else if (aar[currentP] > num) {
                swap(aar, --rightP, currentP);
            } else {
                currentP++;
            }
        }
        return new int[]{currentP, rightP - 1};
    }



    private static void swap(int arr[], int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
