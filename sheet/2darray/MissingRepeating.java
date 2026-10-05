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

    public static void main(String[] args) {
        int[][] grid = {{1,3},{2,2}};
        int[] ans = findMissingAndRepeating(grid);
        System.out.println("Repeating no. is : "+ ans[0]);
        System.out.print("Missing no. is : "+ ans[1]);
    }
}