package algorithms;

import java.util.*;

public class BinarySearchTree {

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    // =========================
    // 1. INSERT
    // =========================

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {

        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    // =========================
    // 2. SEARCH
    // =========================

    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(Node node, int data) {

        if (node == null) {
            return false;
        }

        if (data == node.data) {
            return true;
        }

        if (data < node.data) {
            return search(node.left, data);
        }

        return search(node.right, data);
    }

    // =========================
    // 3. DELETE
    // =========================

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data) {

        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {

            // Case 1: No child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One child
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            Node successor = findMinNode(node.right);

            node.data = successor.data;

            node.right = delete(node.right, successor.data);
        }

        return node;
    }

    // =========================
    // 4. FIND MINIMUM
    // =========================

    public int findMin() {
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }

        return findMinNode(root).data;
    }

    private Node findMinNode(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // =========================
    // 5. FIND MAXIMUM
    // =========================

    public int findMax() {
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // =========================
    // 6. HEIGHT
    // =========================

    public int height() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // =========================
    // 7. SIZE
    // =========================

    public int size() {
        return size(root);
    }

    private int size(Node node) {

        if (node == null) {
            return 0;
        }

        return 1 + size(node.left) + size(node.right);
    }

    // =========================
    // 8. COUNT LEAVES
    // =========================

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeaves(node.left)
                + countLeaves(node.right);
    }

    // =========================
    // 9. INORDER
    // =========================

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {

        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // =========================
    // 10. PREORDER
    // =========================

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // =========================
    // 11. POSTORDER
    // =========================

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {

        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // =========================
    // 12. LEVEL ORDER
    // =========================

    public void levelOrder() {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        System.out.println();
    }

    // =========================
    // 13. VALIDATE BST
    // =========================

    public boolean isValidBST() {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(
            Node node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isValidBST(node.left, min, node.data)
                && isValidBST(node.right, node.data, max);
    }

    // =========================
    // 14. MAIN
    // =========================

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            bst.insert(value);
        }

        System.out.print("Inorder: ");
        bst.inorder();

        System.out.print("Preorder: ");
        bst.preorder();

        System.out.print("Postorder: ");
        bst.postorder();

        System.out.print("Level Order: ");
        bst.levelOrder();

        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Minimum: " + bst.findMin());
        System.out.println("Maximum: " + bst.findMax());
        System.out.println("Height: " + bst.height());
        System.out.println("Size: " + bst.size());
        System.out.println("Leaves: " + bst.countLeaves());

        System.out.println("Valid BST: " + bst.isValidBST());

        bst.delete(50);

        System.out.print("After deleting 50: ");
        bst.inorder();
    }
}
