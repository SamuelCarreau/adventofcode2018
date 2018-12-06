package com.adventofcode.day5;

import com.adventofcode.day5.chain.Polymer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        try{
            String input = System.getProperty("os.name").equals("Linux")
                    ? loadFile("src/input.txt")
                    : loadFile("src\\\\input.txt");

            Polymer polymer = new Polymer(input);
            polymer.doChainReaction();

            System.out.println("Part 1 = "+polymer.getSize());

            int min = polymer.getSize();
            for (Character character : alphabet.toCharArray()){
                polymer = new Polymer(input,character);
                polymer.doChainReaction();
                int newSize = polymer.getSize();
                min = (min > newSize)? newSize: min;
            }

            System.out.println("Part 2 = "+min);

        }catch (IOException exc){
            System.out.println("Error: "+exc.getMessage());
        }

    }

    private static String loadFile(String file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String input;
        while ((input = br.readLine()) != null){
            stringBuilder.append(input);
        }
        return stringBuilder.toString();
    }
}
