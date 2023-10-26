import java.util.ArrayList;

public class DataPopulator {
    public static void populate(ArrayList<String> allNumbers) {
        populateValidPersonalNumbers(allNumbers);
        populateValidCoordinationNumbers(allNumbers);
        populateValidOrganisationNumbers(allNumbers);
        populateInvalidPersonalNumbers(allNumbers);
        populateInvalidCoordinationNumbers(allNumbers);
        populateInvalidOrganisationNumbers(allNumbers);
    }

    private static void populateValidPersonalNumbers(ArrayList<String> allNumbers) {
        allNumbers.add("201701102384");
        allNumbers.add("141206-2380");
        allNumbers.add("20080903-2386");
        allNumbers.add("7101169295");
        allNumbers.add("198107249289");
        allNumbers.add("19021214-9819");
        allNumbers.add("190910199827");
        allNumbers.add("191006089807");
        allNumbers.add("192109099180");
        allNumbers.add("4607137454");
        allNumbers.add("194510168885");
        allNumbers.add("900118+9811");
        allNumbers.add("189102279800");
        allNumbers.add("189912299816");
    }

    private static void populateValidCoordinationNumbers(ArrayList<String> allNumbers) {
        allNumbers.add("190910799824");
    }

    private static void populateValidOrganisationNumbers(ArrayList<String> allNumbers) {
        allNumbers.add("556614-3185");
        allNumbers.add("16556601-6399");
        allNumbers.add("262000-1111");
        allNumbers.add("857202-7566");
    }

    private static void populateInvalidPersonalNumbers(ArrayList<String> allNumbers) {
        allNumbers.add("201701272394");
        allNumbers.add("190302299813");
        allNumbers.add("199512244438");
    }

    private static void populateInvalidCoordinationNumbers(ArrayList<String> allNumbers) {
        allNumbers.add("951264-4428");
        allNumbers.add("951274-4428");
    }

    private static void populateInvalidOrganisationNumbers(ArrayList<String> allNumbers) {
        allNumbers.add("556614-3195");
        allNumbers.add("16556601-6379");
        allNumbers.add("262000-1121");
        allNumbers.add("857202-7576");
    }

}
