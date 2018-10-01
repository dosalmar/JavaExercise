package com.privalia.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.privalia.csv.CSVReader;
import com.privalia.csv.mapToHistoricalStockRow;
import model.DataRow;



public class Main {

	public static void main(String[] args) throws IOException {
		String path = args[0];
		//String path = "./stocks-ITX.csv";
		
		 
		
		BigDecimal monthInvestment = new BigDecimal(50);
		BigDecimal brokerComission = new BigDecimal(2);

		
		List<DataRow> inputDataFromCsv = new ArrayList<DataRow>();

		try{
			CSVReader csv = new mapToHistoricalStockRow();
			inputDataFromCsv = csv.getObjectArray(path);
			
			CalculatorOfInvestmentStock calculator = new CalculatorOfInvestmentStock(brokerComission, monthInvestment, inputDataFromCsv);

			BigDecimal profit = calculator.getResultingProfit();
			System.out.println("Total amount when selling: "+ profit);
			System.out.println("------------------------------------------------");
		}catch(IOException e) {
			throw e;
		}

	}
}


