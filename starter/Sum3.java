import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Sum3 {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3)
            return new ArrayList();

        Set<List<Integer>> set = new HashSet();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            int find = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == find) {
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                }
                if (nums[l] + nums[r] < find)
                    l++;
                else
                    r--;
            }
        }
        return new ArrayList(set);
    }
}