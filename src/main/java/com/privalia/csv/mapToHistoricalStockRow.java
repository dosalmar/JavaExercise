package com.privalia.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.extern.log4j.Log4j;
import model.DataRow;
import model.HistoricalStockRow;

public class mapToHistoricalStockRow extends CSVReader{
	public mapToHistoricalStockRow() {
		
	}
	
    public List<DataRow> getObjectArray(String path) throws IOException {
    	List<DataRow> inputDataFromCsv = new ArrayList<DataRow>();
    	BufferedReader br = readFile(path);
    	inputDataFromCsv = br.lines().skip(1).map(mapStringToHistoricalStockRow)
    			.sorted((final HistoricalStockRow r1, final HistoricalStockRow r2) -> r1.getDate().compareTo(r2.getDate()))
    			.collect(Collectors.toList());	
    	br.close();
    	
    	return inputDataFromCsv;
    }

    
	public static Function<String, HistoricalStockRow> mapStringToHistoricalStockRow = (line) -> {
		String[] values = line.split(";");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		java.util.Date date = null;

		try {
			date = formatter.parse(values[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		HistoricalStockRow stocks = new HistoricalStockRow(cal, new BigDecimal(values[1]), new BigDecimal(values[2]));

		return	stocks;
	};


}
