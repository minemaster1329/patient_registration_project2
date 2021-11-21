package models;

import exceptions.InvalidNameFormatException;
import org.patient_registration_system.PublicRegexes;

// TODO: 21.11.2021 document this class and all fields
public class Medicine {
    private String name;
    private String producerName;

    public Medicine(){}


    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidNameFormatException, NullPointerException {
        if (name == null) throw new NullPointerException("Name cannot be null");
        if (!name.matches(PublicRegexes.medicineNameRegex)) throw new InvalidNameFormatException("Name can contain only letters and digits (at the end) and must start from uppercase");
        this.name = name;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) throws InvalidNameFormatException, NullPointerException {
        if (producerName == null) throw new NullPointerException("Producer name cannot be null");
        if (!producerName.matches(PublicRegexes.nameRegex)) throw new InvalidNameFormatException("Producer name can contain only letters and must start from uppercase");
        this.producerName = producerName;
    }
}
