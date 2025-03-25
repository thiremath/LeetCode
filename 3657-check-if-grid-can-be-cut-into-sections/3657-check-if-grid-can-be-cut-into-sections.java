class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return (checkValidCutsWorker(rectangles,'x') || checkValidCutsWorker(rectangles,'y'));
    }

    public boolean checkValidCutsWorker(int[][] rectangles, char c) {

        int len = rectangles.length;

        int[][] arr = new int[len][2];

        if(c == 'x'){
            for(int i=0;i<len;i++){
                arr[i][0] = rectangles[i][0];
                arr[i][1] = rectangles[i][2];
            }
        }

        else{
            for(int i=0;i<len;i++){
                arr[i][0] = rectangles[i][1];
                arr[i][1] = rectangles[i][3];
            }
        }

        Arrays.sort(arr,(x,y) -> Integer.compare(x[0],y[0]));

        int cuts=0;
        int temp=-1;

        for(int[] innerArr: arr){
            if(innerArr[0] < temp){
                if(innerArr[1] > temp){
                    temp = innerArr[1];
                }
            }
            else{
                cuts++;
                temp=innerArr[1];
            }
        }

        return (cuts >= 3) ? true : false;
    }
}