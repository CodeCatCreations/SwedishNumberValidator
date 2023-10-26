import java.util.ArrayList;
import java.util.List;

public class OrganizationNumberValidityCheck implements ValidityCheck {
    private List<String> errors = new ArrayList<>();

    @Override
    public boolean isValid(String number) {
        int originalLength = number.trim().length();

        if (originalLength != 11 && originalLength != 13){
            errors.add("-Failed check: Organization number must be 11-13 digits including the minus-sign (-): " + number);
            return false;
        }

        if (originalLength == 11){
            if (number.charAt(6) != '-'){
                errors.add("-Failed check: Organization number must contain a minus-sign (-): " + number);
                return false;
            }
        }

        if (originalLength == 13) {
            if (number.charAt(8) != '-'){
                errors.add("-Failed check: Organization number must contain a minus-sign (-): " + number);
                return false;
            } if (!number.startsWith("16")){
                errors.add("-Failed check: Organization numbers that have 13 digits most start with 16: " + number);
                return false;
            }
            number = number.substring(2, 13);
        }

        number = number.replaceAll("[^0-9]", "");

        int middleDigits = Integer.parseInt(number.substring(1, 3));

        if (middleDigits < 20) {
            errors.add("-Failed check: The 3rd digit of the organization number must be larger than 1: " + number);
            return false;
        }

        if (!LuhnsAlgorithm.isValid(number)) {
            errors.add("-Failed check: Invalid control number: " + number);
            return false;
        }

        return true;
    }

    @Override
    public List<String> getErrors(){
        ArrayList<String> copyOfErrors = new ArrayList<>(errors);
        errors = new ArrayList<>();
        return copyOfErrors;
    }

}
