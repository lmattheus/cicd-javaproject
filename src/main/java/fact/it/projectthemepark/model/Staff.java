package fact.it.projectthemepark.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Staff extends Person {
    private LocalDate startDate;
    private boolean student;

    public Staff(String firstName, String surName) {
        super(firstName, surName);
        startDate = LocalDate.now();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    @Override
    public String toString() {
        if (isStudent()) {
            return String.format("Staff member %s (working student) is employed since %s", super.toString(), this.startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        else {
            return String.format("Staff member %s is employed since %s", super.toString(), this.startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
}

/* Laurens Mattheus, r0854761 */
