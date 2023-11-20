package Arvore;

public class TreeNode {
    public int info;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;


    public TreeNode(){
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeNode(int value){
        this.info = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}