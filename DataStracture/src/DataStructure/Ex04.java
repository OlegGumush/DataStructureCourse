package DataStructure;

import java.util.Arrays;

public class Ex04 {

    /**
     * Q1 - Merge 3 sorted arrays to one array Complexity: O(m+n+k) n,m,k = the
     * length of arrays
     */
    public static int[] mergeThreeArrays(int[] a, int[] b, int[] c) {
        int[] ans = merge(a, b);
        return merge(ans, c);
    }

    private static int[] merge(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int i = 0, j = 0, k = 0;
        int[] ans = new int[n + m];
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                ans[k++] = a[i++];
            } else {
                ans[k++] = b[j++];
            }
        }
        while (i < n) {
            ans[k++] = a[i++];
        }
        while (j < m) {
            ans[k++] = b[j++];
        }
        return ans;
    }

    /**
     * Q2 - check whether there is element that equals to it's index Complexity:
     * O(log n)
     */
    public static boolean equalsToIndex(int[] a) {
        if (a[0] > 0 || a[a.length - 1] < a.length - 1) {
            return false;
        }
        int low = 0, high = a.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == mid) {
                return true;
            }
            if (a[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * Q3 - 2 opposite points in circle Complexity: O(n*log n)
     */
    static class Point {

        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static boolean isOppPoints(Point[] circle) {
        int n = circle.length;
        Point[] temp = new Point[n];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new Point(circle[i].x, circle[i].y);
        }
        sortPoint(temp, 0, temp.length);
        int low = 0, high = temp.length - 1;
        while (low < high) {
            if (temp[low].x == -temp[high].x) {
                if (temp[low].y == -temp[high].y) {
                    return true;
                } else if (temp[low].y < 0) {
                    low++;
                } else {
                    high--;
                }
            } else if (Math.abs(temp[low].x) < Math.abs(temp[high].x)) {
                high--;
            } else {
                low++;
            }
        }

        return false;
    }

    private static void sortPoint(Point[] a, int low, int high) {
        int n = high - low;
        if (n <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        sortPoint(a, low, mid);
        sortPoint(a, mid, high);
        int i = low, j = mid, k = 0;
        Point[] temp = new Point[n];
        while (i < mid && j < high) {
            if (a[i].x < a[j].x) {
                temp[k++] = a[i++];
            } else if (a[i].x > a[j].x) {
                temp[k++] = a[j++];
            } else if (a[i].y < a[j].y) {
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
     * Q4 - Checking whether there are 2 elements in sorted array with sum of a
     * Complexity: O(n)
     */
    public static boolean isElementsWithSumNum(int[] arr, int a) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == a) {
                return true;
            } else if (sum > a) {
                e--;
            } else {
                s++;
            }
        }
        return false;
    }

    /**
     * Q5 - intersection Complexity: O(n*log n)
     */
    public static int[] intersection(int[] a, int[] b) {
        Arrays.sort(a); // java's sort - O(n*log n)
        int size = 0, k = 0;
        for (int i = 0; i < b.length; i++) {
            if (Arrays.binarySearch(a, b[i]) >= 0) {
                size++; // java's search - O(log n) 
            }
        }
        int[] ans = new int[size];
        for (int i = 0; i < b.length; i++) {
            if (Arrays.binarySearch(a, b[i]) >= 0) {
                ans[k++] = b[i];
            }
        }
        return ans;
    }
}
