package DataStructure;

import java.util.Stack;

public class Ex06 {
	/**
	 * Q1 - Valid brackets
	 * Complexity: O(n)
	 */
	public static boolean validBrackets(String expr) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			if(ch=='(' || ch=='[' || ch=='{') st.push(ch);
			if(ch==')')
				if(st.isEmpty() || st.pop()!='(') return false;
			if(ch==']')
				if(st.isEmpty() || st.pop()!='[') return false;
			if(ch=='}')
				if(st.isEmpty() || st.pop()!='{') return false;
		}
		return st.isEmpty();
	}
	
	/**
	 * Q2 - check if the digits of the number are symmetric to the point
	 * Complexity: O(n)
	 */
	public static boolean symmetricPoint(String num) {
		if(num.length()==0) return true;
		Stack<Character> st = new Stack<Character>();
		int i = 0;
		while(num.charAt(i)!='.') {
			st.push(num.charAt(i));
			i++;
		}
		i++;
		while(!st.isEmpty()) {
			if(st.pop()!=num.charAt(i)) return false;
			i++;
		}
		return st.isEmpty() && i==num.length();
	}
	
	/**
	 * Q3 - insert array into stack in an orderly way
	 * Complexity: O(n^2)
	 */
	public static Stack<Integer> arrayIntoStack(int[] a) {
		Stack<Integer> ans = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		for (int i = 0; i < a.length; i++) {
			while(!ans.isEmpty() && a[i]<ans.peek()) {
				temp.push(ans.pop());
			}
			ans.push(a[i]);
			while(!temp.isEmpty()) {
				ans.push(temp.pop());
			}
		}
		return ans;
	}
	
	/**
	 * Q4 - Two Stacks with one array
	 * Complexity: constructor - O(1) , push - O(1) , pop - O(1) , contain - O(n) , toString - O(n)
	 */
	static class TwoStacks<T> {
		private T[] data;
		private int size1,size2;
		
		@SuppressWarnings("unchecked")
		public TwoStacks(int totalCapacity) {
			size1 = size2 = 0;
			data = (T[])new Object[totalCapacity];
		}
		
		public void push1(T item) {
			if(size1 == data.length - size2) return;
			data[size1] = item;
			size1++;
		}
		
		public void push2(T item) {
			if(size2 == data.length - size1) return;
			data[data.length-1-size2] = item;	
			size2++;
		}
		
		public T pop1() {
			if(size1==0) return null;
			size1--;
			return data[size1];
		}
		
		public T pop2() {
			if(size2==0) return null;
			size2--;
			return data[data.length-1-size2];
		}
		
		@Override
		public String toString() {
			String ans = "S1 = [";
			for (int i = 0; i < size1-1; i++) {
				ans = ans + data[i] + ", ";
			}
			if(size1>0)ans = ans + data[size1-1];
			ans = ans + "]\nS2 = [";
			for (int i = 0; i < size2-1; i++) {
				ans = ans + data[data.length-1-i] + ", ";
			}
			if(size2>0)ans = ans + data[data.length-size2];
			ans = ans + "]";
			return ans;
		}
	}

}