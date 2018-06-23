package Trie;

public class TrieNode {

	private TrieNode[] array;
	private String data;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TrieNode(String data) {
		array = new TrieNode[27];
		this.data = data;
	}
	
	public void addWord(String word, boolean isEnd){
		if(word.length() == 0) return;
		
		int i = word.charAt(0)- 'a';
		array[i] = new TrieNode(word);
		
		if(isEnd)
			array[i].setEnd();
	
	}
	
	public TrieNode getNode(int i){
		if(i == '$' - 'a')
			return array[26];
		return array[i];
	}
	
	
	public void setEnd(){
		if(array[26] == null)
			array[26] = new TrieNode("$");
	}
	public void removeEnd(){
		array[26] = null;
	}
	
	public String toString(){
		return data;
	}

	public void moveSons(String subW1) {
		TrieNode son = new TrieNode(subW1);
		son.array = array;
		array = new TrieNode[27];
		array[subW1.charAt(0) - 'a'] = son;
	}
	
	public void setNode(TrieNode tn , int i){
		array[i] = tn;
	}

	public void removeNode(int i) {
		array[i] = null;
	}

	public int sumOfsuns() {
		int count = 0;
		for(int i=0;i<25;i++){//not counting $
			if(array[i] != null){
				count++;
			}
		}
		return count;
	}

	public void copySons(int sonIdx) {
		array = array[sonIdx].array;
	}
	

}
