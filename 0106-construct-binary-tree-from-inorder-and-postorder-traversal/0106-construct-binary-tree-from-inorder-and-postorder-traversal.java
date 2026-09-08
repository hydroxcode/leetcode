class Solution {
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int left, int right, java.util.HashMap<Integer, Integer> map) {
        if (left > right) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);

        root.right = helper(inorder, postorder, index + 1, right, map);
        root.left = helper(inorder, postorder, left, index - 1, map);

        return root;
    }
}