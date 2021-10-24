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

public class JsonDatabaseSingleton {
    private static JsonDatabaseSingleton instance = null;

    List<Patient> patientArrayList = new ArrayList<>();

    public static JsonDatabaseSingleton getInstance() {
        if (instance == null){
            instance =  new JsonDatabaseSingleton();
        }
        return instance;
    }
    
    public void saveDatabase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String data = objectMapper.writeValueAsString(patientArrayList);
        OutputStream outputStream = Files.newOutputStream(Paths.get("database.json"), CREATE, TRUNCATE_EXISTING);

        outputStream.write(data.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    public void initializeSingleton() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        patientArrayList = objectMapper.readValue(Paths.get("database.json").toFile(), new TypeReference<List<Patient>>(){});
    }
}
