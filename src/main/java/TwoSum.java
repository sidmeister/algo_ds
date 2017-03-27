/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.*;

public class TwoSum
{

  public static int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int index = 0;
       ArrayList<Integer> result = new ArrayList<>();
       for(int i=0;i<nums.length;i++)
       {
         if(map.containsKey(target - nums[i]))
         {
           result.add(map.get(target - nums[i]));
           result.add(i);
         }
         else
         {
           map.put(nums[i],i);
         }
       }
       int[] ret = new int[result.size()];
       for (int i=0; i < ret.length; i++)
       {
         ret[i] = result.get(i);
       }
       return ret;
     }

  public static void main (String[] args)
  {
      int[] arr = new int[]{2,11,7,15};
      int target = 9;
      System.out.println(twoSum(arr,target));
    }
}
