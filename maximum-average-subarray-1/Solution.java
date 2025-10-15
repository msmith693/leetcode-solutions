class Solution {
  public double findMaxAverage(int[] nums, int k){
    // Calculate total of initial window
    int windowTotal=0;
    for(int i=0; i<k; i++){
      windowTotal+=nums[i];
    }
    double maxWindowTotal = windowTotal;  //needs to be double so we can calculate accurate average

    for(int j=k; j<nums.length; j++){  //j=k targets all elements after end of previous window
      windowTotal=windowTotal-nums[j-k]+nums[j]; /*where nums[j-k] is the initial value of the last window 
                                                  subarray and nums[j] is the next value in the new window*/
      if(windowTotal>maxWindowTotal){
        maxWindowTotal=windowTotal;
      }
    }

    return maxWindowTotal/k;  //calculating average
  }
}


class Main {
  public static void main(String[] args){
    Solution solution = new Solution();
    System.out.println(solution.findMaxAverage(new int[]{}, 0));
  }
}

// Things I noted:

// - The average only needs to be calculated at the end, not on each individual window. You can just compare the window total and compare these instead. This improves memory.
// - Instead of calculating each wiindow total from scratch, the 1st element in the previous window is subtracted from the window total and the new element in the window is added to the window total. This decreases the number of addition calculations done when calculating the new window total from O(k) to O(1).

// Code Explanation:

// - Calculate initial windowTotal by iterating through first k elements of nums[]
// - for the next element after the previous window, calculate the new windowTotal by taking the previous windowTotal, subtracting initial element of previous window and adding the new element.
// - Check if new window total is larger than the max calculated so far, if true then reassign maxWindowTotal
// -return average of maxWindowTotal

