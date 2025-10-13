class Solution {
  public void moveZeroes(int[] nums) {
    int left = 0;
    int right;
    int numZeroes = 0;
    
    for(right = 0; right<nums.length; right++){
      if(nums[right]!=0){
        nums[left]=nums[right];
        left+=1;
      }
      else numZeroes+=1;
    }

    for(int i=1; i<=numZeroes; i++){  //indexing chosen from i = 1 because this loop will only enter if at least 1 zero present
      nums[nums.length-i]=0;  //insert 0 at last available position
    }
  }
}

class Main {
  public static void main(String[] args){
    Solution solution = new Solution();
    int[] nums=new int[]{1,0,0,2,3,0};
    solution.moveZeroes(nums);

    for(int i=0;i<nums.length;i++){
      System.out.println(nums[i]);
    }
  }
}

// Code Explanation:

// - Right pointer traverses array, left pointer keeps track of next insertion point for non-zero vals, zeroCounter counts number of zeroes
// - If the current value at nums[right] is non-zero, insert it into the next available place in nums, overriding previous value there
// - else (right pointing to zero value) increase zeroCounter
// - for each 0 encountered, insert at the end of the non-zero part of the array by inserting from the index of nums.length-zeroCounter (where zeroCounter decreases as zeroes are inserted)

// Could have maybe improved memory allocation score by not creating new loop variable i, and instead using a while loop where numZeroes is decremented manually.
