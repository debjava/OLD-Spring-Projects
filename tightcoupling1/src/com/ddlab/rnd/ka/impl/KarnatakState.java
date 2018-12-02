package com.ddlab.rnd.ka.impl;

import com.ddlab.rnd.core.IState;
import com.ddlab.rnd.core.Information;

public class KarnatakState implements IState {

	@Override
	public Information getInformation() {
		return new KarnatakInfo();
	}
}
