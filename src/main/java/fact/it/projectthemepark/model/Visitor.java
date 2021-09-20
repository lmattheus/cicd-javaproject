package fact.it.projectthemepark.model;

import java.util.ArrayList;

public class Visitor extends Person {
    private int yearOfBirth, themeParkCode = -1;
    private ArrayList<String> wishList = new ArrayList<>();

    public Visitor(String firstName, String surName) {
        super(firstName, surName);
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public ArrayList<String> getWishList() {
        return wishList;
    }

    public int getThemeParkCode() {
        return themeParkCode;
    }

    public void setThemeParkCode(int themeParkCode) {
        this.themeParkCode = themeParkCode;
    }

    public boolean addToWishList(String attractionName) {
        if (wishList.size() < 5) {
            wishList.add(attractionName);
            return true;
        }
        else {
            return false;
        }
    }

    public int getNumberOfWishes() {
        return wishList.size();
    }

    @Override
    public String toString() {
        return String.format("Visitor %s with theme park code %s", super.toString(), this.themeParkCode);
    }
}

/* Laurens Mattheus, r0854761 */
