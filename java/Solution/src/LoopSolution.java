public class LoopSolution {

    public Node findLoop(Node head0) {
        if (head0 == null || head0.getNext() == null)
            return null;

        Node slow = head0;
        Node fast = head0;

        // Detect the loop using Floyd's Cycle Detection algorithm
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast)
                break;
        }

        // If there is no loop, return null
        if (fast == null || fast.getNext() == null)
            return null;

        // Move one pointer to the head and traverse both pointers at the same speed
        // The point where they meet is the start of the loop
        slow = head0;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        // Return the node that begins the loop
        return slow;
    }
}
