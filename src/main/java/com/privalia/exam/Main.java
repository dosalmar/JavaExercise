package com.privalia.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
	
		//--------- TODO parametros!!!!
		//String path = "./stocks-ITX.csv";
		
		String path = "./UC_Tests/test-4.csv";
		
		BigDecimal inversionMensual = new BigDecimal(50);
		BigDecimal comision = new BigDecimal(2);
		//if empty file, return error
		BigDecimal totalStockQuantity = new BigDecimal(0);
		
		List<HistoricalDataRow> inputDataFromCsv = new ArrayList<HistoricalDataRow>();

		try{
			File inputF = new File(path);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

			//br.lines().forEach(line -> System.out.println(line));
			//Class<?> transformFunctions = ItxStockRow.class;
			
			inputDataFromCsv = br.lines().skip(1).map(mapStringToitxStockRow)
					.sorted((final HistoricalDataRow r1, final HistoricalDataRow r2) -> r1.getDate().compareTo(r2.getDate()))
					.collect(Collectors.toList());	
			
			//TODO ordenar las fechas por orden!!!
			
			
			//TODO ----------------------------------- Intento de lambda!!!!!!
			/*inputDataFromCsv.forEach(day -> {
				if(day.isLastThursdayOfMonth()){
					System.out.println("------- Es el ultimo jueves");
					System.out.println(day);
				}
			});*/
			
			
			//Old way
			Iterator<HistoricalDataRow> i = inputDataFromCsv.iterator();
			
			BigDecimal invesmentWOcomision = substractBrokerComision(inversionMensual, comision);

			//String initialDate = ("2000-01-01");
			
			//Boolean is = false;
			
			Calendar searchingMonth = inputDataFromCsv.get(0).getDate();
			System.out.println("FIRST:" + searchingMonth.getTime().toString());
			
			//boolean isMonthPaydayFound = false;
			while(i.hasNext()) {
				
				
				//System.out.println(searchingMonth.getTime().toString());
				HistoricalDataRow tmp = i.next();
				//System.out.println("Ya se ha encontrado dia para este mes:" + searchingMonth.getTime().toString());
				
				if(tmp.isSameMonth(searchingMonth)) {
				//TODO mirar si ya he encontrado el dia de cobrar de ese mes;
					
					if(tmp.isLastThursdayOfMonthOrAfter() ) {
						//isMonthPaydayFound = true;
						
						
						//Buscar dia de compra		
						
						if(i.hasNext()) {
							HistoricalDataRow nextOpenDay = i.next();
							System.out.println("------------------------");
							System.out.println("LastThursday: " + tmp);
							BigDecimal price = nextOpenDay.getApertura();
							System.out.println("Dia de compra: " + nextOpenDay);
							System.out.println("Ya se ha encontrado dia para este mes:" + searchingMonth.getTime().toString());
							
							//Calc numero de acciones
							BigDecimal monthStockQuantity = getStockQuantityToBuy(invesmentWOcomision, price);
							System.out.println("Cantidad comprada: " + monthStockQuantity.toString());
							totalStockQuantity = totalStockQuantity.add(monthStockQuantity);
							System.out.println("Cantidad acumulada: " + totalStockQuantity.toString());
						}else {
							System.out.println("Last row.");
							BigDecimal lastPrice = tmp.getCierre();

							System.out.println("Calculo de ganancias: " + totalStockQuantity.multiply(lastPrice));

						}
						searchingMonth.add(Calendar.MONTH, 1);
						System.out.println("---> Por eso le sumo uno:" + searchingMonth.getTime().toString());
						
					}
				}
			}			
			br.close();

		}catch(IOException e) {
			throw e;
		}

	}

	public static BigDecimal getStockQuantityToBuy(BigDecimal investment, BigDecimal price) {	
		//--------------------------------------------- Es importante si halfdown o UP???? o deberia dar lo smismo???
		
		BigDecimal t = investment.divide(price, 3, RoundingMode.HALF_UP);
		return t;
	}
	
	public static BigDecimal substractBrokerComision(BigDecimal investment, BigDecimal brokeComisionPercent) {
		BigDecimal subt = investment.multiply(brokeComisionPercent).divide(new BigDecimal (100));
		
		return investment.subtract(subt) ;
	}
	
	public static Function<String, HistoricalDataRow> mapStringToitxStockRow = (line) -> {

		//Falta controlar el error de si hay alguna linea nula!!!!
		String[] values = line.split(";");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
		java.util.Date date = null;

		try {
			date = sdf.parse(values[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();

		//System.out.println("----- Fecha en origen: " + date);
		cal.setTime(date);

		HistoricalDataRow stocks = new HistoricalDataRow(cal, new BigDecimal(values[1]), new BigDecimal(values[2]));

		return	stocks;
	};

	
	
	
}


