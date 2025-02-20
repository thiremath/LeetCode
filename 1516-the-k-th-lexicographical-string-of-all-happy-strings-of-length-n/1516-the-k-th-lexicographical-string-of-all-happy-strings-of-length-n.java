class Solution {
    public String getHappyString(int n, int k) {

        if(k > 3*Math.pow(2,n-1)){
            return "";
        }

        if(n == 1){

            if(k == 1){
                return "a";
            }
            else if(k == 2){
                return "b";
            }
            else{
                return "c";
            }
        }
        
        return String.valueOf(getHappyStringWorker(n,k,3*(int)Math.pow(2.0,(double)n-1),null));
    }

    public StringBuilder getHappyStringWorker(int n, int k, int ele, StringBuilder lastchar) {

        if(n == 0){
            return new StringBuilder("");
        }

        double temp1;
        int temp;

        StringBuilder curr = new StringBuilder("");

        if(lastchar == null){

            temp1 = (double)(ele / 3.0);
            temp = (int) Math.ceil((double)( (double)k / temp1 ) );

            if(temp == 1){
                curr.append("a");
            }
            else if(temp == 2){
                curr.append("b");
            }
            else{
                curr.append("c");
            }

        }

        else{

            temp1 = (double)(ele / 2.0);
            temp = (int) Math.ceil( (double)k / (double)(ele / 2) );
            String temp2 = String.valueOf(lastchar);

            if(temp2.equals("a")){
                if(temp == 1){
                    curr.append("b");
                }
                else{
                    curr.append("c");
                }
            }

            else if(temp2.equals("b")){
                if(temp == 1){
                    curr.append("a");
                }
                else{
                    curr.append("c");
                }
            }

            else{
                if(temp == 1){
                    curr.append("a");
                }
                else{
                    curr.append("b");
                }
            }   
        }


        return curr.append( getHappyStringWorker(n-1,k%(int)temp1,(int)Math.pow(2.0,(double)n-1),curr) );
    }
    
}



/*

6(n-1)

n=5
k=8

abab|a
abab|c

aba|b
aba|c

n=2

ab
ac

ba
bc

ca
cb

 */