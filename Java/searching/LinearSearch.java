package searching;
public class LinearSearch {
    public static int linearSearchIterative(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == num)
                return i;
        return -1;
    }

    public static int linearSearchRecursive(int[] arr, int num) {
        return linearSearchRecursive(arr, num, 0);
    }

    private static int linearSearchRecursive(int[] arr, int num, int i) {
        if (i == arr.length)
            return -1;
        if (arr[i] == num)
            return i;
        return linearSearchRecursive(arr, num, i + 1);
    }
}
