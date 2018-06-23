package Elizabet_lesson_4;

public class MyStack {//LIFO
	private int[]data;
	private int place;
	private final int INIT_SIZE = 10;
	
	public MyStack(){
		data = new int[INIT_SIZE];
		place = 0;
	}
	public MyStack(int size){
		data = new int[size];
		place = 0;
	}
	public void push(int val){
		if (place<data.length){
			data[place++] = val;
		}
		else{
			System.err.println("error stack is full!!!");
		}
	}
	public int pop(){
		if (place>=0){
			return data[--place];
		}
		else{
			System.err.println("error stack is empty!!!");
		}
		return -1;
	}
	public boolean isEmpty(){
		return place==0;
	}
	public static void main(String[] args) {
		MyStack st = new MyStack(4);
		st.push(4);
		st.push(5);
		st.push(2);
		st.push(22);
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
		System.out.println();
	}

}
