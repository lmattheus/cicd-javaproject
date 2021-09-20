package fact.it.projectthemepark.model;

import java.util.Locale;

public class Person {
    private String firstName, surName;

    public Person() {
    }

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.surName.toUpperCase(Locale.ROOT), this.firstName);
    }
}

/* Laurens Mattheus, r0854761 */
