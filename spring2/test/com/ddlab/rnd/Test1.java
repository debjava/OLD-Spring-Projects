package com.ddlab.rnd;

import com.ddlab.rnd.spring.ICapital;
import com.ddlab.rnd.spring.Karnataka;
import com.ddlab.rnd.spring.TamilNadu;

public class Test1 {
	
	public static void main(String[] args) {
		
//		ICapital capital = new Karnataka();
		ICapital capital = new TamilNadu();
		System.out.println("Name of the Capital : "+capital.getName());
	}

}
