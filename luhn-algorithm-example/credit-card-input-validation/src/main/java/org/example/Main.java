package org.example;


public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        boolean isValid = validator.validateNumber("0123456 789");
        System.out.println(isValid);
    }


}