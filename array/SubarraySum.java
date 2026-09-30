import java.util.*;

public class SubarraySum {

    // brute force approach - 0(n^3) time complexity
    public static int MaxSubarraySumBruteForce(int[] arr) {
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
    public static int MaxSubarraySumBruteForceOptimised(int[] arr) {
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

    // most optimised approach - kadane's algorithm 0(n) time complexity
    public static int MaxSubarraySumKadaneAlgo(int[] arr) {
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
        int ans = MaxSubarraySumBruteForce(nums);
        System.out.println("Maximum Subarray sum using brute force approach is: "+ ans);

        int ans2 = MaxSubarraySumBruteForceOptimised(nums);
        System.out.println("Maximum Subarray sum using brute force optimised approach is: "+ ans2);

        int ans3 = MaxSubarraySumKadaneAlgo(nums);
        System.out.println("Maximum Subarray sum using Kadane's algorithm is: "+ ans3);
    }
}
