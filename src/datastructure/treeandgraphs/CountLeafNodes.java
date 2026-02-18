package datastructure.treeandgraphs;

public class CountLeafNodes {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; }
    }

    static int countLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        System.out.println("Leaf nodes = " + countLeaves(root));
    }
}
