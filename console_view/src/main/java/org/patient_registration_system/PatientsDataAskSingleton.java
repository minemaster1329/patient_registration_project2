package org.patient_registration_system;

import java.util.Scanner;

/**
 * Contains static methods for patient's data prompting
 */
public class PatientsDataAskSingleton {
    public static <T> Boolean askForPatientsData(ThrowingConsumer<T> function, String regex, IErrorCommunicationStrategy errorCommunicationStrategy){
        try {
            Scanner sc = new Scanner(System.in);
            String input = "";
            do {
                input = sc.nextLine();

            } while (!input.equals("q") || !input.matches(regex));
            if (input.equals("q")) return true;
            else {
                function.apply((T) input);
                return false;
            }
        }
        catch (Exception e){
            errorCommunicationStrategy.writeError("Error when asking for data", e.getMessage());
        }
        return true;
    }

    public static Pair<Boolean, String> askForNewPatientsEmail(){
        return promptForStringWRegex("Enter email", PublicRegexes.emailRegex, true);
    }

    public static Pair<Boolean, String> askForNewPatientsName(){
        return promptForStringWRegex("Enter name", PublicRegexes.nameRegex, false);
    }

    public static Pair<Boolean, String> askForNewPatientsSurname(){
        return promptForStringWRegex("Enter surname", PublicRegexes.nameRegex, false);
    }

    public static Pair<Boolean, String> askForNewPatientsMiddleName(){
        return promptForStringWRegex("Enter middle name", PublicRegexes.nameRegex, true);
    }

    public static Pair<Boolean, String> askForNewPatientsID(){
        return promptForStringWRegex("Enter ID (PESEL)", PublicRegexes.peselRegex, false);
    }

    public static Pair<Boolean, String> promptForStringWRegex(String prompt,String regex, Boolean nullAllowed){
        String out;
        boolean confirmed = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(prompt+": ");
            out = sc.next();
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
