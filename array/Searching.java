public class Searching {

    // Linear Search Algorithm
    public static int linearSearchIterative(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearchRecursive(int[] arr, int target, int index) {
        // base case
        if(index == arr.length) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        }
        return linearSearchRecursive(arr, target, index+1);
    }

    // Binary Search Algorithm
    public static int binarySearchIterative(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int start, int end) {
        // base case
        if(start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if(arr[mid] == target) {
            return mid;
        }
        if(arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid+1, end);
        } else {
            return binarySearchRecursive(arr, target, start, mid-1);
        }
    }

    public static void main(String[] args) {
        // linear search 
        int[] nums = {2, 45, 12, 4, 34, 3};
        System.out.println("Linear Search Recursively Result: "+ linearSearchRecursive(nums, 3, 0));
        System.out.println("Linear Search Iteratively Result: "+ linearSearchIterative(nums, 3));
        
        // binary search - sorted array
        int[] nums2 = {2, 4, 6, 8, 10, 22, 45};
        System.out.println("Binary Search Recursively Result: "+ binarySearchRecursive(nums2, 4, 0, nums2.length-1));
        System.out.println("Binary Search Iteratively Result: "+ binarySearchIterative(nums2, 4));
    }
} 