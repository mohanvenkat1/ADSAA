
class BTreeNode {
    int[] keys;
    int t; // Minimum degree (defines the range for number of keys)
    BTreeNode[] children;
    int n;
    boolean leaf;

    BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1]; // Maximum keys a node can have
        this.children = new BTreeNode[2 * t]; // Maximum children a node can have
        this.n = 0;
    }

    void insertNonFull(int k) {
        int i = n - 1;

        if (leaf) {
            while (i >= 0 && keys[i] > k) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = k;
            n++;
        } else {
            while (i >= 0 && keys[i] > k) {
                i--;
            }
            i++;
            if (children[i].n == 2 * t - 1) {
                splitChild(i, children[i]);
                if (keys[i] < k) {
                    i++;
                }
            }
            children[i].insertNonFull(k);
        }
    }

    void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.leaf);
        z.n = t - 1;

        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
        }
        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j + t];
            }
        }
        y.n = t - 1;

        for (int j = n; j >= i + 1; j--) {
            children[j + 1] = children[j];
        }
        children[i + 1] = z;

        for (int j = n - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
        }
        keys[i] = y.keys[t - 1];
        n++;
    }
}

class BTree {
    BTreeNode root;
    int t;

    BTree(int t) {
        this.root = null;
        this.t = t;
    }

    void insert(int k) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);
                int i = (s.keys[0] < k) ? 1 : 0;
                s.children[i].insertNonFull(k);
                root = s;
            } else {
                root.insertNonFull(k);
            }
        }
    }

    void traverse() {
        if (root != null) {
            traverse(root);
        }
    }

    void traverse(BTreeNode node) {
        int i;
        for (i = 0; i < node.n; i++) {
            if (!node.leaf) {
                traverse(node.children[i]);
            }
            System.out.print(node.keys[i] + " ");
        }
        if (!node.leaf) {
            traverse(node.children[i]);
        }
    }
}

public class BtreeInsert {
    public static void main(String[] args) {
        BTree tree = new BTree(3); // Minimum degree t = 3
        
        int[] keys = {10, 20, 5, 6, 12, 30, 7, 17};
        for (int key : keys) {
            tree.insert(key);
        }
        
        System.out.println("B-Tree traversal after insertions:");
        tree.traverse();
    }
}
