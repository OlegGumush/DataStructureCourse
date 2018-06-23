package DataStructureGil;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class ExQueue {
	/**
	 * Q1 - Double Queue
	 * Complexity: constructor O(1), copy constructor - O(n) , enqueue,head,tail,dequeue - O(1)
	 */
	static class DoubleQueue<T> {
		private T[] data;
		private int front, tail, count;

		@SuppressWarnings("unchecked")
		public DoubleQueue(int capacity) {
			data = (T[])new Object[capacity];
			front = tail = count = 0;		
		}

		@SuppressWarnings("unchecked")
		public DoubleQueue(DoubleQueue<T> q) {
			data = (T[])new Object[q.data.length];
			for (int i = 0; i < q.count; i++) {
				data[i] = q.data[q.front+i];
			}
		}

		public void enqueueTail(T item) {
			if(count == data.length) return;
			data[tail] = item;
			tail = (tail+1)%data.length;
			count++;
		}

		public void enqueueHead(T item) {
			if(count == data.length) return;
			int newHead = front-1 < 0 ? data.length-1 : front-1;
			data[newHead] = item;
			front = newHead;
			count++;
		}

		public T dequeueHead() {
			T ans = null;
			if(count>0) {
				ans = data[front];
				front = (front+1)%data.length;
				count--;
			}
			return ans;
		}

		public T dequeueTail() {
			T ans = null;
			if(count>0) {
				ans = data[tail];
				tail = tail-1<0 ? data.length-1 : tail-1;
				count--;
			}
			return ans;
		}
		
		public T head(){
			if(count==0) return null;
			return data[front];
		}

		public T tail(){
			if(count==0) return null;
			return data[tail];
		}
		
		public int size() {
			return count;
		}
		
		public boolean isEmpty() {
			return count==0;
		}
		
		@Override
		public String toString() {
			String ans = "[";
			for (int i = 0; i < count; i++) {
				ans = ans + data[(front+i)%data.length];
				if(i!=count-1) ans = ans + ", ";
			}
			return ans + "]";
		}

		public boolean contains(T item) {
			for (int i = 0; i < count; i++) {
				if(data[(front+i)%data.length].equals(item)) return true;
			}
			return false;
		}
	}
	
	/**
	 * Q2 - Queue with 2 stacks
	 * Complexity: constructor O(1), copy constructor - O(n) , enqueue - O(1) , head,dequeue - O(n)
	 */
	static class QueueWithStacks<T> {
		private Stack<T> s1,s2;

		public QueueWithStacks() {
			s1 = new Stack<T>();
			s2 = new Stack<T>();		
		}

		public QueueWithStacks(QueueWithStacks<T> q) {
			s1 = new Stack<T>();
			s2 = new Stack<T>();
			for (T d : q.s1) {
				s1.push(d);
			}
			for (T d : q.s2) {
				s2.push(d);
			}
		}

		public void enqueue(T item) {
			s1.push(item);
		}

		public T dequeue() {
			if(!s2.isEmpty()) return s2.pop();
			while(!s1.isEmpty())s2.push(s1.pop());
			return s2.isEmpty() ? null : s2.pop();
		}

		public T head(){
			if(!s2.isEmpty()) return s2.pop();
			while(!s1.isEmpty())s2.push(s1.pop());
			return s2.isEmpty() ? null : s2.pop();
		}

		public int size() {
			return s1.size()+s2.size();
		}
		
		public boolean isEmpty() {
			return size()==0;
		}
		
		@Override
		public String toString() {
			Stack<T> t = new Stack<T>();
			while (!s2.isEmpty()) {
				t.push(s2.pop());
			}
			String ans = "[";
			for (T d : t) {
				ans+= d.toString() + ",";
			}
			for (T d : s1) {
				ans+= d.toString() + ",";
			}
			while(!t.isEmpty())s2.push(t.pop());
			return ans.length()>2 ? ans.substring(0, ans.length()-1) + "]" : ans + "]";
		}

		public boolean contains(T item) {
			return s1.contains(item) || s2.contains(item);
		}
	}
	
	/**
	 * Q3 - is Palindrom - queue
	 * Complexity: O(n)
	 */
	public static boolean isPlaindromQueue(ArrayBlockingQueue<Integer> q) {
		int n = q.size();
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n/2; i++) {
			st.push(q.peek());
			q.add(q.poll());
		}
		if(n%2==1)q.add(q.poll());
		for (int i = 0; i < n/2; i++) {
			if(st.pop() != q.peek()) return false;
			q.add(q.poll());
		}
		return true;
	}
	
	/**
	 * Q4 - Replace item in queue
	 * Complexity: O(n)
	 */
	public static void replaceItem(ArrayBlockingQueue<Integer> q,int item,int newPlace) {
		int n = q.size();
		boolean found = false;
		if(q.contains(item)) {
			int i = 1;
			while (i < newPlace) {
				if(q.peek()!=item || found) {
					q.add(q.poll());
					i++;
				}
				else {
					q.poll();
					found=true;
				}
			}
			q.add(item);
			if(!found)n++;
			while (i<n) {
				if(q.peek()!=item || found) {
					q.add(q.poll());
				}
				else {
					q.poll();
					found=true;
				}
				i++;
			}
		}
	}
	
	/**
	 * Q5 - Move items in queue
	 * Complexity: O(k)
	 */
	public static void moveCycle(ArrayBlockingQueue<Integer> q,int k) {
		if(q.isEmpty()) return;
		for (int i = 0; i < k; i++) {
			q.add(q.poll());
		}
	}

	/**
	 * Q6 - Merge 2 queue without duplicates
	 * Complexity: O((m+n)*Max(m,n))
	 */
	public static ArrayBlockingQueue<Integer> mergeQueues(ArrayBlockingQueue<Integer> q1,ArrayBlockingQueue<Integer> q2) {
		int n = q1.size(), m = q2.size();
		ArrayBlockingQueue<Integer> ans = new ArrayBlockingQueue<Integer>(n+m);
		for (int i = 0; i < Math.min(m, n); i++) {
			int x = q1.poll(), y = q2.poll();
			if(x<y) {
				if(!ans.contains(x)) ans.add(x);
				if(!ans.contains(y)) ans.add(y);
			}
			else {
				if(!ans.contains(y)) ans.add(y);
				if(!ans.contains(x)) ans.add(x);				
			}
			q1.add(x);q2.add(y);
		}
		if(m>n) {
			for (int i = n; i < m; i++) {
				int y = q2.poll();
				if(!ans.contains(y)) ans.add(y);
				q2.add(y);
			}
		}
		else {
			for (int i = m; i < n; i++) {
				int x = q1.poll();
				if(!ans.contains(x)) ans.add(x);
				q1.add(x);
			}			
		}
		return ans;
	}
}