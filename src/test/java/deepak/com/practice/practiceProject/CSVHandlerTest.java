package deepak.com.practice.practiceProject;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import deepak.com.practice.practiceProject.beans.Country;

public class CSVHandlerTest {

	 @Test
	    public void testCSVWritePrintWriter() throws Exception
	    {
		 
		 List<Country> countryList = new ArrayList<>();
		 CSVHandler.openCSVWriter(countryList);
	       System.out.println("Test");
	    }
}
