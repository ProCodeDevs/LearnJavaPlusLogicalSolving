package com.procodedevs.inheritance_example.maker;

import com.procodedevs.inheritance_example.juice.Juice;

public interface Maker {

	
	public void turnOn();
	
	public void turnOff();
	
	public Juice makeJuice();
}
