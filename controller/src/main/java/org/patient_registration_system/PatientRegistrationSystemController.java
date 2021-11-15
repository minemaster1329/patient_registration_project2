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
        List<Long> patientKeys = JsonDatabaseModelSingleton.getInstance().patientArrayList.stream().map(Patient::getId).toList();
        Random rnd = new Random();

        Long new_hash;
        do {
            new_hash = rnd.nextLong() % 256;
        } while (patientKeys.contains(new_hash));
        patient.setId(new_hash);

        JsonDatabaseModelSingleton.getInstance().patientArrayList.add(patient);
        try{
            JsonDatabaseModelSingleton.getInstance().saveDatabase();
        }
        catch(IOException e){
            errorCommunicationStrategy.writeError("Error when saving database changes to file", e.getMessage());
        }
    }

    /**
     * Removes all patients from database
     * @param errorCommunicationStrategy strategy for error communicating
     */
    public static void DeleteAllPatients(IErrorCommunicationStrategy errorCommunicationStrategy){
        ArrayList<Patient> list_backup = getAllPatients();
        try{
            JsonDatabaseModelSingleton.getInstance().patientArrayList.clear();
            JsonDatabaseModelSingleton.getInstance().saveDatabase();
        }
        catch (IOException e){
            errorCommunicationStrategy.writeError("Error when saving database", e.getMessage());
            list_backup.forEach(p->JsonDatabaseModelSingleton.getInstance().patientArrayList.add(p));
        }
    }

    public static void DeletePatientWithSpecifiedID(Long id,IErrorCommunicationStrategy errorCommunicationStrategy){
        Patient pt = getPatientByID(id).get();

    }

    /**
     * returns list of all patients
     * @return list of all patients
     */
    public static ArrayList<Patient> getAllPatients(){
        return new ArrayList<>(JsonDatabaseModelSingleton.getInstance().patientArrayList);
    }

    /**
     * initializes database singleton
     * @param iErrorCommunicationStrategy strategy for error communicating
     */
    public static void initializeModelSingleton(IErrorCommunicationStrategy iErrorCommunicationStrategy){
        try {
            JsonDatabaseModelSingleton.getInstance().initializeSingleton();
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
        return JsonDatabaseModelSingleton.getInstance().patientArrayList.stream().filter(x->x.getId() == id).findAny();
    }
}
