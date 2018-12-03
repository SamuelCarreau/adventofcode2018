package com.adventofcode.day2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoxScannerTest {

    @Test
    public void sameTestHasTheWebSite(){
       List<String> stringList =  new ArrayList<>();
        stringList.add("abcde");
        stringList.add("fghij");
        stringList.add("klmno");
        stringList.add("pqrst");
        stringList.add("fguij");
        stringList.add("axcye");
        stringList.add("wvxyz");

        BoxScanner boxScanner= new BoxScanner(stringList);

        assertEquals("fgij",boxScanner.getCommonLetterFromMatchingPair());

    }
}