package deepak.com.practice.practiceProject.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortMapByValKey {

	public static void main(String[] args) {
		Map<String, Integer> myMap = new HashMap<>();
		myMap.put("Deepak", 1);
		myMap.put("Ravindra", 1);
		myMap.put("Aadarsh", 2);
		myMap.put("Rishabh", 2);
		//normal sorting
		Map<String, Integer> sortedMap = myMap.entrySet().stream().sorted((v1,v2)->v2.getValue().compareTo(v1.getValue()))
		.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(o1,o2)->o1,LinkedHashMap::new));
		
		//method 1
		Map<String, Integer> sortedMap2 = myMap.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
				.thenComparing(Map.Entry.<String,Integer>comparingByKey()))
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(o1,o2)->o1,LinkedHashMap::new));
		
		
		//Method2
		Map<String, Integer> sortedMap3 = myMap.entrySet()
                .stream()
                .sorted(
                        new Comparator<Map.Entry<String, Integer>>() {
                            @Override
                            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                                if(o1.getValue() < o2.getValue()) {
                                    return  -1;
                                }
                                if(o1.getValue() > o2.getValue()) {
                                    return 1;
                                }
                                return o1.getKey().compareTo(o2.getKey());

                            }
                        }
                )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
		
		
		sortedMap2.forEach((k,v)-> {
			System.out.println("key:"+k+"value:"+v);
		});
		

	}

}
