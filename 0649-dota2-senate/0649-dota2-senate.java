class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        int br = 0, bd = 0;
        int r = 0, d = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                if (br > 0) {
                    br--;
                    continue;
                }
                q.offer('R');
                bd++;
                r++;
            } else {
                if (bd > 0) {
                    bd--;
                    continue;
                }
                q.offer('D');
                br++;
                d++;
            }
        }
        while (r > 0 && d > 0) {
            char c = q.poll();
            if (c == 'R') {
                if (br > 0) {
                    br--;
                    r--;
                    continue;
                }
                q.offer('R');
                bd++;
            } else {
                if (bd > 0) {
                    bd--;
                    d--;
                    continue;
                }
                q.offer('D');
                br++;
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
}