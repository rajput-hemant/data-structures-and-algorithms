package tree.binarytree;

public class DiameterOfTree {
    int height, diameter;

    DiameterOfTree(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }

    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = TreeBuilder.buildTree(nodes);
        System.out.println("Height Of Tree -> " + diameterOfTree(root));
    }

    // Approach 1
    // Time Complexity -> O(n^2)
    public static int diameterOfTree3(Node root) {
        // base case
        if (root == null)
            return 0;
        // when diameter is going through left subtree (excluding the rootNode)
        int dia1 = diameterOfTree3(root.left);
        // when diameter is going through right subtree (excluding the rootNode)
        int dia2 = diameterOfTree3(root.right);
        // sum of height of left subTree, right subTree & rootNode
        int dia3 = HeightOfTree.heightOfTree(root.left) + HeightOfTree.heightOfTree(root.right) + 1;
        // return the max diameter btw three upper dias to the parentNode
        return Math.max(Math.max(dia1, dia2), dia3);
    }

    // Approach 2
    // Time Complexity -> O(n)
    // this fn will return both height & diameter
    public static DiameterOfTree diameterOfTree2(Node root) {
        if (root == null)
            return new DiameterOfTree(0, 0);
        // recursive call to get height & diameter of left nodes
        DiameterOfTree left = diameterOfTree2(root.left);
        // recursive call to get height & diameter of right nodes
        DiameterOfTree right = diameterOfTree2(root.right);
        // sum of height of rootNode & max of left & right subTree
        int maxHeight = Math.max(left.height, right.height) + 1;
        // when diameter is going through left subtree (excluding the rootNode)
        int dia1 = left.diameter;
        // when diameter is going through right subtree (excluding the rootNode)
        int dia2 = right.diameter;
        // sum of height of left subTree, right subTree & rootNode
        int dia3 = left.height + right.height + 1;
        // the max diameter btw three upper dias to the parentNode
        int maxDia = Math.max(Math.max(dia1, dia2), dia3);
        // object of class DiameterOfTree which returns the maxHeight & maxDiameter
        DiameterOfTree diameter = new DiameterOfTree(maxHeight, maxDia);
        return diameter;
    }

    // Approach 3
    // Time Complexity -> O(n)
    private static int maxDia = 0;

    public static int diameterOfTree(Node root) {
        diameterOfTreeHelper(root);
        return maxDia;
    }

    private static int diameterOfTreeHelper(Node root) {
        if (root == null)
            return 0;
        int leftHeight = diameterOfTreeHelper(root.left);
        int rightHeight = diameterOfTreeHelper(root.right);
        maxDia = Math.max(maxDia, 1 + leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
