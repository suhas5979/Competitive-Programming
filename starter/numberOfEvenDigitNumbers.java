public class numberOfEvenDigitNumbers {
    public static void main(String[] args) {
        int[] arr = { 123, 12, 1324, 242424, 2424, 121, 34 };
        System.out.println(findNumbers(arr));
    }

    // solution works but not for every case
    public static int calculate(int[] arr) {
        int res = 0;
        for (int num : arr) {
            int numDigit = (int) Math.ceil(Math.log10(num));
            System.out.println(numDigit);
            if (numDigit % 2 == 0) {
                res++;
            }
        }

        return res;
    }

    // solution works for every case
    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int digit = 0;
            while (num != 0) {
                num /= 10;
                digit++;
            }

            if (digit % 2 == 0)
                res++;
        }
        return res;
    }
}
