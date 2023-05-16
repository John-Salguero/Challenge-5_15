public class IntersectionSolution {
    public Node findIntersect(Node head0, Node head1) {

        if (head0 == null || head1 == null)
            return null;

        Node curr0 = head0;
        Node curr1 = head1;

        // Traverse both lists until they intersect or reach the end
        while (curr0 != curr1) {
            // If we reach the end of one list, move to the other list
            if (curr0 == null)
                curr0 = head1;
            else
                curr0 = curr0.getNext();

            if (curr1 == null)
                curr1 = head0;
            else
                curr1 = curr1.getNext();
        }

        // Return the intersection node (or null if no intersection found)
        return curr0;
    }
}
