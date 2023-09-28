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
                    root.left.parent = root;
                } else {
                    insert(root.left, value);
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(value);
                    root.right.parent = root;
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

    public TreeNode minimun(TreeNode root) {
        if (root.left != null) {
            return minimun(root.left);
        }
        return root;
    }


    public void delete(int value) {
        TreeNode node = search(value);
        if (node.left == null & node.right == null) {
            if (node.info <= node.parent.info) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else if (node.left != null && node.right == null) {
            if (node.info <= node.parent.info) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }
        } else if (node.right != null && node.left == null) {
            if (node.info <= node.parent.info) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
        } else {
            TreeNode suss = minimun(node.right);
            delete(suss.info);
            node.info = suss.info;
        }
    }

    public TreeNode simple_rotation(TreeNode node) {
        TreeNode son = node.right;
        node.right = son.left;
        son.left.parent = node;
        son.left = node;
        node.parent = son;
        return son;
    }


    public int max() {
        TreeNode node = root;
        while (node.right != null) {
            if (node.info < node.right.info) {
                node = node.right;
            }
        }
        return node.info;
    }

    public int min() {
        TreeNode node = root;
        while (node.left != null) {
            if (node.info > node.left.info) {
                node = node.left;
            }
        }
        return node.info;
    }

    public int count_leaves(){
        return count_leaves(root);
    }


    public int count_leaves(TreeNode node) {
       if(node == null){
           return 0;
       } else if (node.left == null && node.right == null) {
           return 1;
       }
        int contLeft = count_leaves(node.left);
        int contRight = count_leaves(node.right);
        return contRight+contLeft;
    }

}