class Solution {
    public String countAndSay(int n) {

        String number = "1";

        while(n-- != 1){
            // System.out.println(number);
            char[] arr = number.toCharArray();
            int len = arr.length;
            int index=0;
            number = "";
            while(index < len){
                char curr = arr[index];
                int count=1;
                while(++index < len && curr == arr[index]){
                    count++;
                }
                number += String.valueOf(count)+curr;
                // System.out.println(number);
            }
        }

        return number;
    }
}