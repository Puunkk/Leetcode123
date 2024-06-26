import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        
        backtrack(result, new ArrayList<>(), nums, 0);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp)); 
        
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]); 
            backtrack(result, temp, nums, i + 1); 
            temp.remove(temp.size() - 1); 
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
