package datastructure.treeandgraphs;

public class LowestCommonAncestor {

    static class Node {
        int data;
        Node left, right;
        Node(int d) { data = d; }
    }

    static Node LCA(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q)
            return root;

        Node left = LCA(root.left, p, q);
        Node right = LCA(root.right, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);

        Node ans = LCA(root, 6, 2);
        System.out.println("LCA = " + ans.data);
    }
}
