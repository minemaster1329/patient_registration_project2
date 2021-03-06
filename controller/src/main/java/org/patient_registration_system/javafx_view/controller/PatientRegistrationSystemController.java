package org.patient_registration_system.javafx_view.controller;

import org.patient_registration_system.javafx_view.database.JsonDatabaseModelSingleton;
import org.patient_registration_system.javafx_view.models.Patient;
import org.patient_registration_system.javafx_view.pubstuff.IErrorCommunicationStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

    /**
     * Removes specified patient from database
     * @param id patient's ID
     * @param errorCommunicationStrategy strategy for error communication
     */
    public static void DeletePatientWithSpecifiedID(String id,IErrorCommunicationStrategy errorCommunicationStrategy){
        JsonDatabaseModelSingleton.getInstance().patientArrayList.removeIf(item -> item.getId().equals(id));
        try {
            JsonDatabaseModelSingleton.getInstance().saveDatabase();
        }
        catch (Exception e){
            errorCommunicationStrategy.writeError("Error when saving database", e.getMessage());
        }
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
     * @param errorCommunicationStrategy strategy for error communicating
     */
    public static boolean initializeModelSingleton(IErrorCommunicationStrategy errorCommunicationStrategy){
        try {
            JsonDatabaseModelSingleton.getInstance().initializeSingleton();
            return true;
        }
        catch (Exception e) {
            errorCommunicationStrategy.writeError("Error when initializing model", e.getMessage());
            return false;
        }
    }

    /**
     * searches for patient with given id
     * @param id patient's id
     * @return patient with given id
     */
    public static Optional<Patient> getPatientByID(String id){
        return JsonDatabaseModelSingleton.getInstance().patientArrayList.stream().filter(x->x.getId().equals(id)).findAny();
    }

    /**
     * returns patient's count
     * @return patient's count
     */
    public static Integer getAllPatientsCount(){
        return JsonDatabaseModelSingleton.getInstance().patientArrayList.size();
    }

    /**
     * returns patients meeting specified predicate
     * @param predicate predicate function
     * @return patient's meeting predicate
     */
    public static List<Patient> getAllPatientsMeetingPredicate(Predicate<Patient> predicate){
        return JsonDatabaseModelSingleton.getInstance().patientArrayList.stream().filter(predicate).toList();
    }
}
