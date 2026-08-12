class Solution {
    public int minMutation(String start, String end, String[] bankArr) {
        Set<String> bank=new HashSet<>(Arrays.asList(bankArr));
        if(!bank.contains(end)) return -1;

        Deque<String> q=new ArrayDeque<>();
        Set<String> v=new HashSet<>();
        char[] m={'A','C','G','T'};
        q.add(start);
        v.add(start);
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(end)) return steps;
                char[] arr=curr.toCharArray();
                for(int j=0;j<8;j++){
                    char original=arr[j];
                    for(char c: m){
                        arr[j]=c;
                        String mutation=new String(arr);
                        if(bank.contains(mutation) && !v.contains(mutation)){
                            q.add(mutation);
                            v.add(mutation);
                        }
                    }
                    arr[j]=original;
                }
            }
            steps++;
        }
        return -1;
    }
}