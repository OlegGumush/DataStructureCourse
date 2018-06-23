package DataStructureGil;

import java.util.Stack;

public class ExLinkedList {
	static class LinkedList<T> {
		static class Node<E> {
			E data;
			Node<E> next;
			
			public Node(E data) {
				this.data = data;
				next = null;
			}
			
			@Override
			public String toString() {
				return this.data.toString();
			}
		}
		
		private Node<T> head,tail;
		private int size;
		
		public LinkedList() {
			head = tail = null;
			size = 0;
		}
		
		public LinkedList(LinkedList<T> list) {
			if(list != null){
				head = tail = null;
				size = 0;
				Node<T> n = list.head;
				while(n!=null) {
					this.add(n.data);
					n = n.next;
				}
			}
		}
		
		public void add(T d) {
			if(head == null) {
				head = new Node<T>(d);
				tail = head;
			}
			else {
				tail.next = new Node<T>(d);
				tail = tail.next;
			}
			size++;
		}
		
		public T remove(T d) {
			T ans = null;
			Node<T> n = head,prev = head;
			while(n != null && !n.data.equals(d)) {
				prev = n;
				n = n.next;
			}
			if(n==null) return null;
			if(n==head) {
				ans = head.data;
				head = head.next;
			}
			else if(n==tail){
				ans = tail.data;
				prev.next = null;
				tail = prev;
			}
			else {
				ans = n.data;
				prev.next = n.next;
			}
			size--;
			return ans;

		}
		
		public boolean contains(T d) {
			Node<T> n = head;
			while(n!=null && !n.data.equals(d)) n = n.next;
			if(n==null) return false;
			return true;
		}
		
		@Override
		public String toString() {
			String ans = "[";
			Node<T> n = head;
			while(n!=null){
				ans = ans + n.data;
				if(n.next!=null) ans = ans + ", ";
				n = n.next;
			}
			return ans + "]";
		}

		public boolean isEmpty() {
			return size==0;
		}
		
		public int size() {
			return size;
		}
		
		/**
		 * Q1 - Remove All
		 * Complexity: O(n)
		 */
		public void removeAll(T d) {
			while(head != null && head.data.equals(d)) head = head.next;
			Node<T> n = head,p=head;
			while(n != null) {
				if(n.data.equals(d)) p.next = n.next;
				else p = n;
				n = n.next;
			}
		}
		
		/**
		 * Q2 - Sort Linked List - selectionSort
		 * Complexity: O(n^2)
		 */
		
		public static void sort(LinkedList<Integer> list) {
			Node<Integer> minNode;
			Node<Integer> n = list.head;
			for (int i = 0; i < list.size; i++) {
				minNode = getMinNode(n);
				swap(n,minNode);
				n = n.next;
			}
		}
		
		private static void swap(Node<Integer> n,Node<Integer> m) {
			Integer temp = n.data;
			n.data = m.data;
			m.data = temp;
		}

		private static Node<Integer> getMinNode(Node<Integer> n) {
			if(n == null) return null;
			Node<Integer> min = n;
			n = n.next;
			while(n != null) {
				if(n.data < min.data) min = n;
				n = n.next;
			}
			return min;
		}

		/**
		 * Q2 - Extra - Sort Linked List - quickSort
		 * Complexity: O(n*log n) , worst case: O(n^2)
		 */
		public static void quicksort(LinkedList<Integer> list) {
			list.head = quicksort(list.head,list.tail);
		}

		/* sort the list like quickSort in array
		   we get the pivot from the list (see partition) - get temp list
		   and sort recursively the half of the temp list from head to one node before pivot and set the pivot to be the end of the temp list
		   and sort recursively the last half of the list from one after pivot to the end of the temp list. */
		@SuppressWarnings("unchecked")
		private static Node<Integer> quicksort(Node<Integer> start,Node<Integer> end) {
			if(start == null || start == end) return start;
			Node<Integer>[] tempList = new Node[2];
			tempList[0] = null;
			tempList[1] = null; 
			Node<Integer> pivot = partition(start,end,tempList);
			if(tempList[0] != pivot) {
				Node<Integer> n = tempList[0];
				while(n.next != pivot) n = n.next;
				n.next = null;
				tempList[0] = quicksort(tempList[0], n);
				n = tail(tempList[0]);
				n.next = pivot;
			}
			pivot.next = quicksort(pivot.next, tempList[1]);
			return tempList[0];
		}

		private static Node<Integer> tail(Node<Integer> n_start) {
			if(n_start == null) return null;
			Node<Integer> n = n_start;
			while(n.next != null) n = n.next;
			return n;
		}

		/* partition(O(n)) - set pivot to the end of the sublist, pass on the list from start to pivot.
		   we use another list with new head - the first element that smaller than pivot and all the elements that grater
		   than pivot moves after pivot (t). for example:
		   9 -> 7 -> 3 -> 10 -> 1 -> 4 , pivot = 4, the temp list is:
		   3 -> 1 -> 4 -> 9 -> 7 -> 10 and the node 4 will returns. */
		private static Node<Integer> partition(Node<Integer> start, Node<Integer> end,Node<Integer>[] tempList) {
			Node<Integer> pivot = end , n = start , p = null, t = pivot;
			while(n != pivot) {
				if(n.data <pivot.data) {
					if(tempList[0] == null) tempList[0] = n;
					p = n;
					n = n.next;
				}
				else {
					if(p != null) p.next = n.next;
					Node<Integer> temp = n.next;
					n.next = null;
					t.next = n;
					t = n;
					n = temp;
				}
			}
			if(tempList[0] == null) tempList[0] = pivot;
			tempList[1] = t;
			return pivot;
		}
		
		/**
		 * Q3 - Union Lists
		 * Complexity: O(n+m*n)
		 */
		public static LinkedList<Object> unionLists(LinkedList<Object> l1, LinkedList<Object> l2) {
			LinkedList<Object> ans = new LinkedList<Object>();
			for (Node<Object> n = l1.head; n != null; n = n.next) {
				ans.add(n.data);
			}
			for (Node<Object> n = l2.head; n != null; n = n.next) {
				if(ans.contains(n.data))ans.add(n.data);
			}
			return ans;
		}
		
		/**
		 * Q4 - Common tail length
		 * Complexity: O(max(n,m))
		 */
		public static int commonTail(LinkedList<Object> l1, LinkedList<Object> l2) {
			int ans = 0;
			int n = l1.size , m = l2.size;
			Node<Object> node1 = l1.head;
			Node<Object> node2 = l2.head;
			if(n > m) {
				for (int i = 0; i < n - m && node1 != null; i++) {
					node1 = node1.next;
				}
			}
			else {
				for (int i = 0; i < m - n && node2 != null; i++) {
					node2 = node2.next;
				}
			}
			while(node1 != null && node2 != null && node1 != node2) {
				node1 = node1.next;
				node2 = node2.next;
			}
			if(node1 == node2) {
				while(node1 != null) {
					node1 = node1.next;
					ans++;
				}
			}
			return ans;
		}
		
		/**
		 * Q5 - Lists with tail of common elements
		 * Complexity: O(max(n*m,n*k,m*k))
		 */
		public static void threeToOne(LinkedList<Object> l1, LinkedList<Object> l2, LinkedList<Object> l3) {
			Node<Object> tailList_h = null,tailList_t = null;
			Node<Object> node1 = l1.head, p1 = l1.head;
			Node<Object> node2 = l2.head, p2 = l2.head;
			Node<Object> node3 = l3.head, p3 = l3.head;
			while(node1 != null) {
				if(l2.contains(node1.data) && l3.contains(node1.data)) {
					if(tailList_h == null) tailList_h = tailList_t = new Node<Object>(node1.data);
					else {
						tailList_t.next = new Node<Object>(node1.data);
						tailList_t = tailList_t.next;
					}
					if(node1 == l1.head) l1.head = l1.head.next;
					else {
						p1.next = node1.next;
					}
					node1 = node1.next;
				}
				else {
					p1 = node1;
					node1 = node1.next;
				}
			}
			if(p1 != null)p1.next = tailList_h;
			else p1 = tailList_h;
			while(node2 != null) {
				if(l1.contains(node2.data) && l3.contains(node2.data)) {
					if(node2 == l2.head) l2.head = l2.head.next;
					else {
						p2.next = node2.next;
					}
					node2 = node2.next;
				}
				else {
					p2 = node2;
					node2 = node2.next;
				}
			}
			if(p2 != null)p2.next = tailList_h;
			else p2 = tailList_h;
			while(node3 != null) {
				if(l1.contains(node3.data) && l2.contains(node3.data)) {
					if(node3 == l3.head) l3.head = l3.head.next;
					else {
						p3.next = node3.next;
					}
					node3 = node3.next;
				}
				else {
					p3 = node3;
					node3 = node3.next;
				}
			}
			if(p3 != null)p3.next = tailList_h;
			else p3 = tailList_h;
			int l1_s=0,l2_s=0,l3_s=0;
			node1 = l1.head;node2 = l2.head;node3 = l3.head;
			while(node1 != null) {node1 = node1.next; l1_s++;}
			while(node2 != null) {node2 = node2.next; l2_s++;}
			while(node3 != null) {node3 = node3.next; l3_s++;}
			l1.size = l1_s; l2.size = l2_s; l3.size = l3_s;
		}
		
		/**
		 * Q7 - pivot in list
		 * Complexity: O(n)
		 */
		public static LinkedList<Integer> pivotList(LinkedList<Integer> list, Integer element) {
			LinkedList<Integer> ans = new LinkedList<Integer>();
			ans.add(element);
			int count = 1;
			Node<Integer> n = ans.head;
			Node<Integer> m = list.head;
			while(m!= null) {
				if(m.data < element) {
					Node<Integer> newN = new Node<Integer>(m.data);
					newN.next = ans.head;
					ans.head = newN;
					count++;
				}			
				else if(m.data > element){
					Node<Integer> newN = new Node<Integer>(m.data);
					newN.next = n.next;
					n.next = newN;
					count++;
				}
				m = m.next;
			}
			ans.size = count;
			return ans;
		}
		
		/**
		 * Q9 - Node Swap
		 * Complexity: O(max(n,m))
		 */
		public static void nodeSwap(LinkedList<Object> list,int n,int m) {
			if(m>=list.size || n>=list.size) return;
			Node<Object> n1 = list.head, p1 = null, next1 = null;
			for(int i = 0; i < n; i++){
				p1 = n1;
				n1 = n1.next;
			}
			next1 = n1.next;
			Node<Object> n2 = list.head , p2 = null, next2 = null;
			for(int i = 0; i < m; i++){
				p2 = n2;
				n2 = n2.next;
			}
			next2 = n2.next;
			if(p1 != null && p1 != n2) p1.next = n2; 
			if(next1 != n2) n2.next = next1;
			else n2.next = n1;
			if(p2 != null && p2 != n1) p2.next = n1; 
			if(next2 != n1) n1.next = next2;
			else n1.next = n2;
			if(list.head == n1) list.head = n2;
			else if(list.head == n2) list.head = n1;
		}
	}
	
	/**
	 * Q6 - Sorted Double Cycle Linked List
	 * Complexity: constructor, size: O(1) , copy constructor, add, remove, contains, toString: O(n)
	 */
	static class SortedDoubleCycleLinkedList {
		class Node {
			Object data;
			Node next,prev;

			public Node(Object data,Node prev,Node next) {
				this.data = data;
				this.next = next;
				this.prev = prev;
			}
			
			@Override
			public String toString() {
				return ""+data;
			}
		}

		private Node head;
		private int size;

		public SortedDoubleCycleLinkedList() {
			head = null;
			size = 0;
		}

		public SortedDoubleCycleLinkedList(SortedDoubleCycleLinkedList list) {
			if(list != null){
				head = null;
				size = 0;
				Node n = list.head;
				while(n!=null) {
					this.add(n.data);
					n = n.next;
				}
			}
		}

		private int compare(Object a, Object b) {
			if((Integer)a > (Integer)b) return 1;
			else if((Integer)a < (Integer)b) return -1;
			return 0;
		}
		
		public void add(Object d) {
			if(head == null) {
				head = new Node(d,head,head);
				head.prev = head.next = head;
			}
			else {
				Node n = head;
				while(n!= head.prev && compare(d,n.data) > 0) n = n.next;
				if(n == head.prev) {
					if(compare(d,head.prev.data) > 0) {
						head.prev.next = new Node(d,head.prev,head);
						head.prev = head.prev.next;
					}
					else {
						head.prev.prev.next = new Node(d,head.prev.prev,head.prev);
						head.prev.prev = head.prev.prev.next;
					}
				}
				else {
					if(n == head) {
						head = new Node(d,head.prev,head);
						head.prev.next = head;
						head.next.prev = head;
					}
					else {
						n.prev.next = new Node(d,n.prev,n);
						n.prev = n.prev.next;
					}
				}
			}
			size++;
		}

		public Object remove(Object d) {
			if(head == null) return null;
			Object ans = null;
			Node n = head;
			while(n!=head.prev && compare(d,n.data) > 0) n = n.next;
			if(n==head.prev) {
				if(compare(d,n.data) != 0)return null;
				ans = n.data;
				size--;
				if(n == head) head = null;
				else {
					n.prev.next = n.next;
					n.next.prev = n.prev;
				}
				return ans;
			}
			else if(compare(d,n.data) == 0){
				ans = n.data;
				size--;
				if(n==head) {
					head.prev.next = head.next;
					head.next.prev = head.prev;
					head = head.next;
				}
				else {
					n.prev.next = n.next;
					n.next.prev = n.prev;
				}
				return ans;
			}
			return null;
		}

		public boolean contains(Object d) {
			Node n = head;
			while(n!=head.prev && compare(d,n.data) > 0) n = n.next;
			if(n==head.prev) return n.data == head.prev.data;
			return true;
		}

		@Override
		public String toString() {
			String ans = "[";
			Node n = head;
			while(n!=head.prev){
				ans = ans + n.data + ", ";
				n = n.next;
			}
			ans = ans + n.data;
			return ans + "]";
		}

		public boolean isEmpty() {
			return size==0;
		}
		
		public int size() {
			return size;
		}
	}
	
	/**
	 * Q8 - Queue with LinkedList
	 * Complexity: constructor, size, enqueue, dequeue: O(1) , copy constructor, contains, toString: O(n)
	 */
	static class QueueWithLinkedList {
		class Node {
			Object data;
			Node next;
			
			public Node(Object data,Node next) {
				this.data = data;
				this.next = next;
			}
			
			@Override
			public String toString() {
				return this.data + "";
			}
		}

		private Node head,tail;
		private int count;
		
		public QueueWithLinkedList() {
			head = tail = null;
			count = 0;
		}
		
		public QueueWithLinkedList(QueueWithLinkedList q) {
			Node n = q.head;
			while(n != null) {
				enqueue(n.data);
				n = n.next;
			}
		}
		
		public void enqueue(Object item) {
			if(head == null) head = tail = new Node(item,null);
			else {
				tail.next = new Node(item,null);
				tail = tail.next;
			}
			count++;
		}
	
		public Object dequeue() {
			if(head == null) return null;
			Object ans = head.data;
			head = head.next;
			return ans;
		}
		
		public Object head(){
			if(head == null) return null;
			return head.data;
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
			Node n = head;
			while(n != null) {
				if(n.next != null) ans = ans + n.data + ", ";
				else ans = ans + n.data;
				n = n.next;
			}
			return ans + "]";
		}

		public boolean contains(Object item) {
			Node n = head;
			while(n != null) {
				if(n.data.equals(item)) return true;
			}
			return false;
		}
	}
	
	/**
	 * Q10 - LinkedList of stacks (double)
	 * Complexity: constructor, size: O(1) , copy constructor, add, remove, contains, toString: O(n)
	 */
	static class LinkedListOfStacks {
		class Node {
			Stack<Double> data;
			Node next;
			
			public Node(Stack<Double> data) {
				this.data = data;
				next = null;
			}
			
			public Node(Stack<Double> data,Node next) {
				this.data = data;
				this.next = next;
			}
			
			@Override
			public String toString() {
				return this.data + "";
			}
		}
		
		private Node head;
		private int size;
		
		public LinkedListOfStacks() {
			head = null;
			size = 0;
		}
		
		public LinkedListOfStacks(LinkedListOfStacks list) {
			if(list != null && list.head != null){
				Node n = list.head;
				Stack<Double> t = new Stack<Double>();
				for(Double d : list.head.data) {
					t.push(d);
				}
				head = new Node(t);
				Node m = head;
				n = n.next;
				while(n!=null) {
					t = new Stack<Double>();
					for(Double d : n.data) {
						t.push(d);
					}
					m.next = new Node(t);
					m = m.next;
					n = n.next;
				}
				size = list.size;
			}
		}
		
		public void add(double d) {
			if(head == null) {
				head = new Node(new Stack<Double>());
				head.data.push(d);
			}
			else {
				int fval = (int) d;
				Node n = head, p = null;
				while(n != null && n.data.peek().intValue() < fval) {
					p = n;
					n = n.next;
				}
				if(n == head) {
					if(n.data.peek().intValue() == fval) {
						n.data.push(d);
					}
					else {
						head = new Node(new Stack<Double>(),head);
						head.data.push(d);
					}
				}
				else if(n == null) {
					p.next = new Node(new Stack<Double>());
					p.next.data.push(d);
				}
				else {
					if(n.data.peek().intValue() == fval) {
						n.data.push(d);
					}
					else {
						p.next = new Node(new Stack<Double>(),n);
						p.next.data.push(d);
					}
				}
			}
			size++;
		}
		
		public Double remove(int d) {
			Double ans = null;
			Node n = head,prev = head;
			while(n != null && n.data.peek().intValue() < d) {
				prev = n;
				n = n.next;
			}
			if(n==null || n.data.peek().intValue() > d) return null;
			ans = n.data.pop();
			if(n==head) {
				if(n.data.isEmpty())head = head.next;
			}
			else {
				if(n.data.isEmpty())prev.next = n.next;
			}
			size--;
			return ans;

		}
		
		public boolean contains(double d) {
			Node n = head;
			while(n!=null && n.data.peek().intValue() < (int) d) n = n.next;
			if(n==null || n.data.peek().intValue() > (int) d) return false;
			return n.data.contains(d);
		}
		
		@Override
		public String toString() {
			String ans = "[";
			Node n = head;
			while(n!=null){
				ans = ans + n.data;
				if(n.next!=null) ans = ans + ", ";
				n = n.next;
			}
			return ans + "]";
		}
		
		public boolean isEmpty() {
			return size==0;
		}

		public int size() {
			return size;
		}
		
	}

	static class DoubleLinkedList {
		class Node {
			Object data;
			Node next,prev;

			public Node(Object data) {
				this.data = data;
				next = prev = null;
			}
		}

		private Node head,tail;
		private int size;

		public DoubleLinkedList() {
			head = tail = null;
			size = 0;
		}

		public DoubleLinkedList(DoubleLinkedList list) {
			if(list != null){
				head = tail = null;
				size = 0;
				Node n = list.head;
				while(n!=null) {
					this.add(n.data);
					n = n.next;
				}
			}
		}

		public void add(Object d) {
			if(head == null) {
				head = new Node(d);
				tail = head;
			}
			else {
				Node n = new Node(d);
				n.prev = tail;
				tail.next = n;
				tail = n;
			}
			size++;
		}

		public Object remove(Object d) {
			Object ans = null;
			Node n = head;
			while(n != null && !n.data.equals(d)) n = n.next;
			if(n==null) return null;
			if(n==head) {
				ans = head.data;
				head.prev = null;
				head = head.next;
			}
			else if(n==tail){
				ans = tail.data;
				n.prev.next = null;
				tail = n.prev;
			}
			else {
				ans = n.data;
				n.prev.next = n.next;
				n.next.prev = n.prev;
			}
			size--;
			return ans;

		}

		public boolean contains(String d) {
			Node n = head;
			while(n!=null && !n.data.equals(d)) n = n.next;
			if(n==null) return false;
			return true;
		}

		@Override
		public String toString() {
			String ans = "[";
			Node n = head;
			while(n!=null){
				ans = ans + n.data;
				if(n.next!=null) ans = ans + ", ";
				n = n.next;
			}
			return ans + "]";
		}

		public boolean isEmpty() {
			return size==0;
		}
		
		public int size() {
			return size;
		}
		
		/**
		 * Q11 - Move elements k steps
		 * Complexity: O(k)
		 */
		public static void moveK(DoubleLinkedList list,int k) {
			k = k % list.size;
			if(k > 0) {
				Node n = list.tail;
				for (int i = 0; i < k-1; i++) {
					n = n.prev;
				}
				n.prev.next = null;
				n.prev = null;
				list.tail.next = list.head;
				list.head.prev = list.tail;
				list.head = n;
			}
			else if(k < 0){
				k = -k;
				Node n = list.head;
				for (int i = 0; i < k; i++) {
					n = n.next;
				}
				n.prev.next = null;
				n.prev = null;
				list.tail.next = list.head;
				list.head.prev = list.tail;
				list.head = n;
			}
			
		}
	}
}