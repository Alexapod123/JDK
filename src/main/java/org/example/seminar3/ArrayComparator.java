package org.example.seminar3;

public class ArrayComparator {
    public <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if(!(arr1.length ==arr2.length)){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(!((arr1[i].getClass().getTypeName()).equals(arr2[i].getClass().getTypeName()))){
                return false;
            }
        }
        return true;
    }

}
