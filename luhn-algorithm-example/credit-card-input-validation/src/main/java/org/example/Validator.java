package org.example;

public class Validator {

    //PseudoCode breakdown
    //Validate invalid user inputs
    //remove whitespaces
    //convert into char array and then loop through
    //double the value of the second to last digit
    //doing this for every second to last digit (done in the loop)
    //if the result of the doubling is bigger than 9 then split those e.g. 12 to 1+ 2 to get single digit
    //get the sum of all the digits not doubled
    //add this to the new values you got from doubling
    //number is valid if it is divisible by 10
    //prove with test cases


    public boolean validateNumber(String userInput){
        boolean isValid= false;

        if (userInput == null || userInput.trim().isEmpty()){
            System.out.println("Input is not valid");
            return isValid;
        }

        userInput = userInput.replaceAll("\\s", "");

        if (!userInput.matches("\\d+")){
            System.out.println("Input is not valid and contains non digit characters");
            return isValid;
        }

        char [] userInputArray = userInput.toCharArray();

        int doubledCount=0;

        for(int i= userInputArray.length- 2; i >= 0; i-=2){
            int doubledValue =0;
            doubledValue = Character.getNumericValue(userInputArray[i]) * 2; //this is a char and needs to be converted to int

            if (doubledValue > 9){
                doubledValue = doubledValue - 9; // Doubled values will be between 10-18 for single digits and when -9 from them
                // e.g. 10-9=1 will be the same as 10(1+0) =1 and same for other numbs
                // e.g. 12-9 = 3 same as and 9+3=12 and if we split the digit we get the same number 1+2 = 3
            }
            doubledCount += doubledValue;
        }

        for(int i= userInputArray.length -1 ; i >= 0; i-=2) {
            doubledCount += Character.getNumericValue(userInputArray[i]);
        }

        if (doubledCount % 10 == 0){
            isValid=true;
        }

        return isValid;
    }


}
