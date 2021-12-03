package org.patient_registration_system.javafx_view.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.patient_registration_system.javafx_view.models.Patient;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.*;

/**
 * Stores data and provides basic methods
 */
public class JsonDatabaseModelSingleton {

    private static JsonDatabaseModelSingleton instance = null;

    public List<Patient> patientArrayList = new ArrayList<>();

    /**
     * returns instance of instance
     * @return instance of singleton
     */
    public static JsonDatabaseModelSingleton getInstance() {
        if (instance == null){
            instance =  new JsonDatabaseModelSingleton();
        }
        return instance;
    }

    /**
     * saves changes to database
     * @throws IOException thrown when write to file error occurred
     */
    public void saveDatabase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String data = objectMapper.writeValueAsString(patientArrayList);
        OutputStream outputStream = Files.newOutputStream(Paths.get("patients.json"), CREATE, TRUNCATE_EXISTING);

        outputStream.write(data.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    /**
     * initializes singleton by reading data from file
     * @throws IOException thrown when read from file error occurred
     */
    public void initializeSingleton() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        patientArrayList = objectMapper.readValue(Paths.get("patients.json").toFile(), new TypeReference<List<Patient>>(){});
    }
}
