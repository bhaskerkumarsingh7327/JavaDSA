class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int originalColor, int color) {

        int m = image.length;
        int n = image[0].length;

        if (sr < 0 || sc < 0 || sr >= m || sc >= n ||
            image[sr][sc] != originalColor) {
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr - 1, sc, originalColor, color); // Up
        dfs(image, sr + 1, sc, originalColor, color); // Down
        dfs(image, sr, sc - 1, originalColor, color); // Left
        dfs(image, sr, sc + 1, originalColor, color); // Right
    }
}