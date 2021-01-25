public class MaxSubarray {

    public static void main(String[] args) {
        int[] arr = { 1 };
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + curMax >= 0) {
                curMax += nums[i];
            } else {
                curMax = 0;
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}
