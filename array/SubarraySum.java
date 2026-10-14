public class SubarraySum {

    // brute force approach - 0(n^3) time complexity
    public static int maxSubarraySumBruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    sum += arr[k];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }

    // brute force optimised approach - 0(n^2) time complexity
    public static int maxSubarraySumBruteForceOptimised(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // prefix sum approach - 0(n^2) time complexity
    public static int maxSubarraySumPrefixSum(int[] arr) {
        // prefixSum[i] stores the sum of elements from index 0 through i.
        // This method expects a non-empty array.
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        
        int maxSum = Integer.MIN_VALUE;
        // For each subarray [i, j], subtract the prefix before i to get its sum.
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int currSum = i== 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // most optimised approach - kadane's algorithm 0(n) time complexity
    public static int maxSubarraySumKadaneAlgo(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        int ans = maxSubarraySumBruteForce(nums);
        System.out.println("Maximum Subarray sum using brute force approach is: "+ ans);

        int ans2 = maxSubarraySumBruteForceOptimised(nums);
        System.out.println("Maximum Subarray sum using brute force optimised approach is: "+ ans2);

        int ans3 = maxSubarraySumKadaneAlgo(nums);
        System.out.println("Maximum Subarray sum using Kadane's algorithm is: "+ ans3);

        int ans4 = maxSubarraySumPrefixSum(nums);
        System.out.println("Maximum Subarray sum using Kadane's algorithm is: "+ ans4);
    }
}
