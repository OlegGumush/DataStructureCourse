package Elizabet_lesson_5;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;


public class JavaStackQueue {

	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		st.push("x");
		st.push("a");
		st.push("w");
		st.push("r");
		System.out.println(st.toString());
		while(!st.isEmpty()){
			System.out.print(st.pop() + ", ");
		}
		System.out.println("\n");
		////////////
		ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(5);
		q.add("x");
		q.add("a");
		q.add("w");
		q.add("r");
		System.out.println(q);
		while(!q.isEmpty()){
			System.out.print(q.poll() + ", ");
		}
		System.out.println();
		
	}

}
