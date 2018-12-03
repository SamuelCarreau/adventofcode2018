package com.adventofcode.day2.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    private FileHelper(){
        //private so its a static class
    }

    public static List<String> readTextFile(String filename) {
        BufferedReader br = null;
        FileReader fr = null;
        List<String> StringList = new ArrayList<>();

        try{
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                StringList.add(sCurrentLine);
            }
            return StringList;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
