import java.util.Date;
import java.util.Random;

public class Main {
    private static final LoopSolution loopSolution = new LoopSolution();
    private static final IntersectionSolution intersectionSolution = new IntersectionSolution();
    private static final Random random = new Random();

    static
    {
        random.setSeed(System.currentTimeMillis());
    }

    public static byte[] getRandomData() {
        byte[] bytes = new byte[Node.DATA_SIZE];
        random.nextBytes(bytes);
        return bytes;
    }

    private static Node generateList(int size){
        if(size < 1)
            throw new IllegalArgumentException("List cannot be empty!");

        Node head = new Node(getRandomData());
        Node tail = head;
        while(--size != 0) {
            tail.setNext(new Node(getRandomData()));
            tail = tail.getNext();
        }

        return head;
    }

    private static void loopTest(Node head) {
        Node loop = loopSolution.findLoop(head);

        System.out.println("List: ");
        if(head != null)
            System.out.println(head.toString());
        else
            System.out.println("null");
        if(loop != null) {
            System.out.println("Linked List has loop at Node:");
            System.out.println(loop.toString(1));
        }
        else {
            System.out.println("Linked List does not loop");
        }
    }
    private static void testIsNotLoop0() {
        loopTest(null);
    }

    private static void testIsNotLoop1() {
        Node head = generateList(1);
        loopTest(head);
    }

    private static void testIsNotLoop2() {
        Node head = generateList(255);
        loopTest(head);
    }

    private static void testIsLoop0() {
        Node head = generateList(1);
        head.setNext(head);
        loopTest(head);
    }

    private static void testIsLoop1() {
        Node head = generateList(2);
        head.getNext().setNext(head);
        loopTest(head);
    }

    private static void testIsLoop2() {
        Node head0 = generateList(150);
        Node tail0 = head0;
        while(tail0.getNext() != null) {
            tail0 = tail0.getNext();
        }
        Node head1 = generateList(105);
        Node tail1 = head1;
        while (tail1.getNext() != null) {
            tail1 = tail1.getNext();
        }
        tail1.setNext(head0);
        tail0.setNext(head0);

        loopTest(head0);
    }

    private static void testLoopSolution(){
        System.out.println("---Does not Loop---");
        testIsNotLoop0();
        testIsNotLoop1();
        testIsNotLoop2();
        System.out.println("---Loops---");
        testIsLoop0();
        testIsLoop1();
        testIsLoop2();
    }

    private static void intersectTest(Node head0, Node head1) {
        Node intersect = intersectionSolution.findIntersect(head0, head1);

        System.out.println("List 1: ");
        System.out.println(head0);
        System.out.println("List 2: ");
        System.out.println(head1);
        if(intersect != null) {
            System.out.println("Linked List has intersect at Node:");
            System.out.println(intersect.toString(1));
        }
        else {
            System.out.println("Linked Lists do not intersect");
        }
    }

    private static void testDoesNotIntersect0() {
        intersectTest(null, null);
    }

    private static void testDoesNotIntersect1() {
        Node head1 = generateList(1);

        intersectTest(null, head1);
    }

    private static void testDoesNotIntersect2() {
        Node head0 = generateList(255);
        Node head1 = generateList(255);

        intersectTest(head0, head1);
    }

    private static void testIntersects0() {
        Node head0 = generateList(1);
        Node head1 = generateList(1);
        head0.setNext(head1);

        intersectTest(head0, head1);
    }

    private static void testIntersects1() {
        Node head0 = generateList(255);
        Node head1 = generateList(1);
        Node tail0 = head0;
        while(tail0.getNext() != null) {
            tail0 = tail0.getNext();
        }
        tail0.setNext(head1);

        intersectTest(head0, head1);
    }

    private static void testIntersects2() {
        Node head0 = generateList(105);
        Node head1 = generateList(150);
        Node tail0 = head0;
        while(tail0.getNext() != null) {
            tail0 = tail0.getNext();
        }
        Node mid1 = head1;
        int iterations = 50;
        do{
            mid1 = mid1.getNext();
        } while(--iterations > 0);
        tail0.setNext(mid1);

        intersectTest(head0, head1);
    }

    private static void testIntersects3() {
        Node head0 = generateList(3);
        Node head1 = generateList(3);
        Node tail0 = head0;
        while(tail0.getNext() != null) {
            tail0 = tail0.getNext();
        }
        tail0.setNext(head1);

        intersectTest(head0, head1);
    }

    private static void testIntersectionSolution(){
        System.out.println("---Does Not Intersect---");
        testDoesNotIntersect0();
        testDoesNotIntersect1();
        testDoesNotIntersect2();
        System.out.println("---Intersects---");
        testIntersects0();
        testIntersects1();
        testIntersects2();
        testIntersects3();
    }

    public static void main(String[] args) {
        System.out.println("---Testing Loops---");
        testLoopSolution();
        System.out.println("---Testing Intersections---");
        testIntersectionSolution();
    }
}
