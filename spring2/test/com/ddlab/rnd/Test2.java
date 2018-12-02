package com.ddlab.rnd;

import com.ddlab.rnd.spring.CapitalFactory;
import com.ddlab.rnd.spring.ICapital;

public class Test2 {

	public static void main(String[] args) {
		ICapital capital = CapitalFactory.getCapitalObject("karnataka");
		System.out.println("Name of the Capital : "+capital.getName());
                capital = CapitalFactory.getCapitalObject("karnataka");
		System.out.println("Name of the Capital : "+capital.getName());
	}

}
