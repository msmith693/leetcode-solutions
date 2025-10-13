class Solution {
  public String gcdOfStrings(String str1, String str2) {
    String divisor = "";
    int i= 0;
    String[] largerArr = {};
    String[] smallerArr = {};
    if(str1.length()>=str2.length()){
      largerArr = str1.split("");
      smallerArr = str2.split("");
    }
    else{
      largerArr = str2.split("");
      smallerArr = str1.split("");
    }

    if(!smallerArr[i].equals(largerArr[i])){
      return "";
    }
    while(i<smallerArr.length && (smallerArr[i].equals(largerArr[i]))){  //didnt have right equals operator at first, was doing boolean operator. ALso didnt have end condition in case i became out of bound
      divisor = divisor + smallerArr[i];
      i++;
    }

    String firstHalf = divisor.substring(0, divisor.length()/2);
    String secondHalf = divisor.substring(divisor.length()/2);
    while(firstHalf.equals(secondHalf)){
      divisor = firstHalf;
      //split up first half again
      firstHalf=firstHalf.substring(0, firstHalf.length()/2);   
      secondHalf = secondHalf.substring(divisor.length()/2);
    }
    return divisor;
  }
}

class Main{
  public static void main(String[] args){
    Solution solution = new Solution();
    System.out.println(solution.gcdOfStrings("LEET", "CODE"));
  }
}