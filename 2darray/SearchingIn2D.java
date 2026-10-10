public class SearchingIn2D {

    // Linear search: check every element one by one.
    // Time Complexity: O(rows * cols)
    // Space Complexity: O(1)
    // Best when the matrix is not sorted.
    public static int[] linearSearchIn2D(int[][] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return new int[]{-1, -1};
        }

        for (int row = 0; row < nums.length; row++) {
            for (int col = 0; col < nums[row].length; col++) {
                if (nums[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Binary search on a sorted 2D matrix:
    // Condition: each row is sorted in increasing order,
    // and each column is also sorted in increasing order.
    // Example:
    // [ 1,  2,  3,  4 ]
    // [ 5,  6,  7,  8 ]
    // [ 9, 10, 11, 12 ]
    //
    // Idea:
    // Start from the top-right corner.
    // If current value is equal to target -> found
    // If target is smaller -> move left (col--)
    // If target is larger -> move down (row++)
    //
    // This works because all values to the left are smaller,
    // and all values below are larger.
    //
    // Time Complexity: O(rows + cols)
    // Space Complexity: O(1)
    public static int[] binarySearchIn2D(int[][] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return new int[]{-1, -1};
        }

        int row = 0;
        int col = nums[0].length - 1; // start from top-right corner

        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                return new int[]{row, col};
            } else if (target < nums[row][col]) {
                col--; // go left
            } else {
                row++; // go down
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        int[] ans1 = linearSearchIn2D(matrix, 12);
        System.out.println("Linear Search -> " + ans1[0] + ", " + ans1[1]);

        int[] ans2 = binarySearchIn2D(matrix, 12);
        System.out.println("Binary Search -> " + ans2[0] + ", " + ans2[1]);
    }
}