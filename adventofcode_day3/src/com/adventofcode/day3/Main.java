package com.adventofcode.day3;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int[][] matrix  = new int[1000][1000];
        String[] inputs = new String[1373];

        BufferedReader br = new BufferedReader(new FileReader("src\\\\input.txt"));
        String currentSquareInfo = "";

        int overlapCounter = 0;
        int noOverlapSquareId = 0;

        // Read the file
        while ((currentSquareInfo = br.readLine()) != null) {

            Square currentSquare = getSquare(currentSquareInfo);
            inputs[currentSquare.squareId-1]=currentSquareInfo;

            for(int i = 0 ; i < currentSquare.width ; i++){
                for(int j = 0 ; j < currentSquare.height ; j++){
                    matrix[currentSquare.xValue+i][currentSquare.yValue+j]++;

                    if(matrix[currentSquare.xValue+i][currentSquare.yValue+j] == 2){
                        overlapCounter++;
                    }
                }
            }
        }
        for(String input : inputs){

            Square currentSquare = getSquare(input);
            boolean haveOverlap = false;

            inputs[currentSquare.squareId-1]=input;
            for(int i = 0 ; i < currentSquare.width ; i++){
                for(int j = 0 ; j < currentSquare.height ; j++){
                    if(matrix[currentSquare.xValue+i][currentSquare.yValue+j] >= 2){
                        haveOverlap = true;
                    }
                }
            }
            if (!haveOverlap)
                noOverlapSquareId = currentSquare.squareId;
        }

        System.out.println("Part 1  answer: "+overlapCounter);
        System.out.println("Part 2  answer: "+noOverlapSquareId);
    }

    private static Square getSquare(String currentInput) {
        currentInput = currentInput
                .replace("#","")
                .replace(" @ ",",")
                .replace(": ",",")
                .replace("x",",");

        String[] resultInText = currentInput.split(",");
        int[] result = new int[5];
        for (int i = 0 ; i < result.length ; i++) {
            result[i] = Integer.parseInt(resultInText[i]);
        }
        return new Square(result[0],result[1],result[2],result[3],result[4]);
    }
}

class Square{
    public int squareId;
    public int xValue;
    public int yValue;
    public int width;
    public int height;

    public Square(int squareId, int xValue, int yValue, int width, int height) {
        this.squareId = squareId;
        this.xValue = xValue;
        this.yValue = yValue;
        this.width = width;
        this.height = height;
    }
}