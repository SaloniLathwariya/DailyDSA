public class TrappingRainWater {

    // Two-pointer method: O(n) time and O(1) extra space.
    public static int trappedRainWaterWithPointers(int[] heights) {
        int n = heights.length;
        if (n <= 2) {
            return 0;
        }

        // The ends cannot hold water; track the tallest wall seen from each side.
        int left = 0;
        int right = n - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        int totalTrappedRainWater = 0;

        while (left < right) {
            // The shorter end limits the water level, so process that side first.
            if (heights[left] <= heights[right]) {
                leftMax = Math.max(leftMax, heights[left]);
                // Water above this bar is the left maximum minus its height.
                totalTrappedRainWater += leftMax - heights[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, heights[right]);
                // On the right, use the right maximum in the same way.
                totalTrappedRainWater += rightMax - heights[right];
                right--;
            }
        }
        return totalTrappedRainWater;
    }

    // Prefix/suffix method: store the tallest wall on each side of every bar.
    // This uses O(n) extra space and O(n) time.
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

        // rightMaxHeights[i] = tallest wall from i to the end.
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
        System.out.println("This is the answer: "+trappedRainWaterWithPointers(nums));
        System.out.println("This is the answer: "+trappedRainWater(nums));
    }
}
