package deepak.com.practice.practiceProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.comparator.ComparableComparator;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import deepak.com.practice.practiceProject.beans.Country;

public class CSVHandler {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String csvFile = "./csvFile.txt";
		String line;
		
		LinkedHashMap<String, String> lhp = new LinkedHashMap<>();
		lhp.put("Deepak", "Kumar");
		lhp.put("Kumar", "Deepak");
		lhp.entrySet().forEach(action->{
			System.out.println(action.getKey()+action.getValue());
		});
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			List<Country> countryList = new ArrayList<Country>();
			Country country;
			br.readLine();//skip header
			while((line = br.readLine()) !=null) {
				String [] values = line.split(",");
				country = new Country();
				country.setCurrency(values[1]);
				country.setName(values[0]);
				countryList.add(country);
			}
			
			countryList.sort((o1, o2)->o1.getCurrency().compareTo(o2.getCurrency()));
			
			countryList.forEach(o1->{
				
			});
			
			/*Collections.sort(countryList, new Comparator<Country>() {

				@Override
				public int compare(Country o1, Country o2) {
					int res1 = o1.getName().compareTo(o2.getName());
					int res2 = o1.getCurrency().compareTo(o2.getCurrency());
					if(res1 !=0) {
						return res1;
					}
					return res2;
					
				}
				
			});*/
			System.out.println("After Sorting list is:");
			countryList.forEach(action->{
				System.out.println("Country:"+action.getName() + ","+"Currency:"+action.getCurrency());
			});
			//csvWritePrintWriter();
			//openCSVReader(countryList);
			//openCSVWriter(countryList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
private static void csvWritePrintWriter() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("csvData.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Exception Writing to csv");
		}
		StringBuilder builder = new StringBuilder();
		String ColumnNamesList = "Id,Name";
		// No need give the headers Like: id, Name on builder.append
		builder.append(ColumnNamesList + "\n");
		builder.append("1" + ",");
		builder.append("Chola");
		builder.append('\n');
		pw.write(builder.toString());
		pw.close();
		System.out.println("done!");
}

private static void openCSVReader(List<Country> countryList) throws FileNotFoundException {
	CSVReader reader = new CSVReader(new FileReader("csvFile.txt"));
	
	ColumnPositionMappingStrategy<Country> beanStrategy = new ColumnPositionMappingStrategy<Country>();
	beanStrategy.setType(Country.class);
	beanStrategy.setColumnMapping(new String[] {"name","currency"});
	
	CsvToBean<Country> csvToBean = new CsvToBean<Country>();
	
	List<Country> emps = csvToBean.parse(beanStrategy, reader);
		
	}


public static void openCSVWriter(List<Country> countryList) throws Exception{
	FileWriter writer = new FileWriter("./beanTocsvFile"); 
	ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
    mappingStrategy.setType(Country.class);
    String[] columns = new String[]  { "name", "currency"}; 
    mappingStrategy.setColumnMapping(columns);
    StatefulBeanToCsvBuilder<Country> builder= 
            new StatefulBeanToCsvBuilder(writer); 
    StatefulBeanToCsv beanWriter =  
    		builder.withMappingStrategy(mappingStrategy).build(); 

// Write list to StatefulBeanToCsv object 
    beanWriter.write(countryList);
    Map<String, String> list = new HashMap<>();
    list.put("India", "INR");
    list.put("USA", "USD");
    list.put("Pakistan", "PNR");
    list.put("China", "CNR");
    list.put("Arm", "ARM");
    List <Map.Entry<String, String>>l1 = new ArrayList<>(list.entrySet());
    
    Collections.sort(l1, new Comparator<Map.Entry<String, String>>() {
		@Override
		public int compare(Entry<String, String> o1, Entry<String, String> o2) {
			return o2.getValue().compareTo(o1.getValue());
		}
	});
    
    l1.forEach(action->{
    	System.out.println(action.getKey());
    	System.out.println(action.getValue());
    });

// closing the writer object 
    writer.close();
	
}
}
