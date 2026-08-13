class Solution {
    public String convertToTitle(int columnNumber) {
        if(columnNumber <= 26) {
            if(columnNumber == 0) return "Z" ;
            return  "" + (char)('A' - 1 + columnNumber) ;
        }
        int rem = columnNumber % 26 ;
        if(rem == 0) {
            return convertToTitle((columnNumber / 26) - 1) + "Z" ;
        }
        return convertToTitle(columnNumber / 26) + (char)('A' - 1 + rem) ;
    }
}