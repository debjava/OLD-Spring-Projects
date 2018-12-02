package com.ddlab.rnd.ka.impl;

import com.ddlab.rnd.core.IState;
import com.ddlab.rnd.core.Information;

public class KarnatakState implements IState {

	private Information info;
	
	public KarnatakState( Information info ) {
		this.info = info;
	}
	@Override
	public Information getInformation() {
		return info;
	}
}
