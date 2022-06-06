package com.example.personalisiertes_dashboard_rr;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectOwner {
    private String firstName;
    private String secondName;
    private List<Appointment> freeTime;

    public ProjectOwner(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public ProjectOwner(String firstName, String secondName, LocalDateTime beginAvailableTime, LocalDateTime endAvailableTime) {
        this.firstName = firstName;
        this.secondName = secondName;
        addAvaialbeTime(beginAvailableTime, endAvailableTime);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Appointment> getFreeTime() {
        return freeTime;
    }

    public void addAvaialbeTime(LocalDateTime begin, LocalDateTime end) {
        freeTime.add(new Appointment("Available", begin, begin.toLocalTime(), end.toLocalTime(), ""));
    }
}
