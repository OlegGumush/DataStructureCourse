package DataStructure;

import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        theNthElement(arr, 2);
    }

    /**
     * Q1 - finding the n element in array with size m Complexity: O(n*m)
     */
    public static int theNthElement(int[] a, int n) {
        int[] t = new int[a.length];
        for (int j = 0; j < t.length; j++) {
            t[j] = a[j];
        }
        int maxInd = 0, i = 0;
        for (i = 0; i < n; i++) {
            maxInd = i;
            for (int j = i + 1; j < t.length; j++) {
                if (t[j] > t[maxInd]) {
                    maxInd = j;
                }
            }
            swap(t, maxInd, i);
        }
        return t[i - 1];
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Q2 - Frequency of each word from sorted array Complexity: O(n)
     */
    public static void freqWords(String[] words) {
        int numOfWords = 1;
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1])) {
                numOfWords++;
            }
        }
        int[] freq = new int[numOfWords];
        freq[0]++;
        int wordInd = 0;
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1])) {
                wordInd++;
            }
            freq[wordInd]++;
        }
        System.out.println(Arrays.toString(freq));
    }

    /**
     * Q3 - Radix Sort - Strings Complexity: O(n)
     */
    public static void radixSortString(String[] a) {
        int numOfLetters = 26;
        int longestLength = a[0].length();
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > longestLength) {
                longestLength = a[i].length();
            }
        }
        String[] temp = new String[a.length];
        for (int d = longestLength - 1; d >= 0; d--) {
            int[] count = new int[numOfLetters + 1]; // +1 for the char ' ' - if the word is shorter than d
            for (int i = 0; i < a.length; i++) {
                if (d >= a[i].length()) {
                    count[0]++;
                } else {
                    int getChar = a[i].charAt(d) - 'a' + 1;
                    count[getChar]++;
                }
            }
            for (int i = 1; i < numOfLetters + 1; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (int i = a.length - 1; i >= 0; i--) {
                if (d >= a[i].length()) {
                    temp[--count[0]] = a[i];
                } else {
                    int getChar = a[i].charAt(d) - 'a' + 1;
                    temp[--count[getChar]] = a[i];
                }
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = temp[i];
            }
        }
    }

    /**
     * Q4 - Frequency of each word from unsorted array Complexity: O(n)
     */
    public static void freqWordsNoSorted(String[] words) {
        radixSortString(words);
        freqWords(words);
    }

    /**
     * Q5 - The 2 integers in the array with smallest distance Complexity:
     * O(n+k) - using counting sort
     */
    public static void smallestDist(int[] a) {
        countingSort(a);
        int dist = a[1] - a[0];
        int a1 = a[0];
        int a2 = a[1];
        for (int i = 2; i < a.length; i++) {
            if (a[i] - a[i - 1] < dist) {
                a1 = a[i - 1];
                a2 = a[i];
                dist = a2 - a1;
            }
        }
        System.out.println("a1 = " + a1 + " , a2 = " + a2);
    }

    /**
     * Q6 - The 2 integers in the array with biggest distance Complexity: O(n) -
     * just find the minimum and the maximum
     */
    public static void biggestDist(int[] a) {
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            } else if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("a1 = " + min + " , a2 = " + max);
    }

    /**
     * Q7 - counting sort Complexity: O(n) - just for arrays with integer values
     * with range of k but in this question k = 100
     */
    public static void countingSort(int[] a) {
        int min = a[0];
        int max = a[0];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            } else if (a[i] < min) {
                min = a[i];
            }
        }
        int[] freq = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            freq[a[i] - min]++;
        }
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++) {
                a[k++] = i + min;
            }
        }
    }

    /**
     * Q8 - Checking whether there are 2 elements in sorted array with sum of 0
     * Complexity: O(n)
     */
    public static boolean isElementsWithSumZero(int[] a) {
        int s = 0, e = a.length - 1;
        while (s < e) {
            int sum = a[s] + a[e];
            if (sum == 0) {
                return true;
            } else if (sum > 0) {
                e--;
            } else {
                s++;
            }
        }
        return false;
    }

    /**
     * Q9 - Checking whether there are 2 elements in sorted array with sum of
     * num Complexity: O(n)
     */
    public static boolean isElementsWithSumNum(int[] a, int num) {
        int s = 0, e = a.length - 1;
        while (s < e) {
            int sum = a[s] + a[e];
            if (sum == num) {
                return true;
            } else if (sum > num) {
                e--;
            } else {
                s++;
            }
        }
        return false;
    }
}
