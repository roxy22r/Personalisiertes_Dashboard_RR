package com.example.personalisiertes_dashboard_rr;

public class Owner extends Person {
    public Owner(String firstName, String secondName) {
        super(firstName, secondName);
    }

    @Override
    public PersonKind getPerosnkind() {
        return PersonKind.Owner;
    }
}
