class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, int[]> xMap = new HashMap<>();  // x -> [minY, maxY]
        HashMap<Integer, int[]> yMap = new HashMap<>();  // y -> [minX, maxX]

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            xMap.putIfAbsent(x, new int[]{y, y});
            yMap.putIfAbsent(y, new int[]{x, x});

            int[] yrange = xMap.get(x);
            yrange[0] = Math.min(yrange[0], y);
            yrange[1] = Math.max(yrange[1], y);

            int[] xrange = yMap.get(y);
            xrange[0] = Math.min(xrange[0], x);
            xrange[1] = Math.max(xrange[1], x);
        }

        int res = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            int[] yrange = xMap.get(x);
            int[] xrange = yMap.get(y);

            boolean coveredOnX = y > yrange[0] && y < yrange[1];
            boolean coveredOnY = x > xrange[0] && x < xrange[1];

            if (coveredOnX && coveredOnY) res++;
        }

        return res;
    }
}
