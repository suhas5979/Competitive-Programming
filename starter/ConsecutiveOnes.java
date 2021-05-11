package starter;
public class ConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 0, 2, 1, 3, 4, 2, 0, 9, 0, 2, 1, 3, 0, 5 };
        System.out.println(findConsecutiveOnes(arr));
    }

    public static int findConsecutiveOnes(int[] arr) {
        int max = 0;
        int currentMax = 0;
        for (int i : arr) {
            if (i == 1) {
                currentMax++;
                max = Math.max(currentMax, max);
            } else {
                currentMax = 0;
            }
        }
        return max;
    }
}