package deepak.com.practice.practiceProject;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.scheduling.annotation.Scheduled;

import deepak.com.practice.practiceProject.inheritance.BaseClass1;
import deepak.com.practice.practiceProject.inheritance.BaseClass2;
import deepak.com.practice.practiceProject.inheritance.BaseInterface1;
import deepak.com.practice.practiceProject.inheritance.DerivedClass;

/**
 * Hello world!
 *
 */
public class App implements BaseInterface,BaseInterface1
{
	public static double i= .25;
	static String name="Deepak New";
    public static void main( String[] args )
    {
    	
    	System.out.println(10/i);
    	System.out.println(name);
        System.out.println( "Hello World!" );
        DerivedClass base = new DerivedClass();
        base.getName();
        base.printname();
        BaseClass1 base1 = new BaseClass1();
        base1.getName();
        
        Stream<BaseClass1> stream = Stream.of(new BaseClass1(),new BaseClass1(),new BaseClass1());
        stream.forEach(action-> {
        System.out.println(action);	
        
//        List<File> files= Arrays.asList(new File("./").listFiles());
//        System.out.println(files.size());
        });
        
       // overLoadingExm(null,null); //method ambiguous exception
        
       /* String value = tryCatchFinallyReturn();
        System.out.println("Returned value from exception:"+value );*/
    }

	private static String tryCatchFinallyReturn() {
		try{
        	System.out.println("inside try");
        	throw new NullPointerException();
        }catch(Exception e){
        	System.out.println("Inside catch");
        	return "Catch";
        }
        finally{
        	System.out.println("inside finally");
        	return "Finally";
        }
		
	}

	@Override
	public void printname() {
		System.out.println("Deepak");
		
	}
	
	public static void overLoadingExm(Integer i,String str) {
		System.out.println("Overloading Example :" + i+str);
	}
	
	public static void overLoadingExm(Integer i,Integer str) {
		System.out.println("Overloading Example :" + i+str);
	}
	
	@Scheduled(cron = "* 0/1 * * * *")
	public void testScheduler(){
		System.out.println("Hello");
		
	}
}
