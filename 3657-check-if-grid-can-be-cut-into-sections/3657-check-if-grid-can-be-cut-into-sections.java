// class Solution {
//     public boolean checkValidCuts(int n, int[][] rectangles) {
//         return (checkValidCutsWorker(rectangles,'x') || checkValidCutsWorker(rectangles,'y'));
//     }

//     public boolean checkValidCutsWorker(int[][] rectangles, char c) {

//         int len = rectangles.length;

//         int[][] arr = new int[len][2];

//         if(c == 'x'){
//             for(int i=0;i<len;i++){
//                 arr[i][0] = rectangles[i][0];
//                 arr[i][1] = rectangles[i][2];
//             }
//         }

//         else{
//             for(int i=0;i<len;i++){
//                 arr[i][0] = rectangles[i][1];
//                 arr[i][1] = rectangles[i][3];
//             }
//         }

//         Arrays.sort(arr,(x,y) -> Integer.compare(x[0],y[0]));

//         int cuts=0;
//         int temp=-1;

//         for(int[] innerArr: arr){
//             if(innerArr[0] < temp){
//                 if(innerArr[1] > temp){
//                     temp = innerArr[1];
//                 }
//             }
//             else{
//                 cuts++;
//                 temp=innerArr[1];
//             }
//         }

//         return (cuts >= 3) ? true : false;
//     }
// }


class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {

        int len = rectangles.length;

        int[][] x_axis = new int[len][2];
        int[][] y_axis = new int[len][2];

        for(int i=0;i<len;i++){
            x_axis[i][0] = rectangles[i][0];
            y_axis[i][0] = rectangles[i][1];
            x_axis[i][1] = rectangles[i][2];
            y_axis[i][1] = rectangles[i][3];
        }

        Arrays.sort(x_axis,(x,y) -> Integer.compare(x[0],y[0]));
        Arrays.sort(y_axis,(x,y) -> Integer.compare(x[0],y[0]));

        return (checkValidCutsWorker(x_axis) || checkValidCutsWorker(y_axis)) ;
    }

    public boolean checkValidCutsWorker(int[][] arr) {

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