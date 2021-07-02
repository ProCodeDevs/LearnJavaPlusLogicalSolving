package com.procodedevs.inheritance_example.maker;

import com.procodedevs.inheritance_example.juice.Juice;
import com.procodedevs.inheritance_example.juice.LemonJuice;

public class LemonJuiceMaker implements Maker {

	@Override
	public Juice makeJuice() {
		return new LemonJuice();
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}


	

}
