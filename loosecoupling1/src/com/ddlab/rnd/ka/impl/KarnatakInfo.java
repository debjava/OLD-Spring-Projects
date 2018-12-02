package com.ddlab.rnd.ka.impl;

import com.ddlab.rnd.core.ICulture;
import com.ddlab.rnd.core.ILanguage;
import com.ddlab.rnd.core.Information;

public class KarnatakInfo implements Information {

	private ILanguage lang;
	private ICulture culture;
	
	public KarnatakInfo( ILanguage lang , ICulture culture ) {
		this.lang = lang;
		this.culture = culture;
	}
	
	@Override
	public ILanguage getLanguage() {
		return lang;
	}

	@Override
	public ICulture getCulture() {
		return culture;
	}

}
