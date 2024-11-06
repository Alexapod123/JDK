package org.example.seminar3;

public class Calculator {
    public <T extends Number> double sum (T a, T b){
        return a.doubleValue()+b.doubleValue();
    }
    public <T extends Number> double multiply (T a, T b){
        return a.doubleValue()*b.doubleValue();
    }
    public <T extends Number> double divide (T a, T b){
        return a.doubleValue()/b.doubleValue();
    }
    public <T extends Number> double subtract (T a, T b){
        return a.doubleValue()-b.doubleValue();
    }
}
