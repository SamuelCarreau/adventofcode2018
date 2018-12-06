package com.adventofcode.day5.chain;

public class Cell {

    public char unit;
    public Cell nextCell;
    public Cell previousCell;

    public Cell(char character) {
        unit = character;
    }

}
