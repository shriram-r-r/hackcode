/***
	There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

	The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

	Note:
	All costs are positive integers.
***/
public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] cost = new int[n][3];
        
        cost[0][0] = costs[0][0];
        cost[0][1] = costs[0][1];
        cost[0][2] = costs[0][2];
        // System.out.println(Arrays.toString(cost[0]));
        for(int i = 1;i<n;i++){
            cost[i][0] = costs[i][0] + Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] = costs[i][1] + Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] = costs[i][2] + Math.min(cost[i-1][0], cost[i-1][1]);
            // System.out.println(Arrays.toString(cost[i]));
        }
        
        return Math.min(Math.min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]);
    }
}