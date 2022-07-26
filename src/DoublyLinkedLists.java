public class DoublyLinkedLists implements GameApplication {
    private Node head, tail = null;

    public DoublyLinkedLists() {
        head = null;
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public int getSize() {
        int counter = 0;
        Node walk = head;

        while (walk != null) {
            counter++;
            walk = walk.getNext();
        }
        return counter;
    }

    @Override
    public void addNode(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setPrevious(null);
            newNode.setNext(null);
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public String print(int height, int weight) {
        String str = "";
        int counter = 0;

        Node walk = head;

        while (walk != null) {
            if (counter % weight == 0) {
                str += "\n";
            }
            str += walk.getData();
            counter++;
            walk = walk.getNext();
        }
        return str;
    }

    public String toString() {
        int counter = 1;
        int size = getSize();
        String str = "{";
        Node walk = head;
        while (walk != null) {
            if (counter < size) {
                str += walk.getData() + ", ";
                walk = walk.getNext();
            } else if (counter == size) {
                str += walk.getData();
                walk = walk.getNext();
            }
            counter++;
        }
        str += "}";
        return str;
    }
}
