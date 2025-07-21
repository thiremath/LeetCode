class Solution {
    public String makeFancyString(String sb) {
        StringBuilder s = new StringBuilder(String.valueOf(sb.charAt(0)));

        if(sb.length() == 1){
            return sb;
        }
        System.out.println(s);
        for(int i=1;i<sb.length()-1;i++){
            if(!(sb.charAt(i) == sb.charAt(i-1) && sb.charAt(i) == sb.charAt(i+1))){
                s.append(sb.charAt(i));
            }
        }

        // System.out.println(s);

        s.append(sb.charAt(sb.length()-1));
        return String.valueOf(s);
    }
}