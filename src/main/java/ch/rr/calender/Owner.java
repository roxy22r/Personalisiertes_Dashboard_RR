package ch.rr.calender;

public class Owner extends Person {
    public Owner(String firstName, String secondName) {
        super(firstName, secondName);
    }

    @Override
    public personAppointmentCalenderKind getPersonKind() {
        return personAppointmentCalenderKind.Owner;
    }
}
