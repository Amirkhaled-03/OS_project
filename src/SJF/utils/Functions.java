package SJF.utils;

public class Functions {

    public Boolean isValidPositiveInt(String input) {
        // Perform validation checks
        if (input.isEmpty()) {
            return false;
        } else if (!input.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public int castInt(String str) {
        return Integer.parseInt(str);
    }
    
}
