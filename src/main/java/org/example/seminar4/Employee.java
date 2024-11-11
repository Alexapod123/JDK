package org.example.seminar4;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String surname;
    private String name;
    private int staffNumber;
    private long phoneNumber;
    private LocalDate dayOfEmployment;

    public Employee(String surname, String name, int staffNumber, long phoneNumber, LocalDate dayOfEmployment) {
        this.surname = surname;
        this.name = name;
        this.staffNumber = staffNumber;
        this.phoneNumber = phoneNumber;
        this.dayOfEmployment = dayOfEmployment;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDayOfEmployment() {
        return dayOfEmployment;
    }

    public void setDayOfEmployment(LocalDate dayOfEmployment) {
        this.dayOfEmployment = dayOfEmployment;
    }
    public int experience(LocalDate dayOfEmployment){
        Period diff = Period.between(dayOfEmployment, LocalDate.now());
        return diff.getYears();
    }

    @Override
    public String toString() {
        return "Сотрудник:" +
                " " + surname  +
                " " + name  +
                ", табельный номер: " + staffNumber +
                ", номер телефона: " + phoneNumber +
                ", стаж работы: " + experience(dayOfEmployment)+
                ".\n";
    }
}
