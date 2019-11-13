import java.util.Random;

public class SerchMethods {

    public static void main(String[] args) {
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        shuffle(array);
        int result = quickSearch(array, 0, array.length, 37);
        System.out.println(result);
    }

    public static void shuffle(int[] array){
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int index = r.nextInt(array.length -1);
            swap(array, i, index);
        }
    }



    public static int quickSearch(int[] array,
                                   int left,
                                   int right,
                                   int goal){ // 8 _ 3
        if(left == right){
            return array[left];
        }
        int k = partition(array, left, right);
        int index = k - left;
        if(index == goal){
            return array[left + index];
        }
        if(goal < index){
            return quickSearch(array,
                    left, left + index - 1, goal);
        } else {
            return quickSearch(array, left + index + 1, right, goal - index - 1);
        }                              // 6       10      3
    }

    public static int partition(int[] array, int p, int q) {
        Random r = new Random();
        int t = r.nextInt(q - p) + p;
        swap(array, q - 1, t);
        int x = array[q - 1];
        int j = p - 1;
        for (int i = p; i < q - 1; i++) {
            if (array[i] < x) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, j + 1, q - 1);
        return j + 1;
    }

    private static void swap(int[] arr, int i1,
                             int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

}
