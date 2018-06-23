package Elizabet_lesson_9;


class HashNode {
	String key;
	Integer data;
	HashNode next;

	public HashNode(String k, Integer v, HashNode next){ 
		key = k; 
		data = v; 
		this.next = next; 
	}
	public String toString(){
		return key + ", " + data;
	}
}

public class MyHashTable {
	private HashNode[] nodes;

	public MyHashTable(int size){
		nodes = new HashNode[size];
	}

	private int getIndex(String key){//O(1)
		int index = key.hashCode() % nodes.length;
		if (index < 0)
			index = index + nodes.length;
		return index;
	}

	public Integer insert(String key, Integer data){//O(alpha)
		Integer ans = null;
		Integer index = getIndex(key);//O(1)
		//head=node
		HashNode node=nodes[index];
		boolean found = false;
		for (; !found && node!=null; node=node.next) {
			if (key.equals(node.key)) {
				Integer oldData = node.data;
				node.data = data;
				ans = oldData;
				found = true;
			}
		}
		if (!found){
			node = new HashNode(key, data, nodes[index]);
			nodes[index] = node;
		}
		return ans;
	}


	public Integer remove(String key){//O(alpha)
		int index = getIndex(key);//O(1)
		boolean found = false;
		Integer ans = null;
		HashNode prevNode = null;
		for (HashNode node = nodes[index]; !found && node != null; node = node.next) {
			if (key.equals(node.key)) {
				if (prevNode != null)
					prevNode.next = node.next;
				else
					nodes[index] = node.next;
				ans = node.data;
				found = true;
			}
			prevNode = node;
		}
		return ans;
	}

	public Integer get(String key){//O(alpha)
		HashNode node;
		Integer value = null;
		boolean found = false;
		int index = getIndex(key);
		for (node = nodes[index]; !found && node != null; node = node.next) {
			if (key.equals(node.key)){
				value =  node.data;
				found = true;
			}
		}
		return value;
	}

	public String toString(){//O(n) n-number of elements in the table
		String ans = "[";
		for (int i=0; i<nodes.length; i++){
			if (nodes[i]!=null){
				HashNode node = nodes[i];
				while (node != null){
					ans = ans + node.toString()+"; " ;
					node = node.next;
				}
				ans = ans + "\n";
			}
		}
		return ans + "]\n";
	}
	public static void main(String[] args) {
		MyHashTable ht = new MyHashTable(3);
		ht.insert("a", 1);
		ht.insert("b", 2);
		ht.insert("c", 3);
		ht.insert("d", 4);
		System.out.println(ht);
		ht.insert("a", 9);
		ht.insert("e", 5);
		ht.insert("f", 6);
		System.out.println(ht);
		/*		ht.remove("a");
		System.out.println(ht);
		ht.remove("b");
		ht.remove("x");
		System.out.println(ht);
		ht.remove("c");
		ht.remove("d");
		ht.remove("e");
		ht.remove("f");
		ht.remove("c");
		ht.remove("d");
		ht.remove("e");
		System.out.println(ht);
		ht.remove("f");
		 */	}
}
