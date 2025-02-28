package com.hospitalMS.Patient_service.entity;

public class PatientHistory {
    private String familyHistory;
    private String socialHistory;
    private String medicalHistory;

    public PatientHistory(String familyHistory, String socialHistory, String medicalHistory) {
        this.familyHistory = familyHistory;
        this.socialHistory = socialHistory;
        this.medicalHistory = medicalHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
