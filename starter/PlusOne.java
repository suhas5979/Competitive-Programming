package starter;
public class PlusOne {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int[] res = plusOne(arr);
        for (int num : res) {
            System.err.print(num + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null)
            return null;
        int overflow = 1;
        for (int i = digits.length - 1; i >= 0 && overflow == 1; i--) {
            int num = digits[i] + 1;
            if (num == 10)
                continue;
            else
                overflow = 0;
        }
        if (overflow == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;

    }

}
