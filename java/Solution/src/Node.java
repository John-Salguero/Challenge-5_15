import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node {
    public static final int DATA_SIZE = 1;
    private Node next;
    private byte[] data;

    Node(byte[] data){
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        Set<Node> nodes = new HashSet<>();
        nodes.add(this);
        StringBuilder retVal = new StringBuilder();
        if(next != null)
            retVal.append("Node{next=").append(next.toString(nodes)).append(", data=");
        else
            retVal.append("Node{next=null, data=");


        for (byte datum : data) {
            retVal.append(datum);
        }
        retVal.append('}');

        return retVal.toString();
    }

    public String toString(int depth) {
        if(depth < 1)
            return "...";
        StringBuilder retVal = new StringBuilder();
        if(next != null)
            retVal.append("Node{next=").append(next.toString(depth-1)).append(", data=");
        else
            retVal.append("Node{next=null, data=");


        for (byte datum : data) {
            retVal.append(datum);
        }
        retVal.append('}');

        return retVal.toString();
    }

    public String toString(Set<Node> nodes) {
        StringBuilder retVal = new StringBuilder();
        if(nodes.contains(this)){
            retVal.append("Node{next=..., data=");
        } else {
            nodes.add(this);
            if(next != null)
                retVal.append("Node{next=").append(next.toString(nodes)).append(", data=");
            else
                retVal.append("Node{next=null, data=");
        }

        for (byte datum : data) {
            retVal.append(datum);
        }
        retVal.append('}');

        return retVal.toString();
    }
}
