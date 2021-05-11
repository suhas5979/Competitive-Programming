package starter;
public class sortedSquareArray {
    public static void main(String[] args) {
        int[] arr = { -4, -1, 0, 3, 10 };
        // Print solution
        for (int num : sortedSquares(arr)) {
            System.err.print(num + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[index] = nums[left] * nums[left];
                left++;
            } else {
                res[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return res;
    }
}
