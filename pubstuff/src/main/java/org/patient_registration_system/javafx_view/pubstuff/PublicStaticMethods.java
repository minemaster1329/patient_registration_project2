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

    /**
     * validates PESEL checksum (can be also used for PESEL validation)
     * @param pesel input string
     * @return true if PESEL has correct format and checksum
     */
    public static boolean validatePESELChecksum(String pesel){
        if (pesel.matches(PublicRegexes.peselRegex)){
            int[] weights = {1,3,7,9};
            int sum = 0;
            for (int i = 0; i < 10; i++){
                sum += Character.getNumericValue(pesel.charAt(i)) * weights[i %4];
            }
            if (sum > 0){
                sum %= 10;
                sum = 10-sum;
            }
            return Character.getNumericValue(pesel.charAt(10)) == sum;
        }
        else return false;
    }
}
