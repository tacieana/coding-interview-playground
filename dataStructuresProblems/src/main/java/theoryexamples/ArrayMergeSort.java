package theoryexamples;

public class ArrayMergeSort {

    public static void main(String[] args) {
        int[] array = {33, 66, 56, 2, 4, 89, 22, 6, 7, 8, 31, 23, 12, 15, 67, 123, 44, 3, 1, 0, 11, 21, 52, 78, 93};
        mergeSort(array);

        for (int j : array) {
            System.out.println(j);
        }
    }
    private static void mergeSort(int[] array) {
        if(array == null || array.length < 2) return;

        int size = array.length;
        int middle = size/2;
        int[] left = new int[middle];
        int[] right = new int[size-middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        for (int i = middle; i < size; i++) {
            right[i-middle] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);

    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int leftSize = left.length;
        int rightSize = right.length;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
