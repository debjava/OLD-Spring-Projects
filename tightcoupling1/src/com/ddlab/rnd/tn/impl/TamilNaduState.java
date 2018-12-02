package com.ddlab.rnd.tn.impl;

import com.ddlab.rnd.core.IState;
import com.ddlab.rnd.core.Information;

public class TamilNaduState implements IState {

	@Override
	public Information getInformation() {
		return new TamilNaduInfo();
	}
}
