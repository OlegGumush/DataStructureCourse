package Trie;

import java.util.Arrays;


public class Trie {

	TrieNode root;

	public Trie(){
		root = new TrieNode("");
	}

	public Trie(String data){
		this();
		String s = "";
		for(int i = 0; i < data.length(); i++) {
			s =  data.charAt(data.length()-i-1) +s;
			add(s);
		}
	}

	public void add(String data){

		//how the word would be add to
		add(root , data );

	}

	private void add(TrieNode tree, String data) {
		if(data.length() == 0 || tree == null) return;

		int idx = data.charAt(0) - 'a';
		TrieNode node = tree.getNode(idx);

		if(node == null){
			tree.addWord(data , true);
		}
		else{
			String curData = node.getData();
			int sameTo = compareIdx(curData , data);
			node.setData( curData.substring(0 , sameTo) );

			String subW1 = curData.substring(sameTo);
			String subW2 = data.substring(sameTo);

			if(!subW1.isEmpty())
				node.moveSons(subW1);
			if(!subW2.isEmpty())
				add(node, subW2);

			//add end
			if(subW1.isEmpty() || subW2.isEmpty()){
				node.setEnd();
			}
			else{
				node.removeEnd();
			}
		}
	}



	public boolean prefix(String data){
		if(data.isEmpty()) return true;
		return contains(root.getNode(data.charAt(0)-'a') , data);
	}

	public boolean contains(String data){
		return contains(root.getNode(data.charAt(0)-'a') , data + '$');
	}
	private boolean contains(TrieNode tree, String data) {
		if(tree == null) return false;
		String s = tree.getData();
		int idx = compareIdx(s , data);
		data = data.substring(idx);
		if(!s.substring(idx).isEmpty() && !data.isEmpty()) return false;
		if(data.isEmpty())
			return true;
		else
			return contains(tree.getNode(data.charAt(0) - 'a'), data);
	}

	public static int compareIdx(String s1, String s2) {
		int len = Math.min(s1.length(), s2.length());
		int i=0;
		for (i = 0; i < len; i++) {
			if(s1.charAt(i) != s2.charAt(i))
				break;
		}
		return i;
	}

	public void printInOrder(){
		printInOrder(root);
	}

	//inorder definded only for binary tree
	private void printInOrder(TrieNode tree) {
		if(tree != null){
			System.out.println(tree.getData());
			for (int i = 0; i < 27; i++) {
				printInOrder(tree.getNode(i));
			}
		}

	}


	public boolean remove(String data){
		if(!contains(data))return false;
		TrieNode current=searchLast(data);
		String curDat=current.getData(),temp;
		TrieNode dad;
		temp=data.substring(0, data.length()-curDat.length());
		if(temp.equals(""))dad=root;
		else dad=searchLast(temp);
		int amount=0,place=0;
		for(int i=0;i<26;i++){//not counting $
			if(current.getNode(i) != null){
				amount++;
				place=i;
			}
		}
		if(amount==0){// only had a $ leaf, and no other word continued on from here.
			dad.removeNode(current.getData().charAt(0)-'a');
			if(dad==root)return true;//don't want to compress into the root by-mistake
			amount=0;
			for(int i=0;i<27;i++)
				if(dad.getNode(i) != null){
					amount++;
					place=i;
				}
			if(amount>1)return true;
			if(amount==1 && dad.getNode(26) != null)return true;
			if(amount==1 && dad.getNode(26) == null){
				TrieNode son=dad.getNode(place);
				dad.removeNode(place);
				for(int i=0;i<27;i++){
					if(son.getNode(i) != null){
						dad.setNode(son.getNode(i), i);
						son.removeNode(i);
					}
				}
				dad.setData(dad.getData()+son.getData());
			}
		}
		else if(amount>1){//had at least 2 more sones other than $ leaf
			current.removeEnd();//delete leaf
			return true;// can't compress
		}
		else{// amount==1 // has 1 child other than $ leaf
			current.removeEnd();//delete leaf
			//compress kid is in array[place].
			TrieNode son=current.getNode(place);
			current.removeNode(place);
			for(int i=0;i<27;i++){
				if(son.getNode(i) != null){
					current.setNode(son.getNode(i), i);
					son.removeNode(i);
				}
			}
			current.setData(current.getData()+son.getData());
		}

		return true;
	}


	private TrieNode searchLast(String data){
		TrieNode ans=null;// if it returns null there was a problem.
		int idx = data.charAt(0)-'a';
		TrieNode current = root.getNode(idx);
		boolean flag=true;
		int i=1,p=1;///////////                              p for data we got
		while(flag){///////////                              i for the current node
			if(p==data.length() && i==current.getData().length()){
				return current;
			}
			if(i<current.getData().length() && current.getData().charAt(i)==data.charAt(p))
			{
				p++;
				i++;
			}
			else
			{
				i=0;
				idx = data.charAt(p)-'a';
				current=current.getNode(idx);
			}
		}
		return ans;
	}

}
