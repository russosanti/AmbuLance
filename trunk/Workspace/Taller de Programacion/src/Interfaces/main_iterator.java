package Interfaces;

import java.util.*;

public class main_iterator {
	public static void main(String[] args) {
		
		Iterator<Integer> i = new Mi_Iterador(4,9);
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for(int x=0;x<=9;x++){
			ar.add(x);
		}
		
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}
		System.out.println("");
		System.out.println("------------------------------------------");
		i = ar.iterator();
		
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}

	}

}
