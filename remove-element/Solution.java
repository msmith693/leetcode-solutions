class Solution {
  public int removeElement(int[] nums, int val) {
    int left = -1;
    int right;
    int k=0; //number of elements not equal to val

    for(right=0; right<nums.length; right++){
      if(nums[right]!=val){
        left+=1;
        k+=1;
        nums[left]=nums[right];
      }
    }
    return k;
  }
}


class Main {
  public static void main(String[] args){
    Solution solution = new Solution();
    int[] nums = new int[]{0,1,0,1,1,0};
    System.out.println(solution.removeElement(nums, 1));
    for(int i=0; i<nums.length; i++){
      System.out.println(nums[i]);
    }
  }
}

// Attempted after remove duplicate elements problem.

// This was tackled in a similar way to the improved solution mentioned in notes. 

// Code explanation:

// - Right pointer traverses the list and the left pointer keeps track of the correct insertion point. 
// - For each element, if it does not equal the val to be omitted, then it is inserted in the next place available in the array.
// - Number of elements not equal to val (k elements) is increased.

// In the case of multiple val digits (that have to be removed), right pointer is incremented until element not equal to val is found, and is inserted into the next available space. 