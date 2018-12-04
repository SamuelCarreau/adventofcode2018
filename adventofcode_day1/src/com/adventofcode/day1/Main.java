package com.adventofcode.day1;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Integer resultingFrequency = 0;
        List<Integer> frequencyVariations = loadFile("src\\\\input.txt");

        // part 1
        for (Integer i : frequencyVariations){
            resultingFrequency += i;
        }
        System.out.println("Part 1: "+resultingFrequency);

        // part 2
        Integer firstFrequencyReachedTwice = null;
        List<Integer> frequencyResults = new ArrayList<>();
        resultingFrequency = 0;
        while (firstFrequencyReachedTwice == null){
            frequencyResults.add(resultingFrequency);
            for(int i = 0 ; i < frequencyVariations.size() ; i++){
                int newResult = resultingFrequency + frequencyVariations.get(i);
                if(listContainInt(frequencyResults,newResult)){
                    firstFrequencyReachedTwice = newResult;
                    i = frequencyVariations.size();
                }
                frequencyResults.add(newResult);
                resultingFrequency = newResult;
            }
        }
        System.out.println("Part 2: "+firstFrequencyReachedTwice);
    }

    private static List<Integer> loadFile(String file) throws IOException {
        List<Integer> frequencyVariation = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String input;
        while ((input = br.readLine()) != null){
            frequencyVariation.add(Integer.parseInt(input));
        }
        return frequencyVariation;
    }

    private static boolean listContainInt(List<Integer> integerList, Integer toFind){
        for (Integer i : integerList) {
            if( i.equals(toFind))
                return true;
        }
        return false;
    }
}