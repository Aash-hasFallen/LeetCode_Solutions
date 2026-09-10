class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }

    int[] solve(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(node.left);
        int[] right = solve(node.right);

        int sum = node.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        int average = sum / count;

        if (node.val == average) {
            ans++;
        }

        return new int[]{sum, count};
    }
}