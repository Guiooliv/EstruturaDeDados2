public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(15);
        tree.insert(10);
        tree.insert(19);
        tree.insert(8);
        tree.insert(14);
        System.out.println("---Printing in order---");
        tree.inOrder();
        System.out.println("---printing pre order---");
        tree.preOrder();
        System.out.println("---printing post order---");
        tree.postOrder();
        System.out.println("-----------------------");
        System.out.println(tree.search(20).info);


    }
}