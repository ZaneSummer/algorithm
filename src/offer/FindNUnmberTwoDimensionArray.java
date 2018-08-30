package offer;

public class FindNUnmberTwoDimensionArray {
    public  static boolean find(int[][] aar, int target) {
        if (null == aar || aar.length < 1 || aar[0].length < 1) {
            return false;
        }

        int rows = aar.length;
        int clumns = aar[0].length;

        int row = 0;
        int clumn = clumns - 1;

        while (row >= 0 && row < rows && clumn >= 0 && clumn < clumns) {
            if (aar[row][clumn] == target) {
                return true;
            } else if (aar[row][clumn] > target) {
                clumn--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] aar={{1,2},{23,29},{200,345}};
       boolean isHave= find(aar,20);
    }
}
