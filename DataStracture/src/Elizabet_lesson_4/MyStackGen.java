package Elizabet_lesson_4;

public class MyStackGen<T> {
	private T[]data;
	private int place;
	private final int INIT_SIZE = 10;
	
	@SuppressWarnings("unchecked")
	
	
	
	public MyStackGen(){
		data = (T[])new Object[INIT_SIZE];
		place = 0;
	}
	@SuppressWarnings("unchecked")
	public MyStackGen(int size){
		data = (T[])new Object[size];
		place = 0;
	}
	public void push(T val){
		if (place<data.length){
			data[place++] = val;
		}
		else{
			System.err.println("error stack is full!!!\n");
		}
	}
	public T pop(){
		if (place>=0){
			return data[--place];
		}
		else{
			System.err.println("error stack is empty!!!\n");
		}
		return null;
	}
	public boolean isEmpty(){
		return place==0;
	}


	public static void main(String[] args) {
		MyStackGen<Integer> st = new MyStackGen<Integer>(3);
		st.push(4);
		st.push(5);
		st.push(2);
		//תקפוץ הודעה שמחסנית מלאה
		st.push(22);
		while(!st.isEmpty())
		{
			System.out.println(st.pop());
		}
		MyStackGen<String> stString = new MyStackGen<String>(3);
		stString.push("a");
		stString.push("n");
		stString.push("I love Java");
		stString.push("I love Stack");
		while(!stString.isEmpty()){
			System.out.println(stString.pop());
		}
		

	}

}
