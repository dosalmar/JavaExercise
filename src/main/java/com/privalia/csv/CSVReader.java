package com.privalia.csv;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.DataRow;
import model.HistoricalStockRow;


public abstract class CSVReader {
        
        protected BufferedReader readFile(String path) throws FileNotFoundException {
            File inputF = new File(path);
        	InputStream inputFS = new FileInputStream(inputF);
        	BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        	
        	return br;
        }
         
        public abstract List<DataRow> getObjectArray(String path) throws IOException;



}
