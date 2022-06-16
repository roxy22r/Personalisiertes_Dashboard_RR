package com.example.personalisiertes_dashboard_rr;

import java.time.LocalDateTime;

public class ProjectOwner extends Person {

    public ProjectOwner(String firstName, String secondName) {
        super(firstName, secondName);
    }

    public ProjectOwner(String firstName, String secondName, LocalDateTime beginAvailableTime, LocalDateTime endAvailableTime) {
        super(firstName, secondName);
        addAvaialbeTime(beginAvailableTime, endAvailableTime);
    }

    public void addAvaialbeTime(LocalDateTime begin, LocalDateTime end) {
        addAppointment((new Appointment("Available", begin, begin.toLocalTime(), end.toLocalTime(), "There are no appointments at this time range")));
    }

    @Override
    public PersonKind getPerosnkind() {
        return PersonKind.PO;
    }
}
