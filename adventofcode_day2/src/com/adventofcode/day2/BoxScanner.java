package com.adventofcode.day2;

import javafx.util.Pair;

import java.util.List;

public class BoxScanner {



    private String commonLetterFromMatchingPair;
    private List<String> boxIds;

    public BoxScanner(List<String> boxIds){
        this.boxIds = boxIds;

        this.commonLetterFromMatchingPair = findCommonLetterFromMatchingPair();
    }

    public String getCommonLetterFromMatchingPair() {
        return commonLetterFromMatchingPair;
    }

    private String findCommonLetterFromMatchingPair() {
        StringBuilder result = new StringBuilder();
        Pair<String,String> betterMatchingPair = searchForBetterPair();

        for ( int i = 0 ; i < betterMatchingPair.getKey().toCharArray().length ; i++){
            if(betterMatchingPair.getKey().charAt(i) == betterMatchingPair.getValue().charAt(i))
                result.append(betterMatchingPair.getKey().charAt(i));
        }
        return result.toString();
    }

    private Pair<String,String> searchForBetterPair(){
        String selectedBoxId = this.boxIds.get(0);
        String betterMatchWithSelectedBoxId = this.boxIds.get(1);
        Pair<String,String> betterMatchingPairFound = new Pair<>(selectedBoxId,betterMatchWithSelectedBoxId);

        for(int i = 0 ; i < this.boxIds.size()-1 ; i ++){
            selectedBoxId = this.boxIds.get(i);

            betterMatchWithSelectedBoxId =  getBetterMatchingBoxIdWhitGivenBoxId(selectedBoxId);

            Pair<String,String> PairWithSelected = new Pair<>(selectedBoxId,betterMatchWithSelectedBoxId);

            if(getScore(PairWithSelected) > getScore(betterMatchingPairFound))
                betterMatchingPairFound = PairWithSelected;
        }

        return betterMatchingPairFound;
    }

    private int getScore(Pair<String,String> pairOfBoxId){
        int score = 0;
        for(int i = 0 ; i < pairOfBoxId.getKey().length() ; i++){
            if(pairOfBoxId.getKey().charAt(i) == pairOfBoxId.getValue().charAt(i)){
                score++;
            }
        }
        return score;
    }

    private int getScore(String leftBoxId, String rigthBoxId){
        int score = 0;
        for(int i = 0 ; i < leftBoxId.length() ; i++){
            if(leftBoxId.charAt(i) == rigthBoxId.charAt(i)){
                score++;
            }
        }
        return score;
    }

    private String getBetterMatchingBoxIdWhitGivenBoxId(String selectedBoxId){
        int betterScore = 0;
        String betterMatch = this.boxIds.get(this.boxIds.indexOf(selectedBoxId)+1);
        for(int i = this.boxIds.indexOf(selectedBoxId)+1; i < this.boxIds.size() ; i++){
            int tempScore = getScore(selectedBoxId,this.boxIds.get(i));
           if(tempScore > betterScore){
               betterScore = tempScore;
               betterMatch = this.boxIds.get(i);
           }
        }
        return betterMatch;
    }


}


