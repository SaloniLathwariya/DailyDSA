public class DiagonalSum {

    public static int diagonalSumPrimary(int[][] nums) {
        int diagonalSum = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[0].length; j++) {
                if(i == j) {
                    diagonalSum += nums[i][j];
                }
            }
        }
        return diagonalSum;
    }

    public static int diagonalSumSecondary(int[][] nums) {
        int diagonalSum = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[0].length; j++) {
                if(i+j == nums.length-1) {
                    diagonalSum += nums[i][j];
                }
            }
        }
        return diagonalSum;
    }

    public static int completeDiagonalSum(int[][] nums) {
        int diagonalSum = 0;
        diagonalSum += diagonalSumPrimary(nums);
        diagonalSum += diagonalSumSecondary(nums);
        // when middle element is common in both diagonals
        int mid = (nums.length-1)/2;
        if(nums.length == nums[0].length) {
            diagonalSum -= nums[mid][mid];
        }
        return diagonalSum;
    }

    public static void main(String[] args) {
        int[][] nums = {
            {12, 2, 3}, 
            {4, 3, 6},
            {7, 8, 9}  
        };
        int ans = diagonalSumPrimary(nums);
        System.out.println("Primary Diagonal sum is: "+ ans);
        int ans2 = diagonalSumSecondary(nums);
        System.out.println("Primary Diagonal sum is: "+ ans2);
        int ans3 = completeDiagonalSum(nums);
        System.out.println("Primary Diagonal sum is: "+ ans3);
    }
}
