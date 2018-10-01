package com.privalia.unit.test;

import static org.junit.Assert.assertEquals;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Test;


import com.privalia.main.CalculatorOfInvestmentStock;

import model.DataRow;
import model.HistoricalStockRow;


public class CalculatorOfInvestmentStockTest {
	
	@Test
	public void testTotalStock() throws IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse("29-09-2017"));
		HistoricalStockRow h1 = new HistoricalStockRow(cal, new BigDecimal(1), new BigDecimal(1));
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(formatter.parse("27-10-2017"));
		HistoricalStockRow h2 = new HistoricalStockRow(cal2, new BigDecimal(1), new BigDecimal(1));
		
		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(formatter.parse("30-11-2017"));
		HistoricalStockRow h3 = new HistoricalStockRow(cal3, new BigDecimal(1), new BigDecimal(1));
		
		Calendar cal4 = Calendar.getInstance();
		cal4.setTime(formatter.parse("01-12-2017"));
		HistoricalStockRow h4 = new HistoricalStockRow(cal4, new BigDecimal(1), new BigDecimal(1));
				
		ArrayList<DataRow> historicalStockList = new ArrayList<DataRow>();
	
		historicalStockList.add(h1);
		historicalStockList.add(h2);
		historicalStockList.add(h3);
		historicalStockList.add(h4);

		CalculatorOfInvestmentStock calculator = new CalculatorOfInvestmentStock(new BigDecimal(2), new BigDecimal(50), historicalStockList);
		
		BigDecimal c = calculator.getTotalStock().setScale(3, RoundingMode.HALF_DOWN);

		assertEquals( new BigDecimal(147).setScale(3, RoundingMode.HALF_DOWN), c);
	}
	
	
	@Test
	public void testResultingProfit() throws IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse("29-09-2017"));
		HistoricalStockRow h1 = new HistoricalStockRow(cal, new BigDecimal(1), new BigDecimal(1));
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(formatter.parse("27-10-2017"));
		HistoricalStockRow h2 = new HistoricalStockRow(cal2, new BigDecimal(1), new BigDecimal(1));
		
		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(formatter.parse("30-11-2017"));
		HistoricalStockRow h3 = new HistoricalStockRow(cal3, new BigDecimal(1), new BigDecimal(1));
		
		Calendar cal4 = Calendar.getInstance();
		cal4.setTime(formatter.parse("01-12-2017"));
		HistoricalStockRow h4 = new HistoricalStockRow(cal4, new BigDecimal(2), new BigDecimal(1));
				
		ArrayList historicalStockList = new ArrayList();
	
		historicalStockList.add(h1);
		historicalStockList.add(h2);
		historicalStockList.add(h3);
		historicalStockList.add(h4);


		CalculatorOfInvestmentStock calculator = new CalculatorOfInvestmentStock(new BigDecimal(2), new BigDecimal(50), historicalStockList);
		
		BigDecimal c = calculator.getResultingProfit();
		
		assertEquals( new BigDecimal(294).setScale(3, RoundingMode.HALF_DOWN), c);
	}
}
