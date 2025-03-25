package theoryexamples;

public class ArrayBinarySearch {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Indice 0 para valor 1");
        System.out.println(search(array, 1));

        System.out.println("Indice 1 para valor 2");
        System.out.println(search(array, 2));

        System.out.println("Indice 4 para valor 5");
        System.out.println(search(array, 5));

        System.out.println("Indice 5 para valor 6");
        System.out.println(search(array, 6));

        System.out.println("Indice 8 para valor 9");
        System.out.println(search(array, 9));

        System.out.println("Indice 9 para valor 10");
        System.out.println(search(array, 10));
    }

    private static int search(int[] array, int value) {

        int min = 0;
        int max = array.length-1;
        int middle;

        while (max >= min) {
            middle = ((max-min)/2) + min;

            if (value == array[middle]){
                return middle;
            }

            if (value > array[middle]) {
                min = middle+1;
            } else {
                max = middle-1;
            }
        }

        return -1;
    }
}
