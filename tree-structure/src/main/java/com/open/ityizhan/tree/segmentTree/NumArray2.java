package com.open.ityizhan.tree.segmentTree;

/**
 * LeetCode 303
 */
class NumArray2 {

    // sum[i]存储前i个元素和 sum[0] = 0
    // sum[i]存储 nums[0..i-1]的和
    private int[] sum;

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
