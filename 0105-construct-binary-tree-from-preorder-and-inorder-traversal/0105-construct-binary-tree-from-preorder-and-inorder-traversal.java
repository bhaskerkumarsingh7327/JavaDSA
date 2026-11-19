
import java.util.*;

class Solution {

    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        int mid = map.get(rootValue);

        root.left = construct(preorder, left, mid - 1);

        root.right = construct(preorder, mid + 1, right);

        return root;
    }
}
