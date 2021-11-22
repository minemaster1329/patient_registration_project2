package models;

import exceptions.InvalidNameFormatException;
import org.patient_registration_system.PublicRegexes;

/**
 * Stores data about Medicine
 */
public class Medicine {
    private String name;
    private String producerName;

    public Medicine(){}

    /**
     * returns medicine name
     * @return medicine name
     */
    public String getName() {
        return name;
    }

    /**
     * sets medicine name
     * @param name new medicine name
     * @throws InvalidNameFormatException thrown if supplied name has invalid format
     * @throws NullPointerException thrown if supplied name is null
     */
    public void setName(String name) throws InvalidNameFormatException, NullPointerException {
        if (name == null) throw new NullPointerException("Name cannot be null");
        if (!name.matches(PublicRegexes.medicineNameRegex)) throw new InvalidNameFormatException("Name can contain only letters and digits (at the end) and must start from uppercase");
        this.name = name;
    }

    /**
     * returns medicine's producer name
     * @return producer's name
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * sets medicine's producer name
     * @param producerName new producer's name
     * @throws InvalidNameFormatException thrown if supplied data has invalid format
     * @throws NullPointerException thrown if supplied data is null
     */
    public void setProducerName(String producerName) throws InvalidNameFormatException, NullPointerException {
        if (producerName == null) throw new NullPointerException("Producer name cannot be null");
        if (!producerName.matches(PublicRegexes.nameRegex)) throw new InvalidNameFormatException("Producer name can contain only letters and must start from uppercase");
        this.producerName = producerName;
    }
}
