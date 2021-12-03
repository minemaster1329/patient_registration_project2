package org.patient_registration_system.javafx_view.models;

import org.patient_registration_system.javafx_view.exceptions.InvalidNameFormatException;
import org.patient_registration_system.javafx_view.pubstuff.PublicRegexes;

public class Doctor extends Person {
    private String specializationName;

    public Doctor(){
        super();
    }

    /**
     * gets doctor's specialization name
     * @return doctor's specialization name
     */
    public String getSpecializationName() {
        return specializationName;
    }

    /**
     * sets doctor's specialization name (Regex: PublicRegexes.nameRegex)
     * @param specializationName new specialization name
     * @throws NullPointerException thrown if specializationName parameter is null
     * @throws InvalidNameFormatException thrown if specializationName parameter has invalid format
     */
    public void setSpecializationName(String specializationName) throws NullPointerException, InvalidNameFormatException {
        if (specializationName == null) throw new NullPointerException("Specialization cannot be null");
        if (!specializationName.matches(PublicRegexes.nameRegex)) throw new InvalidNameFormatException("Specialization name can contain only letters and must start from uppercase");
        this.specializationName = specializationName;
    }
}
