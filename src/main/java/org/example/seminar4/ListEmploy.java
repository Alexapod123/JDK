package org.example.seminar4;

import java.util.ArrayList;
import java.util.List;

public class ListEmploy {
   private List<Employee> employeeList;

    public ListEmploy() {
        employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> employeesByExperience(int exp) {
        List<Employee> employeesExp = new ArrayList<>();
        for(Employee employee: employeeList){
            if (employee.experience(employee.getDayOfEmployment())==exp){
                employeesExp.add(employee);
            }
        }
        return employeesExp;
    }
    public List<Long> searchPhoneByName(String name){
        List<Long> phoneList = new ArrayList<>();
        for (Employee employee: employeeList){
            if(employee.getName().equals(name)){
                phoneList.add(employee.getPhoneNumber());
            }
        }
        return phoneList;
    }
    public List<Employee> employeesByStaffNumber(int staff) {
        List<Employee> employeesStaff = new ArrayList<>();
        for(Employee employee: employeeList){
            if (employee.getStaffNumber()==staff){
                employeesStaff.add(employee);
            }
        }
        return employeesStaff;
    }

}
