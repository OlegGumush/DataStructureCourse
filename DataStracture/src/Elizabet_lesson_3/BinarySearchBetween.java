package Elizabet_lesson_3;

public class BinarySearchBetween {

    public static void main(String[] args) {
        int a[] = {1, 6, 7, 9, 10};

        System.out.println();
        // Binary search Between
        MyLibrary.printIntegerArray(a);
        int val = 11;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        val = 2;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        val = 19;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        val = 18;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        val = 20;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        val = 15;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        val = 1;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        val = 5;
        System.out.println("binarySearchBetween: value = " + val + ", index = " + binarySearchBetween(a, val));
        System.out.println();
        System.out.println();

    }

    public static int binarySearchBetween(int[] arr, int value) {
        /**
         * if value<arr[0] the function returns zero
         * if value>arr[end] the function returns end+1 if arr[index-1] < value
         * < arr[index] the function returns index,
         */
        int low = 0;
        int end = arr.length - 1;
        int high = end;
        //�� ����� ��� ����� ����� �0 ����� 0 �� �� ���� ���� ��� ���� ����� ��
        if (value < arr[0]) {
            return 0;
        }
        //�� ���� ����� ��� ���� 1 �� ��� ��� ���� ����� ��
        if (value > arr[end]) {
            return end + 1;
        }
        while (low <= high) {
            int middle = (low + high) / 2;
            //�� �� ����� ����� ���� �� ���� ��� 
            //���� �� ������� ����� ��� �� ��� ��� ���� ����� ��
            //������ �����
            if (low == high) {
                return low;
            } else {
                if (arr[middle] == value) {//value was found
                    return middle;
                }
                if (value < arr[middle]) {// value suppose to be left
                    high = middle;
                } else {// value suppose to be right
                    low = middle + 1;
                }
            }
        }
        return -1;
    }
    // binary search in decreasing array
}
