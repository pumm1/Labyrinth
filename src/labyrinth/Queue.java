package labyrinth;

public class Queue {

    private Node[] table;
    private int head;
    private int tail;
    private int size;

    public Queue(int size) {
        table = new Node[size];
        head = 0;
        tail = 0;
        this.size = size;
    }

    public void enqueue(Node t) {
        table[tail] = t;
        tail++;
        if (tail == size) {
            tail = 0;
        }
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public boolean isEmpty() {
        if (table[head] == null) {
            return true;
        }
        return false;
    }

    public Node dequeue() {
        Node ret = table[head];
        table[head] = null;
        head++;
        if (head == size) {
            head = 0;
        }
        return ret;
    }

}
