package TestComponent;

import java.util.regex.Pattern;

public class BaseClass {
    public static boolean validateTextField(String fieldName, String fieldValue, int minLength, int maxLength) {
        if (isBlank(fieldValue)) {
            System.out.println("" + fieldName + " Value Blank");
        } else {
            int fieldLength = fieldValue.length();
            if (fieldLength < minLength || fieldLength > maxLength) {
                System.out.println("Validation error: " + fieldName + " must be between " + minLength + " and "
                        + maxLength + " characters.");
                return false;
            } else {
                System.out.println(fieldName + " Test Case Pass length With: " + fieldValue + ".");
            }

            if (!containsOnlyDigits(fieldValue)) {
                System.out.println(fieldName + " Test Case Pass Text With: " + fieldValue + ".");
            } else {
                System.out.println("Validation error: " + fieldName + " contain is only digits.");
                return false;
            }
        }
        return true;
    }
    public static boolean isBlank(String str) {
        // Check if the string is null or empty after trimming whitespace
        return str == null || str.trim().isEmpty();
    }
    public static boolean containsOnlyDigits(String str) {
        // Use a regular expression to check if the string contains only digits
        return str.matches("\\d*");
    }
    public static boolean validateEmail(String fieldName, String fieldValue) {
        if (isBlank(fieldValue)) {
            System.out.println("Validation error: " + fieldName + " field is Blank.");
        } else {
            if (isValidEmail(fieldValue)) {
                System.out.println(fieldName + " Test Case Pass With: " + fieldValue + "");
            } else {
                System.out.println("Validation error: " + fieldName + " is not a valid email address.");
            }
        }
        return false;
    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

}

