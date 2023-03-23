public class BinarySearchTree {
    class Node {
        String key;
        Node left, right;

        public Node(String data) {
            key = data;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void deleteKey(String key) {
        root = delete_Recursive(root, key);
    }

    Node delete_Recursive(Node root, String key) {
        
        if (root == null) 
            return root;

        if (key.compareTo(root.key) == -1)
            root.left = delete_Recursive(root.left, key);
        else if (key.compareTo(root.key) == 1)
            root.right = delete_Recursive(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    public String minValue (Node root) {
        String minVal = root.key;

        while (root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    } 

    public void insert(String key){
        root = insert_Recursive(root, key);
    }

    public Node insert_Recursive(Node root, String key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key.compareTo(root.key) < 0)
            root.left = insert_Recursive(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = insert_Recursive(root.right, key);

        return root;
    }

    public void inorder() {
        inorder_Recursive(root);
    }

    public void inorder_Recursive(Node root) {
        if (root != null){
            inorder_Recursive(root.left);
            System.out.println(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    public boolean search (String key) {
        root = search_Recursive(root, key);
        if (root != null)
            return true;
        else 
            return false;
    }

    public Node search_Recursive(Node root, String key) {
        if (root == null || root.key.compareTo(key) == 0)
            return root;

        if (root.key.compareTo(key) == 1)
            return search_Recursive(root.left, key);

        return search_Recursive(root.right, key);
    }
}
