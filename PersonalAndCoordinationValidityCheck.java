import java.util.ArrayList;
import java.util.List;

public class PersonalAndCoordinationValidityCheck implements ValidityCheck {

    private List<String> errors = new ArrayList<>();

    @Override
    public boolean isValid(String number) {

        int originalLength = number.trim().length();
        String originalNumber = number;
        int year;

        if (originalLength > 13 || originalLength < 10) {
            errors.add("-Failed check: The digit must be between 10-13 digits: " + originalNumber);
            return false;
        }

        if (originalLength == 11 || originalLength == 13) {
            if ((originalLength == 11 && number.charAt(6) == '+') || (originalLength == 13 && number.charAt(8) == '+')) {
                number = number.replaceAll("[^0-9]", "");
                if (originalLength == 11){
                    number = "19" + number;
                }
            } else if ((originalLength == 11 && number.charAt(6) == '-') || (originalLength == 13 && number.charAt(8) == '-')) {
                number = number.replaceAll("[^0-9]", "");
                if (originalLength == 11){
                    number = "20" + number;
                }
            } else {
                errors.add("-Failed check: If there is 11 or 13 digits a - or + is needed before the last 4 digits: " + originalNumber);
                return false;
            }
        }

        if (number.length() == 12) {
            int century = Integer.parseInt(number.substring(0, 2));
            if (century != 18 && century != 19 && century != 20) {
                errors.add("-Failed check: No alive people from before 1800's or after 2000's: " + originalNumber);
                return false;
            } else {
                year = Integer.parseInt(number.substring(0, 4));
                number = number.substring(2, 12);
            }
        } else {
            year = 2000 + Integer.parseInt(number.substring(0, 2));
        }

        int month = Integer.parseInt(number.substring(2, 4));
        int day = Integer.parseInt(number.substring(4, 6));

        if (!isValidDate(year, month, day)){
            errors.add("-Failed check: Invalid birth date: " + originalNumber);
            return false;
        }

        if (!LuhnsAlgorithm.isValid(number)) {
            errors.add("-Failed check: Invalid control number: " + originalNumber);
            return false;
        }

        return true;
    }

    private boolean isValidDate(int year, int month, int day) {

        if (month < 1 || month > 12 || day < 1){
            return false;
        }

        if (day > 31){
            day -= 60;
        }

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        return switch (month) {
            case 2 -> isLeapYear ? day <= 29 : day <= 28;
            case 4, 6, 9, 11 -> day <= 30;
            default -> day <= 31;
        };
    }

    @Override
    public List<String> getErrors(){
        ArrayList<String> copyOfErrors = new ArrayList<>(errors);
        errors = new ArrayList<>();
        return copyOfErrors;
    }

}



