public class SearchingIn2D {

    public static int[] linearSearchIn2D(int[][] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[0].length; j++) {
                if(nums[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {{14, 2, 53, 2}, {5, 2, 44, 12}, {92, 7, 65, 2}};
        int[] ans = linearSearchIn2D(matrix, 12);
        System.out.println("Answer is: "+ ans[0] + ", "+ ans[1]);
    }
}