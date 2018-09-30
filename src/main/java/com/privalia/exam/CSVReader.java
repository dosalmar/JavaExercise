package com.privalia.exam;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class CSVReader {

    private static final char DEFAULT_SEPARATOR = ';';
    
    private static final char DEFAULT_QUOTE = '"';
    
        
    public static List<String> parseLine(String cvsLine, char separators) {

        List<String> result = new ArrayList<>();

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        String[] chars = cvsLine.split("DEFAULT_SEPARATOR");

        
        return result;
    }

    


}
