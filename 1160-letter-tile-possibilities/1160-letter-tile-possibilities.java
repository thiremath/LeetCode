class Solution {

    HashSet<String> set = new HashSet<String>();

    public int numTilePossibilities(String tiles) {

        numTilePossibilitiesWorker(tiles,tiles.length()-1,"");

        // for(String s: set){
        //     System.out.println(s);
        // }

        return set.size();
    }

    public void numTilePossibilitiesWorker(String tiles, int index, String st){

        if(index == -1){
            return ;
        }

        if(st.length() == 0){
            set.add(String.valueOf(tiles.charAt(index)));
            numTilePossibilitiesWorker(tiles,index-1,String.valueOf(tiles.charAt(index)));
            numTilePossibilitiesWorker(tiles,index-1,"");
        }

        numTilePossibilitiesWorker(tiles,index-1,st);

        for(int i=0;i<st.length()+1;i++){
            
            String newstr = st.substring(0,i)+ tiles.charAt(index)+ st.substring(i,st.length()) ;
            set.add(newstr);

            numTilePossibilitiesWorker(tiles,index-1,newstr);
        }
        

    }
}


// AAB

// ""

// B

// AB
// BA

// AAB
// ABA

// BAA
// BAB


// ABC

// ""

// C
// ""

// BC
// CB
// C
// B

// ABC
// BAC
// BCA
// ACB
// CAB
// CBA
// AC
// CA