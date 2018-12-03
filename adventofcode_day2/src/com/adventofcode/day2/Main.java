package com.adventofcode.day2;


import com.adventofcode.day2.util.FileHelper;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        String filename = "src\\boxIdInput.txt";

        int doubleCounter = 0;
        int tripleCounter = 0;
        BoxScanner boxScanner = null;

        try {
            List<String> boxIds = FileHelper.readTextFile(filename);


            for (String boxId : boxIds) {
                BoxScore boxScore = new BoxScore(boxId);
                doubleCounter += boxScore.haveDoublet();
                tripleCounter += boxScore.haveTriplet();
            }

            boxScanner = new BoxScanner(boxIds);


        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }

        System.out.println("The value of "+doubleCounter+ " * "+tripleCounter+ " = "+doubleCounter*tripleCounter);
        System.out.println("The value of the best matching string :  " + boxScanner.getCommonLetterFromMatchingPair());






    }



}
