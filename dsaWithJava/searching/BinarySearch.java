package searching;

public class BinarySearch {
    public static int binarysearchIterative(int[] arr, int num) {
        return binarysearchIterative(arr, num, 0, arr.length - 1);
    }

    private static int binarysearchIterative(int[] arr, int num, int begin, int end) {
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (arr[mid] < num)
                begin = mid + 1;
            else if (arr[mid] > num)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int num) {
        return binarySearchRecursive(arr, num, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int num, int begin, int end) {
        if (begin > end)
            return -1;
        int mid = (begin + end) / 2;
        if (arr[mid] == num)
            return mid;
        if (arr[mid] > num)
            return binarySearchRecursive(arr, num, begin, mid - 1);
        else
            return binarySearchRecursive(arr, num, mid + 1, end);
    }
}