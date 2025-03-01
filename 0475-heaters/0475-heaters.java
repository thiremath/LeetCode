// class Solution {
//     public int findRadius(int[] houses, int[] heaters) {
        
//         // add ele to houses set

//         // traverse heaters increase radius
//         // if ele found in set, increase count
//         // add ele-1,ele+1 to heaters
//         // remove ele

//         HashSet<Integer> set = new HashSet<>();
//         HashSet<Integer> finalset = new HashSet<>();
//         Queue<Integer> queue = new LinkedList<>();

//         int radius=0,count=0;

//         for(int num: houses){
//             set.add(num);
//         }

//         for(int ele: heaters){
//             if(ele > 1){
//                 queue.add(ele-1);
//             }
//             if(ele < ((int)Math.pow(10,9))-1){
//                 queue.add(ele+1);
//             }
//             if(set.contains(ele)){
//                 finalset.add(ele);
//                 count++;
//             }
//         }

//         if(count < set.size()){

//             while(!queue.isEmpty() && count < set.size()){

//                 int size = queue.size();
//                 radius++;

//                 // System.out.println("count = "+count);
//                 // System.out.println("queue = "+queue);
//                 // System.out.println("radius = "+radius);
//                 // System.out.println("");

//                 while(size-- != 0 && count < set.size()){

//                 // System.out.println("innercount = "+count);
//                 // System.out.println("queue = "+queue);
//                 // System.out.println("radius = "+radius);
//                 // System.out.println("");

//                     // if(count ==1){
//                     // System.out.println("innercount = "+count);
//                     // }
//                     int ele = queue.remove();
//                     // System.out.println("ele "+ele);
//                     if(set.contains(ele) && !finalset.contains(ele)){
//                         finalset.add(ele);
//                         count++;
//                     }
//                     if(ele > 1){
//                         if(!queue.contains(ele-1)){
//                             queue.add(ele-1);
//                         }
//                     }
//                     if(ele < ((int)Math.pow(10,9))-1){
//                         if(!queue.contains(ele+1)){
//                             queue.add(ele+1);
//                         }
//                     }
//                 }
//             }
//         }

//         return radius;

//     }
// }


// /**

// houses-[1,*3,4,*5,6,7,8,*9,13,14,*15] 
// heaters-[3,5,9,15]
// 2,4,6,8,10,14,16
// 1,7,13

// houses-[1,*3,*4,*5,*6,7,*8,*9,13,*14,*15] 
// heaters-[3,5,9,15]

// */



class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        int radius = 0;
        // HashSet<Integer> set = new HashSet<>();

        // for(int heater: heaters){
        //     set.add(heater);
        // }

        Arrays.sort(heaters);

        for(int house: houses){

            // if(!set.contains(house)){

                // find closest
                int low=0;
                int high=heaters.length-1;
                int closest = Math.abs(heaters[low]-house);

                while(low <= high){
                    int mid = (low+high)/2;
                    if(house == heaters[mid]){
                        closest=0;
                        break;
                    }
                    else if(house > heaters[mid]){
                        // closest = Math.min(Math.abs(heaters[low]-house),closest);
                        low = mid+1;
                    }
                    else{
                        // closest = Math.min(Math.abs(heaters[high]-house),closest);
                        high = mid-1;
                    }
                }

                if(closest == 0){
                    continue;
                }

                if(low <= heaters.length-1){
                    closest = Math.min(Math.abs(heaters[low]-house),closest);
                }

                if(high >= 0){
                    closest = Math.min(Math.abs(heaters[high]-house),closest);
                }

                // System.out.println("closest radius for "+house+" is "+closest);

                // calc dist and update radius
                radius = Math.max(radius,closest);
            // }
        }

        return radius;
    }
}