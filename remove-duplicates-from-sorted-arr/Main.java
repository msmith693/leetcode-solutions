class Solution {
  public int removeDuplicates(int[] nums) {
    int right = 1;  //initial pointer values
    int left = 0;
    
    int[] temp = new int[nums.length];  //had to look up syntax, intialising a new array of length=nums length
    int k=nums.length; //number of unique elements
    int nextAvailableIndex = 0; //nextAvailableIndex empty space in temp
    int lastAvailableIndex = nums.length-1; //index to insert into if duplicate found

    while(left<nums.length){
      if(right==(nums.length)){
        temp[nextAvailableIndex]=nums[left];
        left+=1;
      }
      else if(nums[left]==nums[right]){
        while(right<nums.length && nums[left]==nums[right]){
          temp[lastAvailableIndex] = nums[left]; //filling in temp array from end with duplicates
          k-=1;
          lastAvailableIndex-=1;
          right+=1;
        }
        temp[nextAvailableIndex] = nums[left];
        nextAvailableIndex+=1;
        right+=1; //advance pointers, skipping duplicate
        left=right-1;
      }
      else{
        temp[nextAvailableIndex] = nums[left];
        right+=1;  //advance pointers
        left+=1;
        nextAvailableIndex+=1; 
      }
    }
    for(int i=0; i<nums.length; i++){
      nums[i] = temp[i];  //copy temp values to nums
    }
    return k;
  }
}



public class Main{
  public static void main(String[] args){
    Solution solution = new Solution();
   System.out.println(solution.removeDuplicates(new int[]{1,1}));

  }
}

// Code explanation:

// - Created a temp array temp[] with length = nums.length
// - Initialised a unique number counter k = nums.length
// - Tracked the next available index to insert a unique element in and last available index to insert a duplicate
// - if nums[R]==nums[L] then while this is true, copy duplicates into last available index of temp array. Increase R, decrease k and last available index.
// - if numbers at pointers L and R are different, insert left pointer value into next available index in temp[], increasing next available index value
// - have check conditions for when R gets out of bounds
// - copy temp values back into nums with for loop

// Comparison with solutions

// While my solution changes nums to be a sorted unique value array with all duplicates at the end, this was not necessary as the conditions for the problem state that you need to return number of k unique items, and have had to modify the list so the first k items are unique. The end values don't matter, they do not need to be the duplicate values like in my solution.

// - One solution had a simple loop that iterated through the list with the right pointer, and if nums[L]!=nums[R] then it would increase L by 1, and set the new value at pointer L to the value of pointer R. This is trivial for cases where L and R are next to each other, as the same value ends up being set to the same value, but if there are duplicates, R increases until there is a unique number and then the value to the right of the last unique number is set to the next unique number. 

// - This solution does not insert duplicates at the end of the array.