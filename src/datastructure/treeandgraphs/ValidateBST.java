package datastructure.treeandgraphs;

public class ValidateBST {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static boolean isBST(Node root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max)
            return false;

        return isBST(root.left, min, root.val) &&
                isBST(root.right, root.val, max);
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);

        System.out.println("Is BST: " + isBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
