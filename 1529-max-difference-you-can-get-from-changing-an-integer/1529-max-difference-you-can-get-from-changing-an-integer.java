class Solution {
    public int maxDiff(int num) {
        char[] number = Integer.toString(num).toCharArray();
        String max="",min="";
        char minnum = '-';
        char maxnum = '-';
        boolean flag = (number[0] == '1');

        for(int i=0;i<number.length;i++){

            if(minnum == '-' && number[i] != '1' && number[i] != '0'){
                minnum = number[i];
            }
            if(number[i] == minnum){
                if(flag){
                    min+='0';
                }
                else{
                    min+='1';
                }
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