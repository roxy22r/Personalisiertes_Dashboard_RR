package ch.rr.calender;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String firstName;
    private String secondName;
    private personAppointmentCalenderKind perosnkind;
    private List<Appointment> appointments = new ArrayList<>();


    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public personAppointmentCalenderKind getPersonKind() {
        return perosnkind;
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

    public void setPersonKind(personAppointmentCalenderKind perosnkind) {
        this.perosnkind = perosnkind;
    }

    public void setPerosnkind(personAppointmentCalenderKind perosnkind) {
        this.perosnkind = perosnkind;
    }
}
