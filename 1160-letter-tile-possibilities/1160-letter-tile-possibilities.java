class Solution {

    HashSet<String> set = new HashSet<String>();

    public int numTilePossibilities(String tiles) {

        numTilePossibilitiesWorker(tiles,tiles.length()-1,"");

        return set.size();
    }

    public void numTilePossibilitiesWorker(String tiles, int index, String st){



        if(index == -1){
            return ;
        }

        StringBuilder s2 = new StringBuilder(String.valueOf(tiles.charAt(index)));

        if(st.length() == 0){
            set.add(String.valueOf(tiles.charAt(index)));
            numTilePossibilitiesWorker(tiles,index-1,String.valueOf(s2));
            numTilePossibilitiesWorker(tiles,index-1,"");
        }

        numTilePossibilitiesWorker(tiles,index-1,st);

        for(int i=0;i<st.length()+1;i++){
            StringBuilder s1 = new StringBuilder(st.substring(0,i));
            // StringBuilder s2 = new StringBuilder(String.valueOf(tiles.charAt(index)));
            StringBuilder s3 = new StringBuilder(st.substring(i,st.length()));

            String s = String.valueOf( s1.append(s2).append(s3) );
            set.add(s);

            numTilePossibilitiesWorker(tiles,index-1,s);
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