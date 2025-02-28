package com.hospitalMS.prescription_service.entity;

import java.time.LocalDate;

public class FollowUp {
    private LocalDate date;
    private String remarks;

    // Constructors
    public FollowUp() {}

    public FollowUp(LocalDate date, String remarks) {
        this.date = date;
        this.remarks = remarks;
    }

    // Getters and Setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}

