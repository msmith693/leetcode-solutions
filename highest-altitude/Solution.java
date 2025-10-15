class Solution {
  public int largestAltitude(int[] gain) {
    int[] altitude = new int[gain.length+1]; //has to have original amplitude as well so it is bigger than gain array by 1
    int maxAltitude = 0;
    for(int i=0;i<gain.length;i++){
      int prevGain = gain[i];
      altitude[i+1] = altitude[i]+prevGain;
      prevGain = gain[i];
      if(altitude[i+1]>maxAltitude){
        maxAltitude = altitude[i+1];
      }
    }
    return maxAltitude;
  }
}


class Main {
  public static void main(String[] args){
    Solution solution = new Solution();
    System.out.println(solution.largestAltitude(new int[]{44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81}));
  }
}

// Explanation:

// - Create new altitude array that tracks the current altitude at points by appending the previous gain value to the previous altitude value, therefore calculating the altitude based on its previous amount, and how much it had increased or decreased by.
// - A maxAltitude variable was initialised and updated it the new amplitude after calculation was bigger than the current highest altitude.


// Notes:

// - altitude[] has to have a length that is one bigger than that of the gain array, to account for original 0 altitude.
