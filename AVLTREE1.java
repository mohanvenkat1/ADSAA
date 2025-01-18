import java.util.Scanner;

class Node {
    int data, height;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.height = 1;
    }
}

class ConstructAVLTree {
    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        } else {
            return node; // Duplicate keys are not allowed
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && value > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = delete(root.left, value);
        } else if (value > root.data) {
            root.right = delete(root.right, value);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = root.left != null ? root.left : root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        
        if (root == null) {
            return root;
        }

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void search(int key) {
        Node result = search(root, key);
        if (result == null) {
            System.out.println("Key is not found in the Tree");
        } else {
            System.out.println("Key is found");
        }
    }

    private Node search(Node node, int key) {
        if (node == null || node.data == key) {
            return node;
        }
        if (key < node.data) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }
}

public class AVLTREE1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConstructAVLTree avl = new ConstructAVLTree();
        while (true) {
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Search for an element");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int item = sc.nextInt();
                    avl.insert(item);
                    break;
                case 2:
                    System.out.print("Enter element to delete: ");
                    int delItem = sc.nextInt();
                    avl.delete(delItem);
                    break;
                case 3:
                    System.out.print("Enter the key element to search: ");
                    int key = sc.nextInt();
                    avl.search(key);
                    break;
                case 4:
                    System.out.println("Inorder Traversal:");
                    avl.inorderTraversal();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Preorder Traversal:");
                    avl.preorderTraversal();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Postorder Traversal:");
                    avl.postorderTraversal();
                    System.out.println();
                    break;
                case 7:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
