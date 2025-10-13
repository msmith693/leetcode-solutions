class Solution {
  public boolean isSubsequence(String s, String t) {
    if (s.equals("")) return true; //edge case, the empty string will always be a substring of t
    String[] sArr = s.split("");  
    String[] tArr = t.split("");
    int sPointer = 0;
    int tPointer;

    for(tPointer=0; tPointer<tArr.length; tPointer++){
      if(sArr[sPointer].equals(tArr[tPointer])){
        if(sPointer==(sArr.length-1)){ //substring found
          return true;
        }
        sPointer+=1; //point to next character in substring
      }
    }
    return false;
  }
}

class Main {
  public static void main(String[] args){
    Solution solution = new Solution();
    String s = "abc";
    String t = "ahbgdc";

    System.out.println(solution.isSubsequence(s, t));
  }
}

// Interesting pointer use, needing a pointer on two different strings.

// Explanation: 
// - Iterate through entire length of string t using tPointer. 
// - If character found that is equal to the character that sPointer is pointing at, increment sPointer by 1.
// - if this occurs for every character in s, at the end character, return true
// - else return false.

// This works because once a letter in substring s has been identified as being in t, the remaining substring has to be after the letter tPointer is at, otherwise it doesn't qualify as a substring.

