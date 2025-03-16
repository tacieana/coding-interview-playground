package theoryexamples;

public class ArrayQuickSort {

    public static void main(String[] args) {
        int[] array = {33,66,56,2,4,89,22,6,7,8,31,23,12,15,67,123,44,3,1,0,11,21,52,78,93};
        quickSort(array);

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] array, int lowerIndex, int highIndex) {
        if(lowerIndex >= highIndex) return;

        int left = partition(array, lowerIndex, highIndex);

        swap(array, left, highIndex);
        quickSort(array, lowerIndex, left-1);
        quickSort(array, left+1, highIndex);
    }

    private static int partition(int[] array, int lowerIndex, int highIndex) {
        int pivot = array[highIndex], left = lowerIndex, right = highIndex;

        while(left < right) {
            while(array[left] <= pivot && left < right) {
                left++;
            }
            while(array[right] >= pivot && right > left) {
                right--;
            }
            swap(array, left, right);
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        if (left == right) return;

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
