public class BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    //TreeNode root;
    /**
     * 创建一个二叉树，创建成功后返回根节点
     */
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    // 前序遍历 根左右
    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历 左根右
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    // 后续遍历 左右根
    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
}
