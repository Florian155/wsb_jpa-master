package com.capgemini.wsb.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private LocalDateTime Time;
    private String doctorName;

    public LocalDateTime getTime() {
        return Time;
    }

    public void setVisitDateTime(LocalDateTime visitDateTime) {
        this.Time = visitDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}

