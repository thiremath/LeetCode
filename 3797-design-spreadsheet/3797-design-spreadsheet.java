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

    public Spreadsheet(int rowsIn){
        rows = rowsIn;
        cols = 26;
        sheet = new int[rows][cols];
    }

    public int getCellValue(String cell){
        int[] parsedCell = parse(cell);
        return sheet[parsedCell[0]][parsedCell[1]];
    }

    public void setCell(String cell, int val){
        int[] parsedCell = parse(cell);
        sheet[parsedCell[0]][parsedCell[1]]=val;
    }

    public void resetCell(String cell){
        int[] parsedCell = parse(cell);
        sheet[parsedCell[0]][parsedCell[1]]=0;
    }

    public int[] parse(String cell){
        int[] parsedCell = new int[2];
        parsedCell[0] = Integer.valueOf(cell.substring(1,cell.length()))-1;
        parsedCell[1] = cell.charAt(0)-'A';
        return parsedCell;
    }

    public int getValue(String formula) {
        formula=formula.replace("=","");
        String[] arr = formula.split("\\+");
        int a=0,b=0;

        if(Character.isDigit(arr[0].charAt(0))){
            a = Integer.valueOf(arr[0]);
        }
        else{
            int[] parsedCell = parse(arr[0]);
            a = sheet[parsedCell[0]][parsedCell[1]];
        }

        if(Character.isDigit(arr[1].charAt(0))){
            b = Integer.valueOf(arr[1]);
        }
        else{
            int[] parsedCell = parse(arr[1]);
            b = sheet[parsedCell[0]][parsedCell[1]];
        }

        return a+b;
    }
 }