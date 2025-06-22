class Solution {
    public String[] divideString(String s, int k, char fill) {

        StringBuilder sb = new StringBuilder(s);

        int size = (int)Math.ceil(s.length()/(double)k);

        int temp = (k*size)-s.length();

        while(temp-- != 0){
            sb.append(fill);
        }

        String[] starr = new String[size];
        int index=0;

        for(int i=0;i<starr.length;i++){
            starr[i] = sb.substring(index,index+k);
            index+=k;
        }

        return starr;
    }
}