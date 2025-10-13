class Solution{
  public boolean canPlaceFlowers(int[] flowerbed, int n){
    if(flowerbed.length>1){
      if(flowerbed[0]==0 && flowerbed[1]==0){  // specific case handling for first entry
        n=n-1;
        flowerbed[0]=1;
      }

      if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0){  // specific case handling for last entry
        n=n-1;
        flowerbed[flowerbed.length-1]=1;
      }

      for(int i=1; i<flowerbed.length-3; i++){
        if(flowerbed[i]==0 && flowerbed[i+1]==0 && flowerbed[i+2]==0){
          flowerbed[i+1] = 1;
          n=n-1;   //found place for flower
        }
      }
      return n<=0;  
    }
    else return (flowerbed[0]==0 && (n==0 || n==1) || flowerbed[0]==1 && n==0);
  }
}

class Main{
  public static void main(String[] args){
  Solution solution = new Solution();
  System.out.println(solution.canPlaceFlowers(new int[] {0,0,1,0,1,0,0}, 1));
}
}
