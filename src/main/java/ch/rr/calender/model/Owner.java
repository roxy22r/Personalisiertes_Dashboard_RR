package ch.rr.calender.model;

import ch.rr.calender.personAppointmentCalenderKind;

public class Owner extends Person {
    public Owner(String firstName, String secondName) {
        super(firstName, secondName);
    }

    @Override
    public personAppointmentCalenderKind getPersonKind() {
        return personAppointmentCalenderKind.Owner;
    }
}
