
import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                result.append("null,");
                continue;
            }

            result.append(current.val).append(",");

            queue.offer(current.left);
            queue.offer(current.right);
        }

        return result.toString();
    }

    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (!values[index].equals("null")) {
                current.left = new TreeNode(
                    Integer.parseInt(values[index])
                );
                queue.offer(current.left);
            }

            index++;

            if (!values[index].equals("null")) {
                current.right = new TreeNode(
                    Integer.parseInt(values[index])
                );
                queue.offer(current.right);
            }

            index++;
        }

        return root;
    }
}
