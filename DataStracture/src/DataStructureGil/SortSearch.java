package DataStructureGil;

public class SortSearch {

    /**
     * Q1 - Binary search - recursive Complexity: O(log n)
     */
    public static int binarySearchRec(int[] a, int value) {
        if (value < a[0] || value > a[a.length - 1]) {
            return -1;
        }
        return binarySearchRec(a, 0, a.length - 1, value);
    }

    private static int binarySearchRec(int[] a, int low, int high, int value) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (value == a[mid]) {
                return mid;
            } else if (value < a[mid]) {
                return binarySearchRec(a, low, mid - 1, value);
            } else {
                return binarySearchRec(a, mid + 1, high, value);
            }
        }
        return -1;
    }

    /**
     * Q2 - ternary search Complexity: O(log n)
     */
    public static int trenarySearch(int[] a, int value) {
        if (value < a[0] || value > a[a.length - 1]) {
            return -1;
        }
        return trenarySearch(a, 0, a.length - 1, value);
    }

    private static int trenarySearch(int[] a, int low, int high, int value) {
        int len = high - low;
        if (len >= 0) {
            int mid1 = low + len / 3;
            int mid2 = high - len / 3;
            if (value == a[mid1]) {
                return mid1;
            }
            if (value == a[mid2]) {
                return mid2;
            } else if (value < a[mid1]) {
                return trenarySearch(a, low, mid1 - 1, value);
            } else if (value > a[mid2]) {
                return trenarySearch(a, mid2 + 1, high, value);
            } else {
                return trenarySearch(a, mid1 + 1, mid2 - 1, value);
            }
        }
        return -1;
    }

    /**
     * Q3 - sort up-down array Complexity: O(n)
     */
    public static void sortUpDownArray(int[] a) {
        int[] b = new int[a.length];
        sortUpDownArray(a, b, 0, a.length - 1, 0);
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    private static void sortUpDownArray(int[] a, int[] b, int i, int j, int k) {
        if (i <= j) {
            if (a[i] < a[j]) {
                b[k] = a[i];
                sortUpDownArray(a, b, i + 1, j, k + 1);
            } else {
                b[k] = a[j];
                sortUpDownArray(a, b, i, j - 1, k + 1);
            }
        }
    }

    /**
     * Q4 - Find the index of the lowest element in circular sorted array
     * Complexity: O(log n)
     */
    public static int firstInCircularArray(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (a[mid] > a[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    /**
     * Q5 - Partition recursive Complexity: O(n)
     */
    public static void partitionRec(int[] a, int pivot) {
        partitionRec(a, pivot, 0, a.length - 1);
    }

    private static void partitionRec(int[] a, int pivot, int low, int high) {
        if (low <= high) {
            if (a[low] <= pivot) {
                partitionRec(a, pivot, low + 1, high);
            } else if (a[high] > pivot) {
                partitionRec(a, pivot, low, high - 1);
            } else {
                swap(a, low, high);
                partitionRec(a, pivot, low, high);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Q6 - Average Partition sort Complexity: O(n*log n) , O(n^2) - worst case
     */
    public static void avgSort(int[] a) {
        avgSort(a, 0, a.length - 1);
    }

    private static void avgSort(int[] a, int low, int high) {
        if (low <= high) {
            int avgIndex = avgPartition(a, low, high);
            avgSort(a, low, avgIndex - 1);
            avgSort(a, avgIndex + 1, high);
        }
    }

    private static int avgPartition(int[] a, int low, int high) {
        int avg = avg(a, low, high);
        int pivot = getCloseToAvg(a, low, high, avg);
        swap(a, low++, pivot);
        pivot = low - 1;
        while (low <= high) {
            if (a[low] <= a[pivot]) {
                low++;
            } else if (a[high] > a[pivot]) {
                high--;
            } else {
                swap(a, low, high);
            }
        }
        swap(a, high, pivot);
        return high;
    }

    private static int getCloseToAvg(int[] a, int low, int high, int avg) {
        int ind = low;
        for (int i = low; i <= high; i++) {
            if (a[i] < avg && a[i] > a[ind]) {
                ind = i;
            }
        }
        return ind;
    }

    private static int avg(int[] a, int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += a[i];
        }
        return sum / (high - low + 1);
    }
}
