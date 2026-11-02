public class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public static Node insert(Node root, int data){
        if (root == null){
            return new Node(data);
        }
        else if (data > root.data){
            root.right = insert(root.right, data);
        }
        else if (data < root.data){
            root.left = insert(root.left, data);
        }
        return root;
    }
    public static Node insertIterative(Node root, int value) {

        Node newNode = new Node(value);

        if (root == null) {
            return newNode;
        }

        Node current = root;
        Node parent = null;

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