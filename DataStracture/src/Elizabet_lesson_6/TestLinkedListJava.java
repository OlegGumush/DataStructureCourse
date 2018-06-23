package Elizabet_lesson_6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class TestLinkedListJava {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(1);
		System.out.println(list);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+", ");
		}
		System.out.println();
		////////
		for (int i=0; i<list.size(); i++){
			System.out.print(list.get(i)+", ");
		}
		//////////
		System.out.println();
		ArrayList<String> al = new ArrayList<String>();
		al.add("a");
		al.add("t");
		al.add("w");
		Iterator<String> ital = al.iterator();
		while(ital.hasNext()){
			System.out.print(ital.next()+", ");
		}
		System.out.println();
	}

}
