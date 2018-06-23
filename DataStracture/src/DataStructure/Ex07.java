package DataStructure;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Ex07 {

	static class MyQueue<T> {
		private T[] data;
		private int front, tail, count;

		@SuppressWarnings("unchecked")
		public MyQueue(int capacity) {
			data = (T[])new Object[capacity];
			front = tail = count = 0;		
		}

		public void enqueue(T item) {
			if(count == data.length) return;
			data[tail] = item;
			tail = (tail+1)%data.length;
			count++;
		}

		public T dequeue() {
			T ans = null;
			if(count>0) {
				ans = data[front];
				front = (front+1)%data.length;
				count--;
			}
			return ans;
		}

		public T head(){
			if(count==0) return null;
			return data[front];
		}

		public int size() {
			return count;
		}

		/**
		 * Q1 - Queue - toString
		 * Complexity: O(n)
		 */
		@Override
		public String toString() {
			String ans = "[";
			for (int i = 0; i < count; i++) {
				ans = ans + data[(front+i)%data.length] + ", ";
			}
			return ans + "]";
		}

		/**
		 * Q2 - Queue - contains
		 * Complexity: O(n)
		 */
		public boolean contains(T item) {
			for (int i = 0; i < count; i++) {
				if(data[(front+i)%data.length].equals(item)) return true;
			}
			return false;
		}

		/**
		 * Q3 - Queue - element At
		 * Complexity: O(n)
		 */
		public T elementAt(int index) {
			return data[(front+index)%data.length];
		}
	}

	/**
	 * Q4 - Palindrom with Queue and Stack
	 * Complexity: O(n)
	 */
	public static boolean palindrom(String str) {
		int n = str.length(),i=0;
		ArrayBlockingQueue<Character> q = new ArrayBlockingQueue<Character>(n/2+1);
		Stack<Character> st = new Stack<Character>();
		for (i = 0; i < n/2; i++) {
			q.add(str.charAt(i));
		}
		if(n%2==1) i++;
		for (; i < n; i++) {
			st.push(str.charAt(i));
		}
		while(!st.isEmpty() && !q.isEmpty()) {
			if(st.pop()!=q.poll()) return false;
		}
		return st.isEmpty() && q.isEmpty();
	}

	/**
	 * Q5 - create sorted queue with random numbers
	 * Complexity: O(n^2)
	 */
	public static ArrayBlockingQueue<Integer> sortedQueue(int size) {
		ArrayBlockingQueue<Integer> ans = new ArrayBlockingQueue<Integer>(size);
		int count;
		for (int i = 0; i < size; i++) {
			int x = (int)(Math.random()*size*1000);
			count = 0;
			while(count<i && x>ans.peek()) {
				ans.add(ans.poll());
				count++;
			}
			if(count<i && x==ans.peek()) {
				while(count<i) {
					ans.add(ans.poll());
					count++;
				}
				i--;
				continue;
			}
			ans.add(x);
			while(count<i) {
				ans.add(ans.poll());
				count++;
			}
		}
		return ans;
	}

	/**
	 * Q6 - Two queues
	 * Complexity: constructor - O(1) , enqueue - O(1) , dequeue - O(1) , toString - O(n)
	 */
	static class TwoQueues<T> {
		private T[] data;
		private int front1, front2, tail1, tail2, count1, count2;
		private int totalsize1,totalsize2;

		@SuppressWarnings("unchecked")
		public TwoQueues(int capacity1, int capacity2) {
			data = (T[])new Object[capacity1+capacity2];
			front1 = front2 = tail1 = tail2 = count1 = count2 = 0;
			totalsize1 = capacity1;
			totalsize2 = capacity2;
		}

		public void enqueue1(T item) {
			if(count1 == data.length - count2) return;
			data[tail1] = item;
			tail1 = (tail1+1)%(totalsize1);
			count1++;
		}

		public void enqueue2(T item) {
			if(count2 == data.length - count1) return;
			data[data.length-1-tail2] = item;
			tail2 = (tail2+1)%(totalsize2);
			count2++;
		}
		
		public T dequeue1() {
			T ans = null;
			if(count1>0) {
				ans = data[front1];
				front1 = (front1+1)%(totalsize1);
				count1--;
			}
			return ans;
		}

		public T dequeue2() {
			T ans = null;
			if(count2>0) {
				ans = data[data.length-1-front2];
				front2 = (front2+1)%(totalsize2);
				count2--;
			}
			return ans;
		}
		
		public T head1(){
			if(count1==0) return null;
			return data[front1];
		}

		public T head2(){
			if(count2==0) return null;
			return data[data.length-1-front2];
		}
		
		@Override
		public String toString() {
			String ans = "Q1 = [";
			for (int i = 0; i < count1; i++) {
				ans = ans + data[(front1+i)%(totalsize1)];
				if(i!=count1-1) ans= ans + ", ";
			}
			ans = ans + "]\nQ2 = [";
			for (int i = 0; i < count2; i++) {
				ans = ans + data[data.length-1-(front2+i)%(totalsize2)];
				if(i!=count2-1) ans= ans + ", ";
			}
			return ans + "]";
		}

	}

}