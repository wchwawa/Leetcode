import java.util.HashMap;
import java.util.Map;

class minSubString {
    public int minSubArrayLen(int target, int[] nums) {
        Map<Integer, Integer> subMap = new HashMap<>();
        int minSubStringLength = 0;
        for (int i  = 0; i < nums.length; i++){
            int subtractNum = target - nums[i];
            if(subtractNum <= 0){
                return 1;
            }
            subMap.put(i, subtractNum);
            for (int j = i + 1; j < nums.length; j ++){
                int restValue  = subMap.get(i) - nums[j];
                if (restValue > 0){
                    subMap.put(i, restValue);
                }else{
                    if(minSubStringLength == 0 || minSubStringLength > j - i + 1){
                        minSubStringLength = j - i + 1;
                        break;
                    }
                }
            }
        }
        return minSubStringLength;
    }

    public static void main(String[] args) {
        minSubString mss = new minSubString();
        int target = 100;
        int [] nums = {2,3,1,2,-4,3};
        System.out.println(mss.minSubArrayLen(target, nums));
    }
}
