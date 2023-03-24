public class BST{
    class Node{
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
            right = null;
            left = null;
        }

    }

    Node root;

    private Node addRecursive (Node current, String value) {
        if (current == null) {
            return new Node(value);
        }
        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(String value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, String value) {
        String[] words = null; 

        if (current == null) {
            return false;
        }

        if (current != null){
            words = current.value.split(",");
        }

        if (value.equalsIgnoreCase(words[0])){
            return true;
        }

        return value.compareTo(current.value) < 0
        ? containsNodeRecursive(current.left, value)
        : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(String value) {
        return containsNodeRecursive(root, value);
    }

    private String getNodeRecursive(Node current, String value) {
        String[] words = null; 

        if (current == null) {
            return "*"+value+"*";
        }

        if (current != null){
            words = current.value.split(",");
        }

        if (value.equalsIgnoreCase(words[0])){
            return current.value;
        }

        return value.compareTo(current.value) < 0
        ? getNodeRecursive(current.left, value)
        : getNodeRecursive(current.right, value);
    }

    public String getNode(String value) {
        return getNodeRecursive(root, value);
    }

    public void deleteKey(String value) {
        root = delete_Recursive(root, value);
    }

    Node delete_Recursive(Node root, String value) {
        
        if (root == null) 
            return root;

        if (value.compareTo(root.value) == -1)
            root.left = delete_Recursive(root.left, value);
        else if (value.compareTo(root.value) == 1)
            root.right = delete_Recursive(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);

            root.right = delete_Recursive(root.right, root.value);
        }
        return root;
    }

    public String minValue (Node root) {
        String minVal = root.value;

        while (root.left != null) {
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    } 

    public void inorder() {
        inorder_Recursive(root);
    }

    public void inorder_Recursive(Node root) {
        if (root != null){
            inorder_Recursive(root.left);
            System.out.println(root.value + " ");
            inorder_Recursive(root.right);
        }
    }
}