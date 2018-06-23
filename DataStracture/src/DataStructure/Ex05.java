package DataStructure;

import java.util.Arrays;

public class Ex05 {

    /**
     * Q1 - put even numbers first and then odd numbers Complexity: O(n)
     */
    public static void evenBeforeOdd(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            if (a[low] % 2 == 0) {
                low++;
            } else if (a[high] % 2 == 1) {
                high--;
            } else {
                swap(a, low, high);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Q2 - sort array with only 2 elements Complexity: O(n)
     */
    public static void sortTwoElements(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        int low = 0, high = a.length - 1;
        while (low < high) {
            if (a[low] == min) {
                low++;
            } else if (a[high] != min) {
                high--;
            } else {
                swap(a, low, high);
            }
        }
    }

    /**
     * Q3 - union intervals Complexity: O(n*log n)
     */
    static class Interval {

        double start, end;

        public Interval(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }

    public static double unionIntervals(Interval[] inter) {
        sortIntervals(inter);
        double sum = inter[0].end - inter[0].start;
        double max = inter[0].end;
        for (int i = 1; i < inter.length; i++) {
            if (max < inter[i].start) {
                sum = sum + (inter[i].end - inter[i].start);
                max = inter[i].end;
            } else if (inter[i].end > max) {
                sum = sum + (inter[i].end - max);
                max = inter[i].end;
            }
        }
        return sum;
    }

    private static void sortIntervals(Interval[] a) {
        sortIntervals(a, 0, a.length);
    }

    private static void sortIntervals(Interval[] a, int low, int high) {
        int n = high - low;
        if (n <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        sortIntervals(a, low, mid);
        sortIntervals(a, mid, high);
        int i = low, j = mid, k = 0;
        Interval[] temp = new Interval[n];
        while (i < mid && j < high) {
            if (a[i].start < a[j].start) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i < mid) {
            temp[k++] = a[i++];
        }
        while (j < high) {
            temp[k++] = a[j++];
        }
        for (int l = 0; l < n; l++) {
            a[low + l] = temp[l];
        }
    }

    /**
     * Q4 - find element: a[i] = i+3 from sorted array with different numbers
     * Complexity: O(log n)
     */
    public static boolean isElementP3(int[] a) {
        if (a[0] > 3 || a[a.length - 1] < a.length - 1 + 3) {
            return false;
        }
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] == mid + 3) {
                return true;
            }
            if (a[mid] > mid + 3) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * Q5 - median Complexity: O(n)
     */
    public static int median(int[] a) {
        countSort(a);
        return a[(a.length - 1) / 2];
    }

    private static void countSort(int[] a) {
        int k = 0;
        int[] freq = new int[256];
        for (int i = 0; i < a.length; i++) {
            freq[a[i]]++;
        }
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                a[k++] = i;
            }
        }
    }

    /**
     * Q6 - print all strings once Complexity: O(n*log n)
     */
    public static void dedup(String[] a) {
        Arrays.sort(a);
        System.out.print(a[0] + " ");
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
