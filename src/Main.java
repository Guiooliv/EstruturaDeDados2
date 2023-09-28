public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(8);
        tree.insert(10);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(14);
        tree.insert(4);
        tree.insert(7);
        tree.insert(13);

        System.out.println("---Printing in order---");
        tree.inOrder();
        System.out.println("---printing pre order---");
        tree.preOrder();
        System.out.println("---printing post order---");
        tree.postOrder();
        System.out.println("-----------------------");
        System.out.println(tree.search(14).info);
        System.out.println("-----------------------");
        System.out.println("---deleting node with a child---");
        tree.delete(3);
        tree.preOrder();
        System.out.println("---returning the largest number---");
        System.out.println(tree.max());
        System.out.println("---returning the smallest number---");
        System.out.println(tree.min());



    }
}