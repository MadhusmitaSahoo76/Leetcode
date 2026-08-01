class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left=new PriorityQueue<>();
        PriorityQueue<Integer> right=new PriorityQueue<>();
        int n=costs.length;
        int i=0;
        int j=n-1;
        long ans=0;
        for(int x=0;x<candidates && i<=j;x++){
            left.add(costs[i++]);
        }
        for(int x=0;x<candidates && i<=j;x++){
            right.add(costs[j--]);
        }
        while(k-->0){
            int l=(left.size()==0)?Integer.MAX_VALUE:left.peek();
            int r=(right.size()==0)?Integer.MAX_VALUE:right.peek();

            if(l<=r){
                ans=ans+l;
                left.poll();
                if(i<=j){
                    left.add(costs[i++]);
                }
            }else{
                ans+=r;
                right.poll();
                if(i<=j){
                    right.add(costs[j--]);
                }
            }
        }
        return ans;
        
    }
}