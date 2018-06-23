package Elizabet_lesson_6;

import java.util.LinkedList;


public class TestLLJava {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(1);
		System.out.println(list);
		LinkedList<Integer> list2 = new LinkedList<Integer>(list);
		System.out.println(list2);

	}

}
