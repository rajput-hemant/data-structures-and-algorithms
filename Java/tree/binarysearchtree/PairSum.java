package tree.binarysearchtree;

import java.util.ArrayList;

public class PairSum {
    public boolean isPairSum(Node root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        list = isPairSum(root, list, sum);
        int head = 0, tail = list.size() - 1;
        while (head < tail) {
            if (list.get(head) + list.get(tail) == sum)
                return true;
            if (list.get(head) + list.get(tail) < sum)
                head++;
            else if (list.get(head) + list.get(tail) < sum)
                tail++;
        }
        return false;
    }

    private ArrayList<Integer> isPairSum(Node root, ArrayList<Integer> list, int sum) {
        if (root != null) {
            isPairSum(root.left, list, sum);
            list.add(root.data);
            isPairSum(root.right, list, sum);
        }
        return list;
    }
}
