package main.java.leetcode.january;

public class JanuaryThird {
    public static void main(String[] args) {
        final int[] nums = new int[] {10,4,-8,7};
        final int[] nums1 = new int[] {2,3,1,0};

        final Integer ans = waysToSplitArray(nums);

        System.out.println(ans);
    }

    public static int waysToSplitArray(int[] nums) {
        final Integer n = nums.length;
        int ans = 0;

        long totalSumOfArrayValues = 0;

        for(final int num : nums) {
            totalSumOfArrayValues = totalSumOfArrayValues + num;
        }

        long fromLeftToRightSum = nums[0];

        for(int i=1; i < n-1; i++){
            if(fromLeftToRightSum >= totalSumOfArrayValues - fromLeftToRightSum){
                ans++;
            }

            fromLeftToRightSum = fromLeftToRightSum + nums[i];
        }

        return ans;
    }
}
