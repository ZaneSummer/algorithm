public class MaxGap {


    public static int maxGap(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }

        int result = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                result = Math.max(result, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return result;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

}
