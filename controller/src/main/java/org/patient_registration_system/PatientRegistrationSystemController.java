package org.patient_registration_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Registration system controller singleton
 */
public class PatientRegistrationSystemController {
    /**
     * adds new patient to database
     * @param patient new patient object
     * @param errorCommunicationStrategy strategy for error communicating
     */
    public static void AddNewPatientToDb(Patient patient, IErrorCommunicationStrategy errorCommunicationStrategy){
        List<Long> patientKeys = JsonDatabaseSingleton.getInstance().patientArrayList.stream().map(x -> x.getId()).toList();
        Random rnd = new Random();

        Long new_hash;
        do {
            new_hash = rnd.nextLong() % 256;
        } while (patientKeys.contains(new_hash));
        patient.setId(new_hash);

        JsonDatabaseSingleton.getInstance().patientArrayList.add(patient);
        try{
            JsonDatabaseSingleton.getInstance().saveDatabase();
        }
        catch(IOException e){
            errorCommunicationStrategy.writeError("Error when saving database changes to file", e.getMessage());
        }
    }

    /**
     * returns list of all patients
     * @return list of all patients
     */
    public static ArrayList<Patient> getAllPatients(){
        return new ArrayList<>(JsonDatabaseSingleton.getInstance().patientArrayList);
    }

    /**
     * initializes database singleton
     * @param iErrorCommunicationStrategy strategy for error communicating
     */
    public static void initializeModelSingleton(IErrorCommunicationStrategy iErrorCommunicationStrategy){
        try {
            JsonDatabaseSingleton.getInstance().initializeSingleton();
        }
        catch (Exception e) {
            iErrorCommunicationStrategy.writeError("Error when initializing model", e.getMessage());
        }
    }

    /**
     * searches for patient with given id
     * @param id patient's id
     * @return patient with given id
     */
    public static Optional<Patient> getPatientByID(long id){
        return JsonDatabaseSingleton.getInstance().patientArrayList.stream().filter(x->x.getId() == id).findAny();
    }

    /**
     * saves database to file
     * @param iErrorCommunicationStrategy strategy for error displaying
     */
    public static void saveDatabase(IErrorCommunicationStrategy iErrorCommunicationStrategy){
        try {
            JsonDatabaseSingleton.getInstance().saveDatabase();
        }
        catch (Exception e) {
            iErrorCommunicationStrategy.writeError("Error when saving database", e.getMessage());
        }
    }
}
