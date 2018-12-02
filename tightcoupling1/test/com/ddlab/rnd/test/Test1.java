package com.ddlab.rnd.test;

import com.ddlab.rnd.core.IState;
import com.ddlab.rnd.core.Information;
import com.ddlab.rnd.ka.impl.KarnatakState;
import com.ddlab.rnd.tn.impl.TamilNaduState;

public class Test1 {

	public static void main(String[] args) {
		
		IState state = new KarnatakState();
		Information info = state.getInformation();
		System.out.println("Cultural info : "+info.getCulture().getCulturalInfo());
		System.out.println("Language : "+info.getLanguage().getName());
		
		IState state1 = new TamilNaduState();
		Information info1 = state1.getInformation();
		System.out.println("Cultural info : "+info1.getCulture().getCulturalInfo());
		System.out.println("Language : "+info1.getLanguage().getName());
		
	}

}
