package com.ddlab.rnd.ka.impl;

import com.ddlab.rnd.core.ICulture;
import com.ddlab.rnd.core.ILanguage;
import com.ddlab.rnd.core.Information;

public class KarnatakInfo implements Information {

	@Override
	public ILanguage getLanguage() {
		return new KannadaLang();
	}

	@Override
	public ICulture getCulture() {
		return new KarnatakiCulture();
	}

}
