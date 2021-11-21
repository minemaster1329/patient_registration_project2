package models;

import exceptions.InvalidNameFormatException;
import org.patient_registration_system.PublicRegexes;

// TODO: 21.11.2021 document class and fields
public class Doctor extends Person {
    private String specializationName;

    public Doctor(){
        super();
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) throws NullPointerException, InvalidNameFormatException {
        if (specializationName == null) throw new NullPointerException("Specialization cannot be null");
        if (!specializationName.matches(PublicRegexes.nameRegex)) throw new InvalidNameFormatException("Specialization name can contain only letters and must start from uppercase");
        this.specializationName = specializationName;
    }
}
