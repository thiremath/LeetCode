class Solution {
    public int maxDistance(String s, int k) {
        int curr_x=0,curr_y=0,currans=0;
        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            // System.out.println("x+y "+x+" "+y);

            // curr_x = x;
            // curr_y = y;

            if(c == 'N'){
                curr_y++;
            }
            else if(c == 'S'){
                curr_y--;
            }
            else if(c == 'E'){
                curr_x++;
            }
            else{
                curr_x--;
            }

            // System.out.println("curr_x+curr_y "+curr_x+" "+curr_y);

            // int b = Math.abs(x)+Math.abs(y);

            // if(a < b && k > 0){
            //     ans++;
            //     k--;
            //     continue;
            // }

            // x = curr_x;
            // y = curr_y;
            currans = Math.max(currans,Math.min(Math.abs(curr_x)+Math.abs(curr_y)+k*2,i+1));
        }

        return currans;
    }
}