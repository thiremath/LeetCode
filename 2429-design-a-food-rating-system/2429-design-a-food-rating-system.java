class FoodRatings {

    // Map Cuisine to foods to find highest rated foods
    // Map<String,List<FoodRatingPair>>
    // global Map<String,FoodRatingPair>

    /*

    */

    private Map<String,Food> FoodMap;
    private Map<String,PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        FoodMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for(int i=0;i<n;i++){
            // food creation and foodMap logic
            Food f = new Food(foods[i],ratings[i],cuisines[i]);
            FoodMap.put(foods[i],f);

            // cuisine logic
            if(!cuisineFoodMap.containsKey(cuisines[i])){
                cuisineFoodMap.put(cuisines[i],new PriorityQueue<>((a,b)->{
                    int aRating = a.getFoodRating();
                    int bRating = b.getFoodRating();
                    if(aRating != bRating){
                        return bRating-aRating;
                    }
                    return (a.getFoodName().compareTo(b.getFoodName()));
                }));
            }
            cuisineFoodMap.get(cuisines[i]).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        if(FoodMap.containsKey(food) && FoodMap.get(food).getFoodRating()!=newRating){
            Food currFood = FoodMap.get(food);
            Food updatedFood = new Food(currFood);
            updatedFood.setFoodRating(newRating);
            FoodMap.put(food,updatedFood);
            cuisineFoodMap.get(currFood.getCuisine()).add(updatedFood);
        }
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> currFoodMap = cuisineFoodMap.get(cuisine);
        while(currFoodMap.peek().getFoodRating() != FoodMap.get(currFoodMap.peek().getFoodName()).getFoodRating()){
            currFoodMap.poll();
        }
        return currFoodMap.peek().getFoodName();
    }
}

class Food{
    private final String foodName;
    private int foodRating;
    private final String Cuisine;

    public Food(String foodNameIn,int foodRatingIn, String CuisineIn){
        foodName = foodNameIn;
        foodRating = foodRatingIn;
        Cuisine = CuisineIn;
    }

    public Food(Food fIn){
        foodName = fIn.getFoodName();
        foodRating = fIn.getFoodRating();
        Cuisine = fIn.getCuisine();
    }

    public void setFoodRating(int RatingIn){
        foodRating = RatingIn;
    }

    public int getFoodRating(){
        return foodRating;
    }

    public String getCuisine(){
        return Cuisine;
    }

    public String getFoodName(){
        return foodName;
    }

}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */