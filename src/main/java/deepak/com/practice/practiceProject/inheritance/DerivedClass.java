package deepak.com.practice.practiceProject.inheritance;

import deepak.com.practice.practiceProject.BaseInterface;

public class DerivedClass extends BaseClass1 implements BaseInterface,BaseInterface1 {
	public void getName(){
		System.out.println("Method from Derived Class Called ");
	}

	@Override
	public void printname() {
		System.out.println("Deepak From Interface Implementation");
		
	}

}
