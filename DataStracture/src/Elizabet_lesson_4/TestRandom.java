package Elizabet_lesson_4;
import java.util.Random;


public class TestRandom {
	public static void checkMathRamdom(){
		int size = 10;
		for (int i = 0; i < size; i++) {
			System.out.printf("%10.4f\n",Math.random());
		}
		double x = 1./6;
		System.out.printf("x = %10.4f\n",x);
		System.out.printf("x = %10.4f\n",1./3);
	}
	public static void checkRandom(){
		int size = 10, bound = 10;
		Random gen = new Random(111);
		for (int i = 0; i < size; i++) {
			int x = gen.nextInt(bound);
			System.out.print(x+", ");
		}
	}
	public static void main(String[] args) {
		//checkMathRamdom();
		checkRandom();
	}

}
//3, 0, 7, 7, 9, 0, 4, 2, 7, 5,  
