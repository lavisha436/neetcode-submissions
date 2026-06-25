class TimeMap {
    HashMap<String,List<Pair>> map;

    class Pair{
      String value;
      int timestamp;
      Pair(String value , int timestamp){
        this.value = value;
        this.timestamp = timestamp;
      }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList());//list create krenge
        }
        map.get(key).add(new Pair(value,timestamp));  
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size()-1;
        String ans = "";
        while(left<=right){
            int mid = (left+right)/2;
            if(list.get(mid).timestamp <= timestamp){
            ans = list.get(mid).value;
            left = mid+1;
            } else{
            right = mid-1;
           }     
       }
      return ans;
    }
}
