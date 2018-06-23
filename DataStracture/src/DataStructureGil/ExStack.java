package DataStructureGil;

import java.util.Stack;

public class ExStack {
	/**
	 * Q1 - two elements in stack with sum 0
	 * Complexity: O(n^2)
	 */
	public static boolean towInStackWithSumZero(Stack<Integer> st) {
		if(st.isEmpty())
			return false;
		int x;
		Stack<Integer> temp = new Stack<Integer>();
		while(st.size()>1) {
			x = st.pop();
			while(!st.isEmpty()) {
				if(x + st.peek() == 0) return true;
				temp.push(st.pop());
			}
			while(!temp.isEmpty()) st.push(temp.pop());
		}
		return false;
	}
	
	/**
	 * Q2 - Reverse number using stack
	 * Complexity: O(log n)
	 */
	public static int reverseNumber(int num) {
		Stack<Integer> st = new Stack<Integer>();
		while(num!=0) {
			st.push(num%10);
			num/=10;
		}
		int ans = 0, d=1;
		while(!st.isEmpty()) {
			ans += d*st.pop();
			d*=10;
		}
		return ans;
	}
	
	/**
	 * Q3 - Reverse  stack
	 * Complexity: O(n)
	 */
	public static Stack<Integer> reverseStack(Stack<Integer> st) {
		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> ans = new Stack<Integer>();
		while(!st.isEmpty()) {
			temp.push(st.peek());
			ans.push(st.pop());
		}
		while(!temp.isEmpty()) st.push(temp.pop());
		return ans;
	}
	
	/**
	 * Q4 - Sort stack
	 * Complexity: O(n^2)
	 */
	public static void sortStack(Stack<Integer> st) {
		Stack<Integer> temp1 = new Stack<Integer>();
		Stack<Integer> temp2 = new Stack<Integer>();
		while(!st.isEmpty()) {
			int x = st.pop();
			while(!temp1.isEmpty() && x>temp1.peek()) {
				temp2.push(temp1.pop());
			}
			temp1.push(x);
			while(!temp2.isEmpty()) temp1.push(temp2.pop());
		}
		while(!temp1.isEmpty()) st.push(temp1.pop());
	}
	
	/**
	 * Q5 - move elements in cycle (stack)
	 * Complexity: O(n)
	 */
	public static void moveCycle(Stack<Integer> st) {
		if(st.isEmpty()) return;
		Stack<Integer> temp = new Stack<Integer>();
		while(st.size()>1) temp.push(st.pop());
		int x = st.pop();
		while(!temp.isEmpty()) st.push(temp.pop());
		st.push(x);
	}
}