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
        
        return String.valueOf(getHappyStringWorker(n,k,0,(double)(3.0*Math.pow(2.0,(double)n-1)),""));
    }

    public StringBuilder getHappyStringWorker(int n, int k, int index, double ele, String lastchar) {

        if(n == 0){
            return new StringBuilder("");
        }

        // System.out.println("ele,n,k = "+ele+" "+n+" "+k);

        double temp1;

        int temp;

        // System.out.println("temp,lastchar, index= "+temp+" "+lastchar+" "+index);

        StringBuilder curr = new StringBuilder("");

        if(index == 0){

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
            temp = (int) Math.ceil((double)( (double)k / temp1 ) );

            if(lastchar.equals("a")){
                if(temp == 1){
                    curr.append("b");
                }
                else{
                    curr.append("c");
                }
            }

            else if(lastchar.equals("b")){
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


        // System.out.println("curr= "+curr);

        return curr.append( getHappyStringWorker(n-1,k%(int)temp1,index+1,Math.pow(2.0,(double)n-1),String.valueOf(curr)) );
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