import java.util.ArrayList;
import java.util.List;

class FindMissingNumbers {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int ptr = 0;
        List<Integer> res = new ArrayList();
        while (ptr < nums.length) {
            int index = Math.abs(nums[ptr]) - 1;
            if (nums[index] > 0)
                nums[index] = nums[index] * -1;
            ptr++;
        }
        ptr = 0;
        while (ptr < nums.length) {
            if (nums[ptr] > 0)
                res.add(ptr + 1);
            ptr++;
        }

        return res;
    }
}