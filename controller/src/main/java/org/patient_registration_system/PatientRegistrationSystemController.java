package org.patient_registration_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientRegistrationSystemController {
    public static void AddNewPatientToDb(Patient patient){
        List<Long> patientKeys = JsonDatabaseSingleton.getInstance().patientArrayList.stream().map(x -> x.id).toList();
        Random rnd = new Random();

        Long new_hash;
        do {
            new_hash = rnd.nextLong();
        } while (patientKeys.contains(new_hash));
        patient.id = new_hash;

        JsonDatabaseSingleton.getInstance().patientArrayList.add(patient);
        try{
            JsonDatabaseSingleton.getInstance().saveDatabase();
        }
        catch(Exception e){

        }
    }

    public static ArrayList<Patient> getAllPatients(){
        return new ArrayList<>(JsonDatabaseSingleton.getInstance().patientArrayList);
    }
}
