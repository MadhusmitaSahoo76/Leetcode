class Solution {
    static TreeNode printme(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (root.val == k) {
            return root;
        }
        if (k > root.val) {
            TreeNode l = printme(root.right, k);
            if (l != null) {
                return l;
            }
        } else {
            TreeNode r = printme(root.left, k);
            if (r != null) {
                return r;
            }
        }
        return null;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode target = printme(root, val);
        return target;
    }
}