package org.patient_registration_system;

import java.util.Scanner;

/**
 * Contains static methods for patient's data prompting
 */
public class PatientsDataAskSingleton {
    /**
     * prompts for new patient's email
     * @return pair of boolean (true if confirmed by user, false if operation cancelled) and string with contents
     */
    public static Pair<Boolean, String> askForNewPatientsEmail(){
        return promptForStringWRegex("Enter email", PublicRegexes.emailRegex, true);
    }

    /**
     * prompts for new patient's name
     * @return pair of boolean (true if confirmed by user, false if operation cancelled) and string with contents
     */
    public static Pair<Boolean, String> askForNewPatientsName(){
        return promptForStringWRegex("Enter name", PublicRegexes.nameRegex, false);
    }

    /**
     * prompts for new patient's surname
     * @return pair of boolean (true if confirmed by user, false if operation cancelled) and string with contents
     */
    public static Pair<Boolean, String> askForNewPatientsSurname(){
        return promptForStringWRegex("Enter surname", PublicRegexes.nameRegex, false);
    }

    /**
     * prompts for new patient's middle name
     * @return pair of boolean (true if confirmed by user, false if operation cancelled) and string with contents
     */
    public static Pair<Boolean, String> askForNewPatientsMiddleName(){
        return promptForStringWRegex("Enter middle name", PublicRegexes.nameRegex, true);
    }

    /**
     * prompts for new patient's ID
     * @return pair of boolean (true if confirmed by user, false if operation cancelled) and string with contents
     */
    public static Pair<Boolean, String> askForNewPatientsID(){
        return promptForStringWRegex("Enter ID (PESEL)", PublicRegexes.peselRegex, false);
    }

    /**
     * prompts user for some data in specified format
     * @param prompt prompt string
     * @param regex format regex
     * @param nullAllowed is empty value allowed
     * @return pair of boolean (true if data confirmed by user, false when cancelled) and string with data
     */
    public static Pair<Boolean, String> promptForStringWRegex(String prompt,String regex, Boolean nullAllowed){
        String out;
        boolean confirmed = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(prompt+": ");
            out = sc.nextLine();
            if (out.equals("q")){
                System.out.println("Operation cancelled");
                confirmed = false;
                break;
            }
            else if ((out.isEmpty() && nullAllowed) || out.matches(regex)){
                System.out.println("Data correct. Saving to object");
                break;
            }
        } while (true);
        return new Pair<>(confirmed, out);
    }
}
