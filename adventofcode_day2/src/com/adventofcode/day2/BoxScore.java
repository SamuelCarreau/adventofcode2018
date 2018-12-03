package com.adventofcode.day2;

import java.util.ArrayList;
import java.util.List;

public class BoxScore {

    private int doubleFound;
    private int tripleFound;
    private String boxId;

    public BoxScore(String boxId){
        this.boxId = boxId;
        this.doubleFound = 0;
        this.tripleFound = 0;

        calculateScore();
    }

    public int haveDoublet() {
        return doubleFound;
    }

    public int haveTriplet() {
        return tripleFound;
    }

    public void calculateScore(){

        List<Character> characterList = getCharacterList(this.boxId);

        //regarde le pointage pour le premier caracter de la liste
        while(characterList.size() >0){
            Character selectedCharacter = characterList.get(0);
            int result = checkCharCount(characterList,selectedCharacter);

            if( result >= 3){
                this.tripleFound = 1;
                removeAllSelectedCharFromList(characterList,selectedCharacter);
            }else if(result == 2){
                this.doubleFound = 1;
                removeAllSelectedCharFromList(characterList,selectedCharacter);
            }
            else {
                characterList.remove(0);
            }
        }
    }

    private List<Character> getCharacterList(String boxId) {
        ArrayList<Character> result = new ArrayList<>();
        for(int i = 0 ; i < boxId.length() ; i++)
            result.add(boxId.charAt(i));
        return result;
    }

    private int checkCharCount(List<Character> characterList,Character charToFind) {
        int nbOfCharToFind = 0;
        for(Character character : characterList){
            if(character.equals(charToFind))
                nbOfCharToFind++;
        }
        return nbOfCharToFind;
    }

    private void removeAllSelectedCharFromList(List<Character> characters, Character toRemove){
        if(characters.remove(toRemove)){
            removeAllSelectedCharFromList(characters,toRemove);
        }
    }


}
