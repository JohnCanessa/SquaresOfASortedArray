import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * LeetCode 977 Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray {


    /**
     * Return an array of the squares of each number 
     * sorted in non-decreasing order.
     * 
     * 137 / 137 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 41 MB
     * 
     * Runtime: O(n) - Space: O(n)
     */
    static public int[] sortedSquares(int[] nums) {

        // // **** sanity check(s) ****
        // if (nums.length == 1) {
        //     nums[0] *= nums[0];
        //     return nums;
        // }

        // **** initialization ****
        int[] output    = new int[nums.length];
        int l           = 0;
        int r           = nums.length - 1;

        // **** traverse output array from right to left - O(n) ****
        for (int i = nums.length - 1; i >= 0; i--) {

            // **** select largest value from the left or right side of nums ****
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                output[i] = nums[l] * nums[l];
                l++;
            } else {
                output[i] = nums[r] * nums[r];
                r--;
            }

            // ???? ????
            System.out.println("<<< l: " + l + " r: " + r + " output: " + Arrays.toString(output));
        }
   
        // **** return output ****
        return output;
    }

    
    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read nums int[] ****
        int[] nums = Arrays.stream(br.readLine().trim().split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));

        // **** call function of interest and display output ****
        System.out.println("main <<< output: " + Arrays.toString(sortedSquares(nums)));
    }
}