package com.et.toolset.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting{
    /**
     * The selection sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */
    public static int[] selection(int[] args){
        for (int i=0; i<args.length; i++){
            int min=i;
            int tmpMin=args[i];
            for (int j=i+1;j<args.length;j++){
                if (args[j]<args[min]){
                    min=j;
                    tmpMin=args[j];
                }

            }
            args[min]=args[i];
            args[i]=tmpMin;
        }
        return args;
    }

    /**
     * The bubble sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */
    public static int[] bubble(int[] args){
        int temp=0;
        for (int i=0; i<args.length; i++){
            for (int j=0;j<args.length-1-i;j++){
                if(args[j]>args[j+1]){
                    temp=args[j];
                    args[j]=args[j+1];
                    args[j+1]=temp;

                }
            }
        }
        return args;
    }

    /**
     * The insertion sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */
    public static int[] insertion(int []args){
        int data;
        for(int i=1;i<args.length;i++) {
            data = args[i];
            int j;
            for (j = i - 1; j >= 0 && data < args[j]; j--) {
                args[j + 1] = args[j];
            }
            args[j + 1] = data;
        }
        return args;
    }

    /**
     * The quicksort method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */
    public static int[] quicksort(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        return quickSortHelper(args, 0, args.length - 1);
    }

    private static int[] quickSortHelper(int[] args, int left, int right) {
        if (left >= right) {
            return args;
        }
        int pivot = args[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (args[i] < pivot) {
                i++;
            }
            while (args[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = args[i];
                args[i] = args[j];
                args[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSortHelper(args, left, j);
        }
        if (right > i) {
            quickSortHelper(args, i, right);
        }
        return args;
    }

    /**
     * The counting sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */

    public static int[] counting(int[] args) {
        if (args == null || args.length == 0) {
            return args;
        }
        int max = args[0];
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] > max) {
                max = args[i];
            }
            if (args[i] < min) {
                min = args[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < args.length; i++) {
            count[args[i] - min]++;
        }
        int[] res = new int[args.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                res[index++] = i + min;
                count[i]--;
            }
        }
        return res;
    }

    /**
     * The radix sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */
    public static int[] radix(int[] args) {
        int max = Integer.MIN_VALUE;
        for (int num : args) {
            if (num > max) {
                max = num;
            }
        }
        int maxDigits = String.valueOf(max).length();
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int digit = 0; digit < maxDigits; digit++) {
            for (int num : args) {
                int bucketIndex = (num / (int) Math.pow(10, digit)) % 10;
                buckets.get(bucketIndex).add(num);
            }
            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (int num : bucket) {
                    args[index++] = num;
                }
                bucket.clear();
            }
        }

        return args;
    }

    /**
     * The merge sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */
    public static int[] merge(int[] args) {
        if (args.length <= 1) {
            return args;
        }

        int mid = args.length / 2;
        int[] left = new int[mid];
        int[] right = new int[args.length - mid];

        System.arraycopy(args, 0, left, 0, left.length);
        System.arraycopy(args, mid, right, 0, right.length);

        merge(left);
        merge(right);

        mergeArrays(args, left, right);

        return args;
    }

    private static void mergeArrays(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    /**
     * The heapsort method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */
    public static int[] heapsort(int[] args) {
        int n = args.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(args, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = args[0];
            args[0] = args[i];
            args[i] = temp;

            heapify(args, i, 0);
        }

        return args;
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    /**
     * The bucket sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */

    public static int[] bucket(int[] args) {
        int minValue = args[0];
        int maxValue = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < minValue) {
                minValue = args[i];
            } else if (args[i] > maxValue) {
                maxValue = args[i];
            }
        }
        int bucketCount = (maxValue - minValue) / args.length + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < args.length; i++) {
            int bucketIndex = (args[i] - minValue) / args.length;
            buckets.get(bucketIndex).add(args[i]);
        }
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                args[index++] = num;
            }
        }

        return args;
    }

    /**
     * The Shell sorting method
     * @param args (int[])->An array of integers that you wish to sort
     * @return An array of sorted Integer values
     */

    public static int[] shell(int[] args) {
        int n = args.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = args[i];
                int j = i;
                while (j >= gap && args[j - gap] > temp) {
                    args[j] = args[j - gap];
                    j -= gap;
                }

                args[j] = temp;
            }
        }

        return args;
    }

}
