package com.adventofcode.day5.chain;

public class Polymer {

    private Cell firstCell;
    private Cell lastCell;
    private int size;

    public Polymer(String input){
        size = 0;
        for(Character character : input.toCharArray()){
            this.addCell(character);
        }
    }

    public Polymer(String input,Character withOut){
        size = 0;

        for(Character character : input.toCharArray()){
            if (character != withOut && character != (char)(withOut+32)) {
                this.addCell(character);
            }
        }
    }

    public void addCell(char character){
        Cell newCell = new Cell(character);

        if(firstCell == null){
            firstCell = newCell;
            lastCell = newCell;
        }
        else{
            Cell left = lastCell;
            lastCell = newCell;

            left.nextCell = newCell;
            newCell.previousCell = left;

        }
        size++;
    }

    public void removeAll(char unit){
        Cell currentCell = firstCell;

        while (currentCell.nextCell != null){
            if(currentCell.unit == unit){
                if(currentCell == firstCell){
                    this.firstCell = currentCell.nextCell;
                    currentCell.nextCell.previousCell = null;
                }else{
                    Cell leftCell = currentCell.previousCell;
                    Cell rightCell = currentCell.nextCell;

                    leftCell.nextCell =rightCell;
                    rightCell.previousCell = leftCell;

                }
                size--;
            }
            currentCell = currentCell.nextCell;
        }
        //if last
        if( currentCell.unit == unit){
            currentCell.previousCell.nextCell = null;
            size--;
        }

    }

    public void doChainReaction(){

        Cell currentCell = firstCell;
        while (currentCell.nextCell != null){
            if(checkIfPopOut(currentCell)){
                currentCell = popOut(currentCell);
                size = size-2;
            }
            else {
                currentCell = currentCell.nextCell;
            }
        }
    }

    public Cell popOut(Cell cell){
        Cell left = cell.previousCell;
        Cell right = cell.nextCell.nextCell;

        if(left == null){
            boolean t = true;
            right.previousCell =null;
            return right;
        }
        else if(right == null){
            boolean t = true;
            left.nextCell = null;
            return left;
        }
        else {
            left.nextCell = right;
            right.previousCell = left;
            return left;
        }

    }

    private boolean checkIfPopOut(Cell currentCell) {
        char leftUnit = currentCell.unit;
        char rightUnit = currentCell.nextCell.unit;

        return (Math.abs(leftUnit-rightUnit) == 32);
    }

    @Override
    public String toString() {
        Cell currentCell = firstCell;
        StringBuilder stringBuilder = new StringBuilder();
        while (currentCell.nextCell != null){
            stringBuilder.append(currentCell.unit);
            currentCell = currentCell.nextCell;
        }
        stringBuilder.append(currentCell.unit);

        return stringBuilder.toString();
    }

    public int getSize() {
        return size;
    }
}
