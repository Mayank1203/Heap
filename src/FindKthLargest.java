import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FindKthLargest {
    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        FindKthLargest obj = new FindKthLargest();
        System.out.println(obj.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        // BY MIN HEAP

        // 1. build a minheap

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int num : nums) {
            minheap.add(num);

            // 2. delete (n-k) number of elements
            if (minheap.size() > k) {
                minheap.remove();
            }
        }

        // 3. access the root element in the heap
        return minheap.peek();
    }
}

// Question Link => https://leetcode.com/problems/kth-largest-element-in-an-array/