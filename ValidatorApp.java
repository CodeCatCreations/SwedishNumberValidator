import java.util.*;

public class ValidatorApp {
    private final Map<NumberType, List<ValidityCheck>> checkMap;
    private List<List<String>> errors;

    public ValidatorApp() {
        checkMap = new EnumMap<>(NumberType.class);
        initializeChecks();
    }

    private void initializeChecks() {
        for (NumberType type : NumberType.values()) {
            List<ValidityCheck> typeChecks = new ArrayList<>();
            if (type == NumberType.PERSONAL || type == NumberType.COORDINATION) {
                typeChecks.add(new PersonalAndCoordinationValidityCheck());
            } else if (type == NumberType.COMPANY) {
                typeChecks.add(new OrganizationNumberValidityCheck());
            }
            checkMap.put(type, typeChecks);
        }
    }

    private boolean isValid(String number) {
        NumberType type = NumberType.getNumberType(number);
        boolean isValid = false;
        errors = new ArrayList<>();

        List<ValidityCheck> checksForType = checkMap.get(type);
        if (checksForType != null) {
            for (ValidityCheck check : checksForType) {
                if (check.isValid(number)) {
                    isValid = true;
                    break;
                } else {
                    errors.add(check.getErrors());
                }
            }
        }

        return isValid;
    }

    private static void checkNumber(ValidatorApp validator, String input) {
        String type = String.valueOf(NumberType.getNumberType(input)).toLowerCase();
        if (validator.isValid(input)) {
            System.out.println(input + " is a valid " + type + " number.");
        } else {
            System.out.println("\n--- " + input + " is not a valid number.");
            if (validator.errors != null) {
                for (List<String> list : validator.errors) {
                    for (String error : list) {
                        System.out.println("-Type: " + type.substring(0, 1).toUpperCase() + type.substring(1));
                        System.out.println(error);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<String> allNumbers = new ArrayList<>();
        DataPopulator.populate(allNumbers);

        ValidatorApp validator = new ValidatorApp();
        Scanner scanner = new Scanner(System.in);

        int command = 2;
        String input = "";

        System.out.println("\nWelcome!");


        while (command != 3) {
            System.out.println("\nEnter one of the numbers followed by Enter to choose command:\n-1: Execute testcases." +
                    "\n-2: Write a number to test."+"\n-3: End program.\n");
            input = scanner.nextLine().trim();
            command = Integer.parseInt(input);

            switch (command){
                case 1: for (String testNumber : allNumbers){ checkNumber(validator, testNumber);}
                    break;
                case 2: System.out.println("Write a number to test followed by Enter: "); input = scanner.nextLine().trim(); checkNumber(validator, input);
                    break;

            }
        }
    }

}
