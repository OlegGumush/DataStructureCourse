package Elizabet_lesson_5;

public class MyQueueGen<T> {
	T [] data;
	int front, tail, count, maxLen;
	public MyQueueGen(int max){
		front = tail = count = 0;
		this.maxLen = max;
		data = (T[])(new Object[maxLen]);
	}
	public boolean push(T val){
		boolean ans = true;
		if (count==data.length){
			ans = false;
		}
		else{
			data[tail] = val;
			tail = (tail + 1)%maxLen;
			count++;
		}
		return ans;
	}
	public T pop(){
		T ans = null;
		if (count == 0){
			ans = null;
		}
		else{
			ans = data[front];
			front = (front + 1)%maxLen;
			count--;
		}
		return ans;
	}
	public int size(){return count;}
	
	public boolean isEmpty(){return count==0;}
	
	public String toString(){
		String ans = "[";
		for (int i=0; i<count; i++){
			ans = ans + data[(front + i)%maxLen] + ", ";
		}
		return ans + "]";
	}
	public boolean contains(T val){
		boolean ans = false;
		for (int i=0; i<count; i++){
			if (data[(front + i)%maxLen].equals(val)){
				ans = true;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		MyQueueGen<Integer> q = new MyQueueGen<Integer>(5);
		System.out.println(q.push(10));
		System.out.println(q.push(20));
		System.out.println(q.push(30));
		System.out.println(q);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q);
		System.out.println(q.push(40));
		System.out.println(q.push(50));
		System.out.println(q.push(60));
		System.out.println(q.push(70));
		System.out.println(q.push(990));
		System.out.println(q);
		while (!q.isEmpty()){
			System.out.println(q.pop());
		}
		
	}

}
