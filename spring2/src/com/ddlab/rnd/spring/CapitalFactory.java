package com.ddlab.rnd.spring;

public class CapitalFactory {
	
	private CapitalFactory() {
		
	}
	
	public static ICapital getCapitalObject( String name ) {
		if( name.equalsIgnoreCase("tamilnadu"))
			return new TamilNadu();
		else if( name.equalsIgnoreCase("karnataka"))
			return new Karnataka();
		else
			return null;
	}

}
