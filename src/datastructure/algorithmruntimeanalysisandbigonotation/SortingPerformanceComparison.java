package datastructure.algorithmruntimeanalysisandbigonotation;

import java.util.Arrays;

public class SortingPerformanceComparison {

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        for (int i = 0; i < n; i++)
            arr1[i] = arr2[i] = arr3[i] = n - i;

        long start = System.nanoTime();
        bubbleSort(arr1);
        long end = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (end - start));

        start = System.nanoTime();
        Arrays.sort(arr2); // Dual-Pivot QuickSort
        end = System.nanoTime();
        System.out.println("Quick Sort Time: " + (end - start));

        start = System.nanoTime();
        Arrays.sort(arr3); // Merge sort internally for objects
        end = System.nanoTime();
        System.out.println("Merge Sort Time: " + (end - start));
    }
}
