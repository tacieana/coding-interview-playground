package theoryexamples;

public class ArrayBubbleSort {

    public static void main(String[] args) {
        int[] array = {10,5,4,8,23,55,66,2,6,9};

        sort(array);
        for (int j : array) {
            System.out.println(j);
        }
    }

    private static void sort(int[] array) {
        boolean positionChanged = true;

        while (positionChanged) {
            positionChanged = false;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]) {
                    positionChanged = true;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
}
