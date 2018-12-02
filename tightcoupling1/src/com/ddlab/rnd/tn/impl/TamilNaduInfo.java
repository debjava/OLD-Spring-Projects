package com.ddlab.rnd.tn.impl;

import com.ddlab.rnd.core.ICulture;
import com.ddlab.rnd.core.ILanguage;
import com.ddlab.rnd.core.Information;

public class TamilNaduInfo implements Information {

	@Override
	public ILanguage getLanguage() {
		return new TamilLang();
	}

	@Override
	public ICulture getCulture() {
		return new TamilCulture();
	}

}
