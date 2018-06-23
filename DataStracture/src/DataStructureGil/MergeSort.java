package DataStructureGil;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        marge(arr);
    }

    private static void marge(int[] arr) {
        marge(arr, 0, arr.length - 1);
    }

    private static void marge(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (end + start) / 2;
            marge(arr, start, middle);
            marge(arr, middle + 1, end);
            margeSort(arr, start, middle, end);
        }
    }

    private static void margeSort(int[] arr, int start, int middle, int end) {
        int temp[] = new int[end - start + 1];
        int low = start;
        int high = middle + 1;
        int i = 0;

        while (low <= middle && high <= end) {
            if (arr[low] < arr[high]) {
                temp[i++] = arr[low++];
            } else {
                temp[i++] = arr[high++];
            }
        }
        while (low <= middle) {
            temp[i++] = arr[low++];

        }
        while (high <= end) {
            temp[i++] = arr[high++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[start + j] = temp[j];
        }
    }
}
