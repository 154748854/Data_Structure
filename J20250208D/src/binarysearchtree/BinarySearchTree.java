package binarysearchtree;

public class BinarySearchTree {
    //静态内部类
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public boolean search(int key) {
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val < key) {
                cur = cur.right;
            }else if(cur.val > key) {
                cur = cur.left;
            }else {
                return true;
            }
        }
        return false;
    }

    public boolean insert(int val) {
        if(root == null) {
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        TreeNode node = new TreeNode(val);
        if(parent.val > val) {
            parent.left = node;
        }else {
            parent.right = node;
        }
        return true;
    }

    public void remove(int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if(cur.val < key) {
                parent = cur;
                cur = cur.right;
            }else if(cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else {
                //开始删除
                removeNode(cur,parent);
            }
        }
    }

    public void removeNode(TreeNode cur, TreeNode parent) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            TreeNode targetParent = cur;
            TreeNode target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = targetParent.left;
            }

            cur.val = target.val;
            //删除target
            if(targetParent.left == target) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }

}
