package com.procodedevs.sortingproblem;

public class SortingProblem {
	
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6};	
		int sortMethod = getSortMethod(array);
		switch (sortMethod) {
		case 0:
			System.out.println("Ascending");
			break;
		case 1:
			System.out.println("Descending");
			break;
		default:
			System.out.println("Random");
			break;
		}
	}
	

	private static int getSortMethod(int[] array) {
		boolean ascending=true,descending=true;
		for(int i=0;i<array.length-1;i++) {
			if(array[i] > array[i+1] && ascending) {
				ascending = false;
			}
			if(array[i] < array[i+1] && descending) {
				descending = false;
			}
			if(!ascending && !descending) {
				return -1;
			}
		}
		return ascending ? 0 : 1;
	}
	
	
}
