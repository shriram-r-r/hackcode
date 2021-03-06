/**
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed depth.
 * For example, given the list {{1,1},2,{1,1}} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2)
 * Given the list {1,{4,{6}}} the function should return 17 (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)
 */
 
/**
 * This is the interface that represents nested lists.
 * You should not implement it, or speculate about its implementation.
 */
public interface NestedInteger
{
    /** @return true if this NestedInteger holds a single integer, rather than a nested list */
    boolean isInteger();
 
    /** @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list */
    Integer getInteger();
 
    /** @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer */
    List<NestedInteger> getList();
}

 
class Solution{
    int maxDepth = 1;
    int counter = 0;
    
     public int helper(List<NestedInteger> input, int depth){
         int sum = 0;
          
          for(NestedInteger nested : input){
              if(nested.isInteger()){              
                  counter += nested.getInteger();
                  sum += nested.getInteger() * depth; 
              }else{                  
                  maxDepth = maxDepth +1;
                  sum += helper(nested.getList(), depth+1);
              }
          }
          return sum;             
     }
 

    public int reverseDepthSum (List<NestedInteger> input)
    {
        // implementation here
        if(input == null || input.length == 0) return 0;
        int sum = helper(input, 1);
        return (((maxDepth+1) * counter) - sum);
    }
    
}