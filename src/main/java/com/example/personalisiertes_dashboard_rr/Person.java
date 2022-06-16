package com.example.personalisiertes_dashboard_rr;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String firstName;
    private String secondName;
    private PersonKind perosnkind;
    private List<Appointment> appointments = new ArrayList<>();


    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void setPersonKind(PersonKind perosnkind) {
        this.perosnkind = perosnkind;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void addAllAppointments(List<Appointment> appointments) {
        this.appointments.addAll(appointments);
    }

    public PersonKind getPerosnkind() {
        return perosnkind;
    }

    public void setPerosnkind(PersonKind perosnkind) {
        this.perosnkind = perosnkind;
    }
}