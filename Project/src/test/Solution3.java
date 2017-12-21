package test;
// Binary Search
public class Solution3 {
	int leftBoundary = 0;
    int rightBoundary = 0;
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            for(int k=0; k < n; k++) {
                nums1[k] = nums2[k];
            }
            return;
        }
        rightBoundary = Math.max(0, m-1);
        for(int i=0; i < n; i++) {
            int position = findPosition(leftBoundary, rightBoundary, nums2[i], nums1);
            insertToPosition(position, nums2[i], nums1);
        }
    }
    public void insertToPosition(int pos, int target, int[] nums1) {
        for(int i=rightBoundary+1; i > pos; i--) {
            nums1[i] = nums1[i-1];
        }
        nums1[pos] = target;
        rightBoundary++;
        leftBoundary = pos+1;
    }
    public int findPosition(int left, int right, int target, int[] nums1) {
        if (left >= right) {
            right = Math.max(right, 0);
            return target > nums1[right] ? right + 1 : right;
        }
        int midIndex = (right - left)/2 + left;
        if(target == nums1[midIndex]) {
            return midIndex;
        } else if(target < nums1[midIndex]) {
            return findPosition(left, midIndex-1, target, nums1);
        } else {
            return findPosition(midIndex+1, right, target, nums1);
        }
    }
}
