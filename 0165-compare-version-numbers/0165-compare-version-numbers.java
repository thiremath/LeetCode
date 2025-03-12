class Solution {
    public int compareVersion(String version1, String version2) {
        int res=0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length;
        int n2 = v2.length;
        // System.out.print(v1.length);
        // for(String c: v1){
        //     System.out.print(c+" ");
        // }
        // System.out.println("");
        // for(String c: v2){
        //     System.out.print(c+" ");
        // }
        int pv1=0,pv2=0;

        while(pv1 < n1 && pv2 < n2){
            int curr1 = Integer.valueOf(v1[pv1]);
            int curr2 = Integer.valueOf(v2[pv2]);

            if(curr1 > curr2){
                return 1;
            }

            else if(curr1 < curr2){
                return -1;
            }

            pv1++;
            pv2++;
        }

        if(pv1 < n1){
            while(pv1 < n1 && Integer.valueOf(v1[pv1])==0){
                pv1++;
            }
            if(pv1 < n1){
                return 1;
            }
        }

        else{
            while(pv2 < n2 && Integer.valueOf(v2[pv2])==0){
                pv2++;
            }
            if(pv2 < n2){
                return -1;
            }
        }

        return 0;
    }
}

// [1],[01]
// [1],[001]