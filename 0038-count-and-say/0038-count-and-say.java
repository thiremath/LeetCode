class Solution {
    public String countAndSay(int n) {

        StringBuilder number = new StringBuilder("1");

        while(n-- != 1){
            // System.out.println(number);
            char[] arr = String.valueOf(number).toCharArray();
            int len = arr.length;
            int index=0;
            number = new StringBuilder("");
            while(index < len){
                char curr = arr[index];
                int count=1;
                while(++index < len && curr == arr[index]){
                    count++;
                }
                number.append(String.valueOf(count)).append(curr);
                // System.out.println(number);
            }
        }

        return String.valueOf(number);
    }
}