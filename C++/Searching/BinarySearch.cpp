class BinarySearch
{
public:
    static int binarySearchIterative(int arr[], int size, int num)
    {
        return binarySearchIter(arr, num, 0, size - 1);
    }

private:
    static int binarySearchIter(int arr[], int num, int begin, int end)
    {
        while (begin <= end)
        {
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

public:
    static int binarySearchRecursive(int arr[], int size, int num)
    {
        return binarySearchRecur(arr, num, 0, size - 1);
    }

private:
    static int binarySearchRecur(int arr[], int num, int begin, int end)
    {
        if (begin > end)
            return -1;
        int mid = (begin + end) / 2;
        if (arr[mid] == num)
            return mid;
        if (arr[mid] > num)
            return binarySearchRecur(arr, num, begin, mid - 1);
        else
            return binarySearchRecur(arr, num, mid + 1, end);
    }
};