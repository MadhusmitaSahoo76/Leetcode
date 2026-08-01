class Solution {
    public static  int max_value(int piles[]){
        int max=Integer.MIN_VALUE;
        for (int i=0;i< piles.length;i++){
            max=Math.max(piles[i],max);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int ans = Integer.MIN_VALUE;
            int low = 1;
            int high = max_value(piles);
        while (low <=high){
            int mid = low + (high-low)/2;
             int value = islessthan(piles,mid,h);
             if (value<=h) { ans = mid;high = mid-1;}
             else low = mid + 1;
        }
        return ans;
    }
    public static int  islessthan(int piles[],int mid,int h){
        int count = 0;
        for (int i = 0;i< piles.length; i++){
              count+=Math.ceil((double) piles[i]/mid);
        }
        return count;
    }
}