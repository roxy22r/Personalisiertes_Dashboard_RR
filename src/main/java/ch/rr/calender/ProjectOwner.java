package ch.rr.calender;

import ch.rr.calender.model.Appointment;
import ch.rr.calender.model.Person;

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
    public personAppointmentCalenderKind getPersonKind() {
        return personAppointmentCalenderKind.PO;
    }
}
