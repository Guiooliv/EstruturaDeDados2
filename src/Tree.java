public class Tree {
    public TreeNode root;

    public Tree() {
        this.root = new TreeNode();
    }

    public Tree(int value) {
        this.root = new TreeNode(value);
    }


    public void insert(int value) {
        insert(root, value);
    }


    public void insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            if (value < root.info) {
                if (root.left == null) {
                    root.left = new TreeNode(value);
                } else {
                    insert(root.left, value);
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(value);
                } else {
                    insert(root.right, value);
                }
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void inOrder(TreeNode newRoot) {
        if (newRoot != null) {
            inOrder(newRoot.left);
            System.out.println(newRoot.info);
            inOrder(newRoot.right);
        }
    }


    public void preOrder(TreeNode newRoot) {
        if (newRoot != null) {
            System.out.println(newRoot.info);
            preOrder(newRoot.left);
            preOrder(newRoot.right);
        }
    }

    public void postOrder(TreeNode newRoot) {
        if (newRoot != null) {
            postOrder(newRoot.left);
            postOrder(newRoot.right);
            System.out.println(newRoot.info);
        }
    }

    public TreeNode search(int value) {
        return search(value, root);
    }

    public TreeNode search(int value, TreeNode node) {
        if (value == node.info) {
            return node;
        } else {
            if (value < node.info) {
                return search(value, node.left);
            } else {
                return search(value, node.right);
            }
        }
    }
}