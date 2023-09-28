public class Test {
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


        System.out.println(tree.count_leaves());



    }
}
