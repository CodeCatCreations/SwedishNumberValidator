public class LuhnsAlgorithm {
    public static boolean isValid(String number) {

        int[] digits = new int[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }

        for (int i = 0; i < 10; i += 2) {
            digits[i] *= 2;
            if (digits[i] > 9) {
                digits[i] -= 9;
            }
        }

        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }

        return sum % 10 == 0;
    }

}
