class Solution {
    public int minMaxDifference(int num) {
        char[] number = Integer.toString(num).toCharArray();
        String max="",min="";
        char minnum = number[0];
        char maxnum = '-';

        for(int i=0;i<number.length;i++){

            if(minnum == number[i]){
                min+='0';
            }
            else{
                min+=number[i];
            }

            if(maxnum == '-' && number[i] != '9'){
                maxnum = number[i];
            }

            if(number[i] == maxnum){
                max+='9';
            }
            else{
                max+=number[i];
            }
        }

        // System.out.println(max+" "+min);

        return Integer.valueOf(max)-Integer.valueOf(min);
    }
}