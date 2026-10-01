public class TrappingRainWater {

    public static int trappedRainWater(int[] heights) {
        int n = heights.length;
        if (n <= 2) {
            return 0; // Ends cannot trap water.
        }

        // leftMax[i] = tallest wall from start to i.
        int[] leftMaxHeights = new int[n];
        leftMaxHeights[0] = heights[0];
        for(int i=1; i<n; i++) {
            leftMaxHeights[i] = Math.max(heights[i], leftMaxHeights[i-1]);
        }

        // find the right highest bar 
        int rightMaxHeights[] = new int[n];
        rightMaxHeights[n-1] = heights[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMaxHeights[i] = Math.max(heights[i], rightMaxHeights[i+1]);
        }

        int totalTrappedRainWater = 0;

        // Water above current bar = lower boundary - current height.
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMaxHeights[i], rightMaxHeights[i]);
            totalTrappedRainWater += Math.max(0, waterLevel - heights[i]);
        }
        return totalTrappedRainWater;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("This is the answer: "+trappedRainWater(nums));
    }
}
