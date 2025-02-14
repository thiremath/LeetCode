class ProductOfNumbers {
    List<Integer> li;
    public ProductOfNumbers() {
        li = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0){
            li = new ArrayList<>();
        }
        else if(li.size()==0){
            li.add(num) ;
        }
        else{
            li.add(num*li.get(li.size()-1));
        }
    }
    
    public int getProduct(int k) {
        if(k > li.size()){
            return 0;
        }

        if(k == li.size()){
            return li.get(li.size()-1);
        }

        return li.get(li.size()-1) / li.get(li.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */