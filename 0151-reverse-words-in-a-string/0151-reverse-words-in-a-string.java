class Solution {
    public String reverseWords(String s) {
        String[] splitArr = s.trim().split("\\s+");
        StringBuilder ret = new StringBuilder("");

        for(int i=splitArr.length-1;i>=0;i--){
            // System.out.println(splitArr[i]);
            // if(!splitArr[i].equals("") && !splitArr[i].equals(" ")){
            ret.append(splitArr[i]);
            if(i!=0){
                ret.append(" ");
            }
            // }
        }

        return ret.toString();
    }
}