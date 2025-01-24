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

    public int nodeSize;
    // 获取树中节点的个数
    // 递归思路
    int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
        return nodeSize;
    }

    // 子问题思路
    int size2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }

    // 获取叶子节点的个数
    public int leafSize;
    int getLeafNodeCount1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafNodeCount1(root.right);
        getLeafNodeCount1(root.left);

        return leafSize;
    }

    // 子问题思路
    int getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.right == null && root.left == null) {
            return 1;
        }

        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);

    }

    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root,int k) {
        if(root == null) return 0;
        if(k == 1) return 1;
        return getKLevelNodeCount(root.right, k-1)
                + getKLevelNodeCount(root.left, k-1);
        // 这里不能写k-- 是因为k--会改变K值，两个k--就变两次，和我们所需要的不符
    }

    // 获取二叉树的高度
    int getHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        if(find(root.right, val) != null || find(root.left, val) != null) {
            return root;
        }
        return null;
    }

    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        //是不是根节点相同
        if(root == null || subRoot == null) {
            return false;
        }
        if(isSameTree(root, subRoot)) return true;
        //判断是不是子树
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null) return false;
        if(p == null && q == null) return true;
        if(q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;


        return isSymmetricChild(root.left, root.right);
    }
    private boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if(leftTree == null && rightTree != null || leftTree != null && rightTree == null)
            return false;
        if(leftTree == null && rightTree == null) return true;
        if(leftTree.val != rightTree.val) return false;


        return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
    }
}
