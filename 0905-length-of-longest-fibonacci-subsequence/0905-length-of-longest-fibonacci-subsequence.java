class Solution {
    public int lenLongestFibSubseq(int[] arr) {

        int res=0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num: arr){
            set.add(num);
        }

        for(int i=0;i<arr.length-2;i++){

            if(res >= arr.length-i){
                return res;
            }

            int currlen=0;

            for(int j=i+1;j<arr.length;j++){
                int a = arr[i];
                int b = arr[j];
                // System.out.println("a= "+a+"+ b= "+b);
                if(set.contains(a+b)){
                    currlen = 2;
                    while(set.contains(a+b)){
                        // System.out.println(a+"+"+b);
                        currlen++;
                        // System.out.println("currlen= "+currlen);
                        int temp = b;
                        b += a;
                        a = temp;
                    }
                    res = Math.max(res,currlen);
                }
            }
        }

        return res;
    }
}