package deepak.com.practice.practiceProject;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class Java8DateFeature {

	public static void main(String[] args) {

		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = LocalDateTime.now();
		LocalTime lt =LocalTime.now();
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(ld);
		
		LocalDateTime i = LocalDateTime.ofInstant(Instant.now(),ZoneOffset.UTC);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm dd yyyy");
		

	}

}
