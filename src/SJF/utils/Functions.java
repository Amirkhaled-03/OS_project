package SJF.utils;

public class Functions {

    public Boolean isValidPositiveInt(String input) {
        // Perform validation checks
        if (input.isEmpty()) {
            System.out.println("Input cannot be empty");
            return false;
        } else if (!input.matches("[0-9]+")) {
            System.out.println("Input must be a positive ");
            return false;
        } else {
            System.out.println("true"); // Clear validation message if input is valid
        }
        return true;
    }

    public int castInt(String str) {
        return Integer.parseInt(str);
    }

    public void validateInput2(String input) {
        if (input.isEmpty()) {
            System.out.println("Input cannot be empty");
        } else if (!input.matches("[0-9]+")) {
            System.out.println("Input must be a positive ");
        } else {
            System.out.println("true"); // Clear validation message if input is valid
        }
    }
}
