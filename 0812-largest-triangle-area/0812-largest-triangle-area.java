class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0.0;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    res = Math.max(res,calculateArea(points,i,j,k));
                }
            }
        }

        return res;
    }

    public double calculateArea(int[][] points, int idx1, int idx2, int idx3){
        double x1=points[idx1][0],y1=points[idx1][1];
        double x2=points[idx2][0],y2=points[idx2][1];
        double x3=points[idx3][0],y3=points[idx3][1];

        // System.out.println(((x1*(y2-y3))+x2*(y3-y1)+x3*(y1-y2))/2.0);

        return Math.abs(((x1*(y2-y3))+x2*(y3-y1)+x3*(y1-y2))/2.0);
    }
}