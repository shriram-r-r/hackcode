/***
	1. Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
	2. Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
	3. You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
	4. Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
***/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n<=0) return -1;
        if(n==1) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i< n;i++) stack.push(i);
        
        while(stack.size()>1){
            int u = stack.pop();
            int v = stack.pop();
            //if the u knows v, then v might be celebrity
            if(knows(u,v)) stack.push(v);
            else stack.push(u); // u doesnt know v, so u might be celebrity
        }
        
        //pop the final guy
        int celeb = stack.pop();
        for(int i=0;i< n;i++){ 
            //for the final guy to not be a celebrity, he should know someone or 
            //someone should not know him. If this condition is true, then return 
            //no celebrity found!
            if(i!=celeb && (knows(celeb, i) || !knows(i, celeb))){ return -1; }
        }
        
        //return the found celebrity
        return celeb;
    }
}