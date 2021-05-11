package starter;
public class mergeSortedArrays {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 0, 0, 0 };
        int[] arr1 = { 2, 4, 5 };
        merge(arr, 3, arr1, 3);
        for (int num : arr) {
            System.err.print(num + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int index = nums1.length - 1;
        while (index >= 0 && left >= 0 && right >= 0) {
            if (nums1[left] >= nums2[right]) {
                nums1[index] = nums1[left];
                left--;
            } else {
                nums1[index] = nums2[right];
                right--;
            }
            index--;
        }
        while (right >= 0) {
            nums1[index] = nums2[right];
            right--;
            index--;
        }
    }
}
