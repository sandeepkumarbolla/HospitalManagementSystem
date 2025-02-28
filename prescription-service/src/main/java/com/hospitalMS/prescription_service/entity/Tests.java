package com.hospitalMS.prescription_service.entity;

public class Tests {
    private String testName;
    private String result;
    private String notes;

    public Tests() {
    }

    public Tests(String testName, String result, String notes) {
        this.testName = testName;
        this.result = result;
        this.notes = notes;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

