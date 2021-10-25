package org.patient_registration_system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.*;

/**
 * Stores data and provides basic methods
 */
public class JsonDatabaseSingleton {

    private static JsonDatabaseSingleton instance = null;

    List<Patient> patientArrayList = new ArrayList<>();

    /**
     * returns instance of instance
     * @return instance of singleton
     */
    public static JsonDatabaseSingleton getInstance() {
        if (instance == null){
            instance =  new JsonDatabaseSingleton();
        }
        return instance;
    }

    /**
     * saves changes to database
     * @throws IOException thrown when write to file error occured
     */
    public void saveDatabase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String data = objectMapper.writeValueAsString(patientArrayList);
        OutputStream outputStream = Files.newOutputStream(Paths.get("database.json"), CREATE, TRUNCATE_EXISTING);

        outputStream.write(data.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    /**
     * initializes singleton by reading data from file
     * @throws IOException thrown when read from file error occured
     */
    public void initializeSingleton() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        patientArrayList = objectMapper.readValue(Paths.get("database.json").toFile(), new TypeReference<List<Patient>>(){});
    }
}
