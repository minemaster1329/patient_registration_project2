package org.patient_registration_system.javafx_view.pubstuff;

/**
 * Contains common methods for all packages
 */
public class PublicStaticMethods {
    /**
     * Checks if string input can be parsed to Integer
     * @param input input
     * @return true when input can be parsed to Integer
     */
    public static boolean canParseToInt(String input){
        try {
            Integer a = Integer.parseInt(input);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static boolean canParseToLong(String input){
        try {
            Long a = Long.parseLong(input);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}