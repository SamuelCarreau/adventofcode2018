package com.adventofcode.day2;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxScoreTest {

    @Test
    public void testingBox1(){
        BoxScore idBox = new BoxScore("abcdef");
        //box1 expect // no letters that appear exactly two or three times.
        assertEquals(0,idBox.haveDoublet());
        assertEquals(0,idBox.haveTriplet());
    }

    @Test
    public void testingBox2(){
        BoxScore idBox = new BoxScore("bababc");
        // two a and three b, so it counts for both.
        assertEquals(1,idBox.haveDoublet());
        assertEquals(1,idBox.haveTriplet());
    }

    @Test
    public void testingBox3(){
        BoxScore idBox = new BoxScore("abbcde"); // two b, but no letter appears exactly three times.
        assertEquals(1,idBox.haveDoublet());
        assertEquals(0,idBox.haveTriplet());
    }
    @Test
    public void testingBox4(){
        BoxScore idBox = new BoxScore("abcccd"); // three c, but no letter appears exactly two times.
        assertEquals(0,idBox.haveDoublet());
        assertEquals(1,idBox.haveTriplet());
    }
    @Test
    public void testingBox5(){
        BoxScore idBox = new BoxScore("aabcdd"); // two a and two d, but it only counts once.
        assertEquals(1,idBox.haveDoublet());
        assertEquals(0,idBox.haveTriplet());
    }
    @Test
    public void testingBox6(){
        BoxScore idBox = new BoxScore("abcdee"); // contains two e.
        assertEquals(1,idBox.haveDoublet());
        assertEquals(0,idBox.haveTriplet());
    }

    @Test
    public void testingBox7(){
        BoxScore idBox = new BoxScore("ababab"); // contains three a and three b, but it only counts once.0,1
    }
}