public enum NumberType {
    PERSONAL,
    COORDINATION,
    COMPANY,
    INVALID;

    public static NumberType getNumberType(String number) {
        number = number.replaceAll("[^0-9]", "");

        if (number.length() == 10) {
            if (Character.getNumericValue(number.charAt(2)) > 1) {
                return NumberType.COMPANY;
            }
            int coordinationControlNum = Integer.parseInt(number.substring(4, 6));
            if (coordinationControlNum > 60 && coordinationControlNum < 92) {
                return NumberType.COORDINATION;
            }
            return NumberType.PERSONAL;
        }

        if (number.length() == 12) {
            if (Character.getNumericValue(number.charAt(4)) > 1) {
                return NumberType.COMPANY;
            }
            int coordinationControlNum = Integer.parseInt(number.substring(6, 8));

            if (coordinationControlNum > 60 && coordinationControlNum < 92) {
                return NumberType.COORDINATION;
            }
            return NumberType.PERSONAL;
        }
        return NumberType.INVALID;
    }
}

