package org.patient_registration_system;

import java.util.Scanner;

/**
 * Contains static methods for patient's data prompting
 */
public class PatientsDataAskSingleton {
    /**
     *
     * @return
     */
    // TODO: 21.11.2021 document function
    public static Pair<Boolean, String> askForNewPatientsEmail(){
        return promptForStringWRegex("Enter email", PublicRegexes.emailRegex, true);
    }

    /**
     *
     * @return
     */
    // TODO: 21.11.2021 document function
    public static Pair<Boolean, String> askForNewPatientsName(){
        return promptForStringWRegex("Enter name", PublicRegexes.nameRegex, false);
    }

    /**
     *
     * @return
     */
    // TODO: 21.11.2021 document function
    public static Pair<Boolean, String> askForNewPatientsSurname(){
        return promptForStringWRegex("Enter surname", PublicRegexes.nameRegex, false);
    }

    /**
     *
     * @return
     */
    // TODO: 21.11.2021 document function
    public static Pair<Boolean, String> askForNewPatientsMiddleName(){
        return promptForStringWRegex("Enter middle name", PublicRegexes.nameRegex, true);
    }

    /**
     *
     * @return
     */
    // TODO: 21.11.2021 document function
    public static Pair<Boolean, String> askForNewPatientsID(){
        return promptForStringWRegex("Enter ID (PESEL)", PublicRegexes.peselRegex, false);
    }

    /**
     *
     * @param prompt
     * @param regex
     * @param nullAllowed
     * @return
     */
    // TODO: 21.11.2021 document function
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
