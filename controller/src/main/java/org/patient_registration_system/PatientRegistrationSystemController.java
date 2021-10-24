package org.patient_registration_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientRegistrationSystemController {
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

    public static ArrayList<Patient> getAllPatients(){
        return new ArrayList<>(JsonDatabaseSingleton.getInstance().patientArrayList);
    }

    public static void initializeModelSingleton(IErrorCommunicationStrategy iErrorCommunicationStrategy){
        try {
            JsonDatabaseSingleton.getInstance().initializeSingleton();
        }
        catch (Exception e) {
            iErrorCommunicationStrategy.writeError("Error when initializing model", e.getMessage());
        }
    }
}
