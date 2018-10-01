package com.privalia.integration.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.privalia.csv.CSVReader;
import com.privalia.csv.mapToHistoricalStockRow;
import com.privalia.main.CalculatorOfInvestmentStock;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.extern.log4j.Log4j;
import model.DataRow;
import model.HistoricalStockRow;
import java.util.ArrayList;



@RunWith(JUnitParamsRunner.class)
public class IntegrationTests{
		
	@Test
	@Parameters({"./UC_Tests/test-1.csv"})
	public void test1(String[] args) throws IOException, ParseException {
		String path = args[0];
		BigDecimal monthInvestment = new BigDecimal(50);
		BigDecimal brokerComission = new BigDecimal(2);

		BigDecimal profit = new BigDecimal(0);
		ArrayList inputDataFromCsv = new ArrayList();

		try{
			CSVReader csv = new mapToHistoricalStockRow();
			inputDataFromCsv = (ArrayList) csv.getObjectArray(path);
			
			CalculatorOfInvestmentStock calculator = new CalculatorOfInvestmentStock(brokerComission, monthInvestment, inputDataFromCsv);

			profit = calculator.getResultingProfit();
			System.out.println("Total amount when selling: "+ profit);
			System.out.println("------------------------------------------------");
			
			
		}catch(IOException e) {
			throw e;
		}
		BigDecimal expected = new BigDecimal(693.770).setScale(3, RoundingMode.HALF_DOWN);
		Assert.assertEquals(expected, profit);

	}
	
	@Test
	@Parameters({"./UC_Tests/test-2.csv"})
	public void test2(String[] args) throws IOException, ParseException {
		String path = args[0];
		BigDecimal monthInvestment = new BigDecimal(50);
		BigDecimal brokerComission = new BigDecimal(2);
		BigDecimal profit = new BigDecimal(0);
		
		ArrayList inputDataFromCsv = new ArrayList();

		try{
			CSVReader csv = new mapToHistoricalStockRow();
			inputDataFromCsv = (ArrayList) csv.getObjectArray(path);
			
			CalculatorOfInvestmentStock calculator = new CalculatorOfInvestmentStock(brokerComission, monthInvestment, inputDataFromCsv);

			profit = calculator.getResultingProfit();
			System.out.println("Total amount when selling: "+ profit);
			System.out.println("------------------------------------------------");
			
	

		}catch(IOException e) {
			throw e;
		}
		BigDecimal expected = new BigDecimal(48.453).setScale(3, RoundingMode.HALF_DOWN);
			Assert.assertEquals(expected, profit);
	}
	
	@Test
	@Parameters({"./UC_Tests/test-3.csv"})
	public void test3(String[] args) throws IOException, ParseException {
		String path = args[0];
		BigDecimal monthInvestment = new BigDecimal(50);
		BigDecimal brokerComission = new BigDecimal(2);
		BigDecimal profit = new BigDecimal(0);
		
		ArrayList inputDataFromCsv = new ArrayList();

		try{
			CSVReader csv = new mapToHistoricalStockRow();
			inputDataFromCsv = (ArrayList) csv.getObjectArray(path);
			
			CalculatorOfInvestmentStock calculator = new CalculatorOfInvestmentStock(brokerComission, monthInvestment, inputDataFromCsv);

			profit = calculator.getResultingProfit();
			System.out.println("Total amount when selling: "+ profit);
			System.out.println("------------------------------------------------");
	
		}catch(IOException e) {
			throw e;
		}
		
		BigDecimal expected = new BigDecimal(48.761).setScale(3, RoundingMode.HALF_DOWN);
			Assert.assertEquals(expected, profit);
	}
	
	@Test
	@Parameters({"./UC_Tests/test-4.csv"})
	public void test4(String[] args) throws IOException, ParseException {
		String path = args[0];
		BigDecimal monthInvestment = new BigDecimal(50);
		BigDecimal brokerComission = new BigDecimal(2);
		BigDecimal profit = new BigDecimal(0);
		
		ArrayList inputDataFromCsv = new ArrayList();

		try{
			CSVReader csv = new mapToHistoricalStockRow();
			inputDataFromCsv = (ArrayList) csv.getObjectArray(path);
			
			CalculatorOfInvestmentStock calculator = new CalculatorOfInvestmentStock(brokerComission, monthInvestment, inputDataFromCsv);

			profit = calculator.getResultingProfit();
			System.out.println("Total amount when selling: "+ profit);
			System.out.println("------------------------------------------------");
			
			BigDecimal expected = new BigDecimal(144.428).setScale(3, RoundingMode.HALF_DOWN);
			
			Assert.assertEquals(expected, profit);
		}catch(IOException e) {
			throw e;
		}

		//assertTrue(actualSum == expectedSum);
	}
	
}
