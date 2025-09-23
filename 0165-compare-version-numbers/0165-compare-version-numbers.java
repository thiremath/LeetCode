class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1arr = version1.split("\\.");
        String[] v2arr = version2.split("\\.");

        int v1p=0,v2p=0;

        // System.out.println(v1arr.length+" "+v2arr.length);

        while(v1p<v1arr.length || v2p<v2arr.length){
            int a=0,b=0;

            if(v1p<v1arr.length){
                a = Integer.valueOf(v1arr[v1p]);
                v1p++;
            }
            if(v2p<v2arr.length){
                b = Integer.valueOf(v2arr[v2p]);
                v2p++;
            }

            // System.out.println(a+" "+b);

            if(a > b){
                return 1;
            }
            else if(b > a){
                return -1;
            }
        }
        return 0;
    }
}