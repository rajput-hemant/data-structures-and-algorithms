class LinearSearch
{
public:
    static int linearSearchIterative(int arr[], int size, int num)
    {
        for (int i = 0; i < size; i++)
            if (arr[i] == num)
                return i;
        return -1;
    }

public:
    static int linearSearchRecursive(int arr[], int size, int num)
    {
        return linearSearchRecursive(arr, size, num, 0);
    }

private:
    static int linearSearchRecursive(int arr[], int size, int num, int i)
    {
        if (i == size)
            return -1;
        if (arr[i] == num)
            return i;
        return linearSearchRecursive(arr, size, num, i + 1);
    }
};
