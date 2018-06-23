package DataStructure;

public class Ex08 {
	/**
	 * Q1 - Sorted Linked List
	 * Complexity: constructor - O(1) , add - O(n) , remove - O(n) , toString - O(n)
	 */
	static class SortedLinkedList {
		class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
				next = null;
			}

			@Override
			public String toString() {
				return ""+data;
			}
		}

		private Node head;
		private int size;

		public SortedLinkedList() {
			head = null;
			size=0;
		}

		public void add(int value) {
			Node newNode = new Node(value);
			Node n = head;
			Node prev = head;

			//�� ��� �� ����� ���� ������ 
			//���� �� � ��� ���� �������
			//����� ����� ���� ������ ����
			while(n!=null && n.data<value) {
				//"����" ���� ���� ��� ���� "�
				prev = n;
				n = n.next;
			}
			//�� ��� �����
			if(head == null) {
				head = newNode;
			}
			//�� "�" ���� ���� �� ���� ������ ������ ��� ���� ��� �����
			//��� ����� ���� ������ ������
			else if(n == head) {
				newNode.next = head;
				head = newNode;
			}
			//�� �� ��� ������� �� ������
			//�� ���� ����� ������ ����� ������
			//����� ��� ����� ������
			else {
				newNode.next = n;
				prev.next = newNode;
			}
			size++;

		}

		public Integer remove(int value) {
			Integer ans = null;
			Node n = head,prev = head;
			
			//� ����� �� �� ����� �����
			//���� ����� ��� ����
			while(n!=null && n.data<value) {
				prev = n;
				n = n.next;
			}
			//�� ��� ����� ����� ���
			if(n==null || n.data!=value) 
				return null;
			//���� ����� �� ����
			//�� ����� ����� �� ����
			else if(n==head) 
			{
				ans = head.data;
				head = head.next;
			}
			//����� ����� ����� ���� ����� ������ ��� ���� ��
			else 
			{
				ans = n.data;
				prev.next = n.next;
			}
			size--;
			return ans;
		}

		@Override
		public String toString() {
			String ans = "[";
			Node n = head;
			while(n!=null) 
			{
				ans = ans + n.data;
				//�� ����� �� ��� �� ����� ����
				if(n.next!=null) 
				{
					ans = ans + ", ";
				}
				n = n.next;
			}
			return ans + "]";
		}

		public int size() {
			return size;
		}
	}

	/**
	 * Q2 - Stack with linked list
	 * Complexity: constructor - O(1) , push - O(1) , pop,top - O(1) , empty - O(1) , toString - O(n)
	 */
	static class StackfromLinkedList<T> {
		@SuppressWarnings("hiding")
		private class Node<T> {
			T data;
			Node<T> next;

			public Node(T data,Node<T> next) {
				this.data = data;
				this.next = next;
			}

			@Override
			public String toString() {
				return data.toString();
			}
		}

		private Node<T> head;
		private int size;

		public StackfromLinkedList() {
			head = null;
			size = 0;
		}
		//������� ������ ������
		public void push(T d) {
			Node n = new Node(d,null);
			n.next=head;
			head = n;
			size++;
		}
		//���� ������ ����� �� ���� �� ������ ���� ��� ����
		//����� ���� ����� ����� ������
		public T pop() {
			if(head == null)
				return null;
			T ans = head.data;
			head = head.next;
			size--;
			return ans;
		}
		//����
		public T top() {
			if(head == null) 
				return null;
			return head.data;
		}

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			return size==0;
		}

		@Override
		public String toString() {
			String ans = "[";
			Node<T> n = head;
			while(n!=null) {
				ans = ans + n.data + ", ";
			}
			return ans; 
		}

	}

	/**
	 * Q3 - Cycle Linked List
	 * Complexity: constructor - O(1) , add - O(1) , remove - O(n) , toString - O(n)
	 */
	static class CycleLinkedList<T> {
		@SuppressWarnings("hiding")
		class Node<T> {
			T data;
			Node<T> next;

			public Node(T data,Node<T> next) {
				this.data = data;
				this.next = next;
			}
		}
		//���� ��� ��� �� ��� ����� �� ���� ��� ����� ����
		private Node<T> head,tail;
		private int size;
		//constructor
		public CycleLinkedList() 
		{
			head = tail = null;
			size=0;
		}

		public void add(T value) 
		{
			Node<T> newNode = new Node<T>(value,null);
			//����� ��� ����� ������ ���� ��� ���� ����� �� ����
			if(head == null) 
			{
				head = tail = newNode;
				tail.next = head;
			}
			//���� ���� ����� ���� 
			//����� �� ���� ����� ����
			//����� ����� �� ����
			else 
			{
				newNode.next = head;
				tail.next = newNode;
				tail = newNode;
			}
			size++;
		}

		public T remove(T value) {
			T ans = null;
			Node<T> n = head;
			Node<T> prev = head;
			int i = 0;
			//���� ������� ������ �� ���� ���� �� ���
			//� ����� �� ���� �� ���� �� ���� ������ �����
			//����� ����� ���� ��� ����
			while(i<size && !n.data.equals(value)) {
				prev = n;
				n = n.next;
				i++;
			}
			//�� ���� ���� ����� �� ���� �� ���� ������ �� �� ������ ��� ����� �� �� �����
			if(i==size) 
				return null;
			//����� ����� �� ����
			else if(n==head) 
			{
				ans = head.data;
				head = head.next;
				tail.next = head;
			}
			//�"����" ����� �� ���� ������ ����� �� ���� ����� ����� ���� ���� ����
			else if(n==tail)
			{
				ans = n.data;
				prev.next = head;
				tail = prev;
			}
			else 
			{
				ans = n.data;
				prev.next = n.next;				
			}
			size--;
			return ans;
		}

		@Override
		public String toString() {
			String ans = "[";
			int i = 0;
			Node<T> n = head;
			while(i<size) {
				ans = ans + n.data;
				if(i<size-1) ans = ans + ", ";
				n = n.next;
				i++;
			}
			return ans + "]";
		}
	}
	//*****************************************
	//����� ����� ����� �� ������� �� ��� ����
	//*****************************************
	static class LinkedList {
		
		static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
				next = null;
			}

			@Override
			public String toString() {
				return ""+this.data;
			}
		}

		private Node head,tail;
		private int size;

		public LinkedList() {
			head = tail = null;
			size = 0;
		}

		public void add(int d) {
			if(head == null) {
				head = new Node(d);
				tail = head;
			}
			else {
				tail.next = new Node(d);
				tail = tail.next;
			}
			size++;
		}

		public Integer remove(int d) {
			Integer ans = null;
			Node n = head,prev = head;
			while(n != null && n.data==d) {
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

		public boolean contains(int d) {
			Node n = head;
			while(n!=null && n.data==d) 
				n = n.next;
			if(n==null)
				return false;
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
		 * Q4 - Sorted Linked List from 2 sorted Lists
		 * Complexity: O(n+m)
		 */
		public static LinkedList symmetricDifferenceLists(LinkedList a,LinkedList b) {
			//���� ����� ����� �� ��� �������
			LinkedList ans = new LinkedList();
			
			//���� 2 ������� ��� ��� �����
			Node n = a.head;
			Node m = b.head;
			
			//���� �� 2 ������� �� ����!!! �� ������ ���� ����� ����� �����
			while(n != null && m != null) {
				//�� ���� ������ � ���� ��� ����� ���� �����
				if(n.data < m.data) {
					ans.add(n.data);
					n = n.next;
				}
				//�� ���� ������ .�. ���� ���� ����� ���� ������� �� .�

				else if(n.data > m.data) {
					ans.add(m.data);
					m = m.next;
				}
				//���� �� ���� ��� ����� ���� �� �����
				else 
				{
					n = n.next;
					m = m.next;
				}
			}
			//���� ����� ���� ������� �� ����� ����� �����
			while(n != null) {
				ans.add(n.data);
				n = n.next;
			}
			while(m != null) {
				ans.add(m.data);
				m = m.next;
			}
			return ans;
		}

		/**
		 * Q5 - size (recursive)
		 * Complexity: O(n)
		 */
		public static int listSize(LinkedList list) {
			if(list == null)
				return 0;
			int ans= listSize(list.head);
			return ans;
		}

		private static int listSize(Node node) {
			if(node == null)
				return 0;
			return 1 + listSize(node.next);
		}

		/**
		 * Q6 - reverse list
		 * Complexity: O(n)
		 */
		public static void reverse(LinkedList list) {
			//�� ������ �� ����� �� �� ����� ��� ��� �� �����
			if(list.head == null || list.head.next == null)
				return;
			
			Node n = list.head;
			Node m;
			while(n!=list.tail) {
				m = n.next;
				n.next = list.tail.next;
				list.tail.next = n;
				n = m;
			}
			list.tail = list.head;
			list.head = n;
		}

		/**
		 * Q7 - reverse list recursive
		 * Complexity: O(n)
		 */
		public static void reverseRecursive(LinkedList list) {
			reverseRecursive(list,list.head);
		}

		private static void reverseRecursive(LinkedList list,Node node) {
			if(node == null) 
				return;
			if(node.next == null) 
				list.head = node;
			else {
				reverseRecursive(list,node.next);
				node.next.next = node;
				node.next = null;
				list.tail = node;
			}
		}

		/**
		 * Q8 - is symmetric list
		 * Complexity: O(n)
		 */
		public static boolean isSymmetricList(LinkedList list) {
			//���� ����� ����
			LinkedList revList = new LinkedList();
			//� ����� �� ������ ������
			Node n = list.head;
			
			//���� �� ��� ������
			while(n!=null) 
			{ // create reverse list
				//���� ��� ���
				Node newNode = new Node(n.data);
				//����� ��� �� �� �� ������ �����
				newNode.next = revList.head;
				//����� �� ������ �� ���� �� ������ ����� ���� ������
				revList.head = newNode; 
				n = n.next;
			}
			//� � �������� �� 2 �������
			n = list.head;
			Node m = revList.head;
			//�� � ����� ����� �� ���� �� ���� ��� ������
			while(n!=null && n.data == m.data) {
				n = n.next;
				m = m.next;
			}
			if(n == null)
				return true;
			return false;
		}

		/**
		 * Q9 - only common items assuming a is sorted
		 * 1) Complexity: O(n*m)
		 * 2) Complexity: O(n*m) - better because we don't search all the list every time.
		 */
		public static LinkedList commonItemsList1(LinkedList a,LinkedList b) {
			LinkedList l = new LinkedList();
			//����� ����� �� ��� �������
			Node n = a.head;
			//���� �� ������ �"���" ������
			while(n != null) 
			{
				//������ ��  � ����� ��� ��� ������� ��� ����� ������� �� ������ �����
				Node m = b.head;
				//�� ��� �� ��� ����� ����
				while(m != null && m.data != n.data)
				{
					m = m.next;
				}
				//�� ���� ������ �� ����� �� �� ����� ���� ������ �� ���� ����� ����� ����
				if(m != null) 
					l.add(n.data);
				//���� �� ������ ��������
				//��� i++
				n = n.next;
			}
			return l;
		}

		public static LinkedList commonItemsList2(LinkedList a,LinkedList b) {
			LinkedList ans = new LinkedList();
			Node m = b.head;
			while(m != null) {
				Node n = a.head;
				while(n != null && n.data < m.data) {
					n = n.next;
				}
				if(n != null && m.data == n.data)
					ans.add(n.data);
				m = m.next;
			}
			return ans;
		}

		/**
		 * Q10 - is circle
		 * isCircle - Complexity: O(n) , circleFirstElement - Complexity: O(n^2) , circleLength - Complexity: O(n)
		 */
		//�������� ��� ������ 
		public static boolean isCircle(LinkedList list)
		{
			if(list == null || list.head == null)
				return false;
			
			Node n = list.head;
			Node m = list.head.next;
			while(n != null && m!= null && m!=n)
			{
				n = n.next;
				
				if(m.next == null)
					m = m.next ;
				else 
					m = m.next.next;
			}
			return n != null && m!= null;
		}

		public static Integer circleFirstElement(LinkedList list) {
			if(list == null || list.head == null) return null;
			Node n = list.head;
			Node m = list.head.next;
			while(n != null && m!= null && m!=n) {
				n = n.next;
				m = m.next == null ? m.next : m.next.next;
			}
			if(n == null || m == null) return null;
			Node p = list.head;
			while(p != n) {
				n = n.next;
				while(n!=p && n!=m) n = n.next;
				if(p != n) p = p.next;
			}
			return p.data;
		}

		public static int circleLength(LinkedList list) {
			if(list == null || list.head == null) return -1;
			Node n = list.head;
			Node m = list.head.next;
			while(n != null && m!= null && m!=n) {
				n = n.next;
				m = m.next == null ? m.next : m.next.next;
			}
			if(n == null || m == null) return -1;
			int count = 1;
			Node start = n;
			while((n = n.next) != start) count++;
			return count;
		}
	}

}