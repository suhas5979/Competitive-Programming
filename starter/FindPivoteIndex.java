public class FindPivoteIndex {
    public static void main(String[] args) {
        int[] arr = { -1, -1, -1, -1, -1, 0 };

        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return -1;
        int leftSum = nums[0];
        int rightSum = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (leftSum == rightSum && right - left == 2)
                return left + 1;
            if (leftSum > rightSum) {
                right--;
                rightSum += nums[right];
            } else {
                left++;
                leftSum += nums[left];
            }
        }

        return -1;
    }
}
