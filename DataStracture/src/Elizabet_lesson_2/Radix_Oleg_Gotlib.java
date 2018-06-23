package Elizabet_lesson_2;

//ראדיקס סורט כמו שאולג למד עם  גוטליב
public class Radix_Oleg_Gotlib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[]={3,0,3,9,1,2,3,4,5,223,12,32,12,3333};
		RadixSort(arr);
		System.out.print(java.util.Arrays.toString(arr));

	}
	public static void RadixSort(int arr[]){
		
		int max=0;
		for (int i=0;i<arr.length;i++){
			if(arr[i]>max)
				max=arr[i];
		}
		int counter=0;
		while(max>0){
			counter++;
			max=max/10;
		}
		RadixSort( arr,counter);
	}
	public static void RadixSort(int arr[],int sfarot){
		
		int temp[]=new int [arr.length];
		for(int i=0;i<sfarot;i++){
			int p=0;
			for(int j=0;j<10;j++){
				for(int k=0;k<arr.length;k++){
					int digit=digit(arr[k],i);
					if(digit==j)
						temp[p++]=arr[k];
				}
			}
			for (int d=0;d<arr.length;d++)
				arr[d]=temp[d];
		}
	}
	public static int digit(int number,int digit){
		for(int i=0;i<digit;i++)
			number=number/10;
		return number%10;
	}
}





