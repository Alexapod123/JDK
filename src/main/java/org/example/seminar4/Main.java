package org.example.seminar4;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee vasya = new Employee("Петров", "Василий", 1215, 89254658594L, LocalDate.of(2023, 12, 11));
        Employee katya = new Employee("Васильченко", "Катерина", 95, 89162501213L, LocalDate.of(2020, 07, 01));
        Employee anna = new Employee("Иванова", "Анна", 145, 89001615143L, LocalDate.of(2024, 11, 01));
        Employee ivan = new Employee("Картинов", "Иван", 865, 89956288987L, LocalDate.of(2019, 01, 20));
        Employee vanya = new Employee("Маринов", "Иван", 189, 89258522321L, LocalDate.of(2022, 12, 03));
        ListEmploy listEmploy = new ListEmploy();
        listEmploy.addEmployee(vasya);
        listEmploy.addEmployee(katya);
        listEmploy.addEmployee(anna);
        listEmploy.addEmployee(ivan);
        listEmploy.addEmployee(vanya);
        System.out.println(listEmploy.getEmployeeList());
        System.out.println(listEmploy.employeesByExperience(0));
        System.out.println(listEmploy.employeesByStaffNumber(865));
        System.out.println(listEmploy.searchPhoneByName("Иван"));


    }
}
