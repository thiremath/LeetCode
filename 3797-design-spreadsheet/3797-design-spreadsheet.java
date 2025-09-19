// class Spreadsheet {

//     public Spreadsheet(int rows) {
        
//     }
    
//     public void setCell(String cell, int value) {
        
//     }
    
//     public void resetCell(String cell) {
        
//     }
    
//     public int getValue(String formula) {
        
//     }
// }

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);

Design a spreadsheet
1. A user can create a spreadsheet with n number of rows and 26 cols labeled from 'A' to 'Z'
2. A user should be able to set and reset a cell with a desired value.

A cell should be identified by col+""+row. Eg= A12, B5

Follow-up: implement sum



 */

 class Spreadsheet{
    private int[][] sheet;
    private int rows;
    private int cols;
    private CellParser parser;

    public Spreadsheet(int rowsIn){
        rows = rowsIn;
        cols = 26;
        sheet = new int[rows][cols];
    }

    public int getCellValue(String cell){
        int[] parsedCell = parser.parse(cell);
        return sheet[parsedCell[0]][parsedCell[1]];
    }

    public void setCell(String cell, int val){
        int[] parsedCell = parser.parse(cell);
        sheet[parsedCell[0]][parsedCell[1]]=val;
    }

    public void resetCell(String cell){
        int[] parsedCell = parser.parse(cell);
        sheet[parsedCell[0]][parsedCell[1]]=0;
    }

    public int getValue(String formula) {
        formula=formula.replace("=","");
        int res=0;

        for(String st: formula.split("\\+")){
            if(Character.isDigit(st.charAt(0))){
                res += Integer.valueOf(st);
            }
            else{
                int[] parsedCell = parser.parse(st);
                res += sheet[parsedCell[0]][parsedCell[1]];
            }
        }

        return res;
    }
 }

 class CellParser{
    public static int[] parse(String cell){
        int a = Integer.valueOf(cell.substring(1,cell.length()))-1;
        int b = cell.charAt(0)-'A';
        return new int[]{a,b};
    }
 }