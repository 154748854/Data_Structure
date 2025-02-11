public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();

        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.print("=========================");
        System.out.println();
        binaryTree.inOrderNor(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();

        System.out.println(binaryTree.size(root));
        System.out.println(binaryTree.size2(root));
        System.out.println(binaryTree.getLeafNodeCount(root));
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        System.out.println(binaryTree.getHeight(root));

        System.out.println(binaryTree.find(root, 'd'));
    }
}
