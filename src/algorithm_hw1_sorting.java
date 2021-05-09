import jdk.jfr.Unsigned;

import java.lang.reflect.Array;
import java.util.Arrays;

public class algorithm_hw1_sorting {
    static final int MAX_SIZE = 100;

    public static void main(String[] args) {
        int[] testArray = new int[20];
        RandomArrayGenerator(testArray);

//        InsertionSort(testArray);
//        BinaryInsertionSort(testArray);
//        MergeSort(testArray);
//        QuickSort(testArray, testArray.length, 0, testArray.length - 1, 0);
//        QuickSort(testArray, testArray.length, 0, testArray.length - 1, 1);
//        HeapSort(testArray);
        CountingSort(testArray);

        PrintArray(testArray);


    }

    static void InsertionSort(int[] array) {
        int currentElement, j;

        for (int i = 1; i < array.length; i++) {
            currentElement = array[i];
            for (j = i - 1; j >= 0 && array[j] > currentElement; j--)
                array[j + 1] = array[j];
            array[j + 1] = currentElement;
        }
    }

    static int BinarySearch(int[] array, int low, int high, int element) {
        if (high <= low) {
            if (element > array[low])
                return low + 1;
            else
                return low;
        }
        int mid = (low + high) / 2;

        if (element == array[mid])
            return mid + 1;

        if (element > array[mid])
            return BinarySearch(array, mid + 1, high, element);

        return BinarySearch(array, low, mid - 1, element);
    }

    static void BinaryInsertionSort(int[] array) {
        int j, current, location;
        for (int i = 1; i < array.length; ++i) {
            j = i - 1;
            current = array[i];

            for (location = BinarySearch(array, 0, j, current); j >= location; j--)
                array[j + 1] = array[j];

            array[j + 1] = current;
        }
    }

    static void ArrayCopy(int[] source, int[] dest, int start, int end, int destStart) {
        for (int i = start, j = destStart; i <= end; i++, j++)
            dest[j] = source[i];
    }

    static void Merge(int[] first, int[] second, int[] array) {
        int i = 0, j = 0, k;

        for (k = 0; i < first.length && j < second.length; k++) {
            if (first[i] <= second[j]) {
                array[k] = first[i];
                i++;
            } else {
                array[k] = second[j];
                j++;
            }
        }

        if (i == first.length)
            ArrayCopy(second, array, j, second.length - 1, k);
        else
            ArrayCopy(first, array, i, first.length - 1, k);
    }

    static void MergeSort(int[] array) {
        int firstHalfLength = (int) Math.floor(array.length / 2.0);
        int secondHalfLength = (int) Math.ceil(array.length / 2.0);

        int[] firstHalfArr = new int[firstHalfLength];
        int[] secondHalfArr = new int[secondHalfLength];

        if (array.length > 1) {
            ArrayCopy(array, firstHalfArr, 0, array.length / 2 - 1, 0);
            ArrayCopy(array, secondHalfArr, array.length / 2, array.length - 1, 0);
            MergeSort(firstHalfArr);
            MergeSort(secondHalfArr);
            Merge(firstHalfArr, secondHalfArr, array);
        }
    }

    static void MedianOfThree(int[] array, int first, int last) {
        int mediumIndex = (last - first + 1) / 2;

        int[] allThree = {array[first], array[mediumIndex], array[last]};
        InsertionSort(allThree);

        int temp = array[first];
        array[first] = allThree[1];
        if (allThree[1] == array[last])
            array[last] = temp;
        else if (allThree[1] == array[mediumIndex])
            array[mediumIndex] = temp;
    }

    static void QuickSort(int[] array, int length, int first, int last, int mode) {
        if (mode != 0 && mode != 1) {
            System.out.println("Unavailable quicksort mode!!!");
            System.exit(1);
        }

        if (first < last) {
            if (mode == 1 && length >= 3)
                MedianOfThree(array, first, last);

            int i = first;
            int j = last;

            while (i < j) {
                while (array[i] <= array[first] && i < last)
                    i++;
                while (array[j] > array[first])
                    j--;
                if (i < j)
                    Swap(array, i, j);
            }

            Swap(array, first, j);

            QuickSort(array, j, first, j - 1, mode);
            QuickSort(array, length - j - 1, j + 1, last, mode);
        }
    }

    static void ConstructHeap(int[] array, int length, int index) {
        int max = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length && array[left] > array[max])
            max = left;

        if (right < length && array[right] > array[max])
            max = right;

        if (max != index) {
            Swap(array, index, max);
            ConstructHeap(array, length, max);
        }
    }

    static void HeapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            ConstructHeap(array, array.length, i);

        for (int i = array.length - 1; i > 0; i--) {
            Swap(array, 0, i);
            ConstructHeap(array, i, 0);
        }
    }

    static void CountingSort(int[] array) {
        int max = 0;
        int min = MAX_SIZE;

        for (int k : array) {
            if (k < min)
                min = k;
            if (k > max)
                max = k;
        }

        int[] countArr = new int[max - min + 1];
        int[] outputArr = new int[array.length];

        for (int j : array) countArr[j - min]++;

        for (int i = 1; i < max - min + 1; i++)
            countArr[i] += countArr[i - 1];

        for (int i = array.length - 1; i >= 0; i--) {
            outputArr[countArr[array[i] - min] - 1] = array[i];
            countArr[array[i] - min]--;
        }

        ArrayCopy(outputArr, array, 0, array.length - 1, 0);
    }

    static void Swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%4d\t", array[i]);
            if ((i + 1) % 10 == 0)
                System.out.println();
        }
    }

    static void RandomArrayGenerator(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * MAX_SIZE);
    }


}
