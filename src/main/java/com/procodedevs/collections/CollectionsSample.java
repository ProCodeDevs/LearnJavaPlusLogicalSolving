package com.procodedevs.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

public class CollectionsSample {

	
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		Set<StringBuffer> setNames = new HashSet<StringBuffer>();
		
		names.add("abi");
		names.add("abi");
		names.add("akshatha");
		names.add("java");
		names.add("python");
		names.add("python");
		names.add("vignesh");
		
		setNames.add(new StringBuffer("abi"));
		setNames.add(new StringBuffer("abi"));
		setNames.add(new StringBuffer("akshatha"));
		setNames.add(new StringBuffer("java"));
		setNames.add(new StringBuffer("python"));
		setNames.add(new StringBuffer("python"));
		setNames.add(new StringBuffer("vignesh"));
		
		String x = "vignesh";
		System.out.println(x.hashCode());
		
		String y = new String("vignesh");
		
		System.out.println(y.hashCode());
		
		System.out.println("vignesh".equals("vignesh"));
		
		System.out.println("Printing from list");
		for(String name:names) {
			System.out.println(name);
		}
		
		System.out.println("Printing from set");
		for(StringBuffer name:setNames) {
			System.out.println(name);
		}
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(names));
	}
	
}
