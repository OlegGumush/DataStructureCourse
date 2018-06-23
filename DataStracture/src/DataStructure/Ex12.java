package DataStructure;

import java.util.LinkedList;

public class Ex12 {
	/**
	 * Q1 - Student Hash table
	 * Complexity: constructor O(1) , copy constructor O(n) , insert,remove,get O(n/size) , hashcode O(1)
	 */
	static class Student {
		private String name;
		private int age;
		
		public Student(String name,int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "[" + name  + "," + age + "]";
		}
	}
	
	static class MyHashTable {
		class HashNode {
			Student data;
			Integer key;
			
			public HashNode(Integer key,Student data) {
				this.data = data;
				this.key = key;
			}
			
			@Override
			public String toString() {
				return ""+key+":"+data;
			}
		}
		
		private LinkedList<HashNode>[] table;
		private int size;
		
		@SuppressWarnings("unchecked")
		public MyHashTable(int size) {
			table = new LinkedList[size];
			this.size = 0;
		}
		
		@SuppressWarnings("unchecked")
		public MyHashTable(MyHashTable ht) {
			table = new LinkedList[ht.table.length];
			for (int i = 0; i < ht.table.length; i++) {
				table[i] = new LinkedList<HashNode>(ht.table[i]);
			}
		}
		
		public Integer insert(Integer key, Student data) {
			if(key == null) return null;
			int index = getIndex(key);
			if(table[index] == null) table[index] = new LinkedList<HashNode>();
			else {
				for (HashNode node : table[index]) {
					if(node.key.equals(key)) {
						node.data = data;
						return key;
					}
				}
			}
			table[index].add(new HashNode(key, data));
			size++;
			return key;
		}
		
		public Student remove(Integer key) {
			if(key == null) return null;
			int index = getIndex(key);
			if(table[index] == null) return null;
			HashNode nToRemove = null;
			Student ans = null;
			for (HashNode node : table[index]) {
				if(node.key.equals(key)) {
					nToRemove = node;
					ans  = node.data;
				}
			}
			if(table[index] != null && nToRemove != null) {
				table[index].remove(nToRemove);
			}
			return ans;
		}
		
		public Student get(Integer key) {
			if(key == null) return null;
			int index = getIndex(key);
			if(table[index] == null) return null;
			for (HashNode node : table[index]) {
				if(node.key.equals(key)) return node.data;
			}
			return null;
		}
		
		public String toString() {
			String ans = "[";
			for(LinkedList<HashNode> list : table) {
				if(list!=null && !list.isEmpty())ans+= list.toString();
			}
			return ans + "]";
		}
		
		private int getIndex(Integer key) {
			return key.hashCode()%table.length;
		}
		
		public int size() {
			return size;
		}
	}
}