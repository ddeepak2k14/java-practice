package deepak.com.practice.practiceProject.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import deepak.com.practice.practiceProject.beans.Country;

public class LamdaPractice {
	public static void main(String[] args) {
		List<Country> countrylist = new ArrayList<>();
		countrylist.add(new Country("India","INR"));
		countrylist.add(new Country("Pakistan","PNR"));
		countrylist.add(new Country("England","POUND"));
		countrylist.add(new Country("USA","USD"));
		countrylist.add(new Country("Hongkong","HKD"));
		countrylist.add(new Country("Brajil","BRD"));
		countrylist.forEach(action->{
			System.out.println("Country:" + action.getName()+ "Currency: "+action.getCurrency());
		});
		
		/*countrylist.sort((c1,c2)->{
			return c1.getName().compareTo(c2.getName());
		});*/
		
		List<Country> list2 = countrylist.stream().sorted(Comparator.comparing(Country::getName).thenComparing(Country::getCurrency)).collect(Collectors.toList());
		
		list2.forEach(action->{
			System.out.println("Country:" + action.getName()+ "Currency: "+action.getCurrency());
		});
		
		List<String> liststr = countrylist.stream().map(x->{
			return x.getName().toLowerCase();
		})
		.collect(Collectors.toList());
		liststr.forEach(action->{
			System.out.println(action);
		});
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		List<Country> filteredList = countrylist.stream().filter(x->{
			if(x.getName().equals("India")) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		
		System.out.println("Size" + filteredList.size());
		
		filteredList.forEach(action->{
			System.out.println(action.getName());
		});
		
		filteredList.forEach(action->{
			System.out.println(action.getName());
		});
		
		/*items.forEach((k,v)->{
			System.out.println("Key is:" + k + " Value is:" + v);
		});*/
	}

}
