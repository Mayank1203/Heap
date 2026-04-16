import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubsequence {
    public static void main(String[] args){
        int[] nums = {2,1,3,3};
        int k = 2 ;

        System.out.println(Arrays.toString(maxSubsequence(nums,k)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int [] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int i = 0 ; i < nums.length ; i++){
            pq.add(nums[i]);
        }
        while(pq.size()!=k)pq.poll();
        int ans_itr = 0;
        for( int i = 0 ; i  < nums.length ; i++){
            if(pq.contains(nums[i])){
                ans[ans_itr++]=nums[i];
                pq.remove(nums[i]);

            }
            if(ans_itr == k)return ans;
        }
        return ans;
    }
}
// Question Link => https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/