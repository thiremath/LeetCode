class Solution {
    public int[][] merge(int[][] intervals) {
        /**
        
        [[1,3],[2,6],[8,10],[15,18]]

        [1,6]

         */

        int n = intervals.length;

        if(n<=1){
            return intervals;
        }

        List<int[]> res = new ArrayList<>();

        // sort the intervals array

        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        res.add(new int[]{intervals[0][0],intervals[0][1]});

        for(int i=1;i<n;i++){
            int[] prev = res.get(res.size()-1);

            if(prev[1]>=intervals[i][0]){
                prev[1] = Math.max(prev[1],intervals[i][1]);
            }

            else{
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }

        int[][] retArr = new int[res.size()][2];

        for(int i=0;i<res.size();i++){
            retArr[i] = res.get(i);
        }

        return retArr;
    }
}