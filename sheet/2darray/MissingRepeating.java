public class MissingRepeating {

    // most optimized possible: time complexity: 0(n^2) & space complexity: 0(1)

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

    public static int[] findMissingAndRepeatingOptimised(int[][] grid) {
        long N = (long) n * n;
        int n = grid.length;

        long expectedSq  = N * (N + 1) * (2 * N + 1) / 6;
        long expectedSum = N * (N + 1) / 2;

        long actualSum = 0, actualSq = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long v = grid[i][j];
                actualSum += v;
                actualSq  += v * v;
            }
        }
        long diff = actualSum - expectedSum;     // a - b
        long sqDiff = actualSq - expectedSq;     // a^2 - b^2
        long sum = sqDiff / diff;                // a + b
        int repeating = (int) ((diff + sum) / 2);
        int missing   = (int) (sum - repeating);
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3},{2,2}};
        int[] ans = findMissingAndRepeating(grid);
        System.out.println("Repeating no. is : "+ ans[0]);
        System.out.print("Missing no. is : "+ ans[1]);
        int[] ans2 = findMissingAndRepeatingOptimised(grid);
        System.out.println("Repeating no. is : "+ ans2[0]);
        System.out.print("Missing no. is : "+ ans2[1]);
    }
}