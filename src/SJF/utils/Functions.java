package SJF.utils;

public class Functions {

    public static Boolean isValidPositiveInt(String input) {
        // Perform validation checks
        if (input.isEmpty()) {
            return false;
        } else if (!input.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public static Boolean isValidPositiveIntWithOutZero(String input) {
        // Perform validation checks
        if (input.isEmpty()) {
            return false;
        } else if (!input.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public static int castInt(String str) {
        return Integer.parseInt(str);
    }

}
