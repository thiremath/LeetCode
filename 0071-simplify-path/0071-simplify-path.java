class Solution {
    public String simplifyPath(String path) {
        int strindex=0;
        int arrindex=0;
        String[] arr = new String[path.length()];
        StringBuilder temp = new StringBuilder("");

        while(strindex < path.length()){

            while(strindex < path.length() && path.charAt(strindex) == '/'){
                strindex++;
            }

            while(strindex < path.length() && path.charAt(strindex) != '/'){
                temp.append(path.charAt(strindex));
                strindex++;
            }

            if(!(temp.toString().equals(".")) && !(temp.toString().equals(""))){
                if(temp.toString().equals("..")){
                    if(arrindex > 0){
                        arrindex--;
                    }
                }
                else{
                    // System.out.println(temp.toString()+" next");
                    arr[arrindex] = temp.toString();
                    arrindex++;
                }
            }

            temp = new StringBuilder("");

        }

        temp = new StringBuilder("/");

        for(int i=0;i<arrindex;i++){
            temp.append(arr[i]);
            if(i != arrindex-1){
                temp.append("/");
            }
        }

        return temp.toString();


    }
}