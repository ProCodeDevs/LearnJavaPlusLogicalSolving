package com.procodedevs.inheritance_example.maker;

import com.procodedevs.inheritance_example.juice.Juice;
import com.procodedevs.inheritance_example.juice.SugarCaneJuice;

public class SugarCaneJuiceMaker implements Maker{


	public void turnOn() {

	}

	public void turnOff() {

	}

	@Override
	public Juice makeJuice() {
		return new SugarCaneJuice();
	}

}
