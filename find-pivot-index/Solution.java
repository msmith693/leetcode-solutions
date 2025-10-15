class Solution {
  public int pivotIndex(int[] nums) {
    int[] prefixSumArr = new int[nums.length];
    prefixSumArr[0]=nums[0];  //in problem constraints, nums has to have length of at least 1, so this will always work
    for(int i=1; i<prefixSumArr.length;i++){
      prefixSumArr[i] = prefixSumArr[i-1]+nums[i];  //constructing array where each element is equal to the sum of all the previous elementsin nums
    }

    if((prefixSumArr[prefixSumArr.length-1]-prefixSumArr[0])==0) return 0; //catches case where pivot index is index 0
    for(int j=0;j<prefixSumArr.length-1;j++){
      if((prefixSumArr[prefixSumArr.length-1]-prefixSumArr[j])==prefixSumArr[j+1]){ //comparing current prefix sum with final sum of all elements in nums
        return j+1;
      }
    }
    return -1;
  }
}



class Main {
  public static void main(String[] args){
    Solution solution = new Solution();
    System.out.println(solution.pivotIndex(new int[]{-1,-2, 6, 0, 0, 3 }));  
  }
}



// Feels like a slightly clumsy solution-especially with specific case handling of pivot index being the first index.

// Explanation:

// Noticed that the pivot index is always the index to of the element that is equal to the final cumulative sum of nums[]-nums[pivotIndex-1]. This is the key.

// This solution was reached by playing about with the values in the prefix sum array, as I figured that this 'data structure' was part of the solution. Problem is about running totals, and a prefix sums helps calculate running totals for subarrays.

// Code explanation:

// - Create prefix sum array by iterating through nums[] and adding new value to previous value total.
// - Conditional check to identify if sum of elements to right of FIRST index=0, in which case this is the pivot index.
// - For each element in the prefix sum, if the difference of the elements to the right of it equals the difference of the elements to the left, this is the pivot index.

// By creating a cumulative total array, or a prefix array, you can work out the totals of any subarray to the left or right of a given element by calculating the difference in value from your start point to your end point.

// I think i can improve this to make the code more straightforward conceptually. Look at relationship between nums[] and prefix array. Have diagram in notebook.