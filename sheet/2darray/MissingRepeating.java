public class MissingRepeating {

    // brute force
    public static int[] findMissingAndRepeating(int[][] grid) {
        int n = grid.length;
        int nums[] = new int[n*n+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                nums[grid[i][j]]++;
            }
        }

        int a = 0, b = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 0) {
                a = i;
            }
            if(nums[i] == 2) {
                b = i;
            }
        }
        return new int[]{b, a};
    }

    // optimized: time complexity: O(n^2) & space complexity: O(1)
    public static int[] findMissingAndRepeatingOptimised(int[][] grid) {
        int n = grid.length;
        long N = (long) n * n;

        long expectedSq  = N * (N + 1) * (2 * N + 1) / 6; // sum of squares of the numbers
        long expectedSum = N * (N + 1) / 2; // sum of the numbers

        long actualSum = 0, actualSq = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long v = grid[i][j];
                actualSum += v;
                actualSq  += v * v;
            }
        }
        long diff = actualSum - expectedSum; // a-b
        long sqDiff = actualSq - expectedSq; // a^2-b^2
        // From a^2-b^2 = (a-b)(a+b), we know a-b; dividing sqDiff by diff gives a+b.
        long sum = sqDiff / diff; // a + b
        /* By solving the algebraic equations:
            a-b = diff
            a+b = sum; adding the equations gives 2a = diff+sum, so a = (diff+sum)/2.
        */
        // a = (diff+sum)/2
        int repeating = (int) ((diff + sum) / 2);
        // b = sum - a
        int missing   = (int) (sum - repeating);
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3},{2,2}};
        int[] ans = findMissingAndRepeating(grid);
        System.out.println("Repeating no. is : "+ ans[0]);
        System.out.println("Missing no. is : "+ ans[1]);
        int[] ans2 = findMissingAndRepeatingOptimised(grid);
        System.out.println("Repeating no. is : "+ ans2[0]);
        System.out.println("Missing no. is : "+ ans2[1]);
    }
}