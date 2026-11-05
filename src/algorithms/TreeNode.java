package algorithms;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public static TreeNode insert(TreeNode root, int data){
        if (root == null){
            return new TreeNode(data);
        }
        else if (data > root.data){
            root.right = insert(root.right, data);
        }
        else if (data < root.data){
            root.left = insert(root.left, data);
        }
        return root;
    }
    public static TreeNode insertIterative(TreeNode root, int value) {

        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            return newNode;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;

            if (value < current.data) {
                current = current.left;
            } else if (value > current.data) {
                current = current.right;
            } else {
                return root; // Không thêm duplicate
            }
        }

        if (value < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }
}