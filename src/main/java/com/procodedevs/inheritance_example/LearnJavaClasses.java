package com.procodedevs.inheritance_example;

import com.procodedevs.inheritance_example.juice.Juice;
import com.procodedevs.inheritance_example.maker.LemonJuiceMaker;
import com.procodedevs.inheritance_example.maker.Maker;
import com.procodedevs.inheritance_example.maker.SugarCaneJuiceMaker;

public class LearnJavaClasses {

	
	
	public static void main(String[] args) {
		
		Maker maker = new SugarCaneJuiceMaker();
		
		Juice juice1 = maker.makeJuice();
		Juice juice2 = new LemonJuiceMaker().makeJuice();
		
		System.out.println(juice1.getName());
		
		System.out.println(juice2.getName());
		
	}
	
}
