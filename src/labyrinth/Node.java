package labyrinth;

import java.util.*;

public class Node {

    private List<Node> neighbours;
    private Node[] neigh;
    private String name;
    int nodes = 0;
    private int color;
    private int distance;
    private int x;
    private int y;
    private Node prev;

    public Node(String n) {//not used
        prev = null;
        neigh = new Node[4];
        nodes = 0;
        neighbours = new ArrayList<>();
        name = n;
        color = 0;
        distance = 0;
    }

    public Node(int i, int j) {
        prev = null;
        neigh = new Node[4];
        neighbours = new ArrayList<>();
        color = 0;
        distance = 99999;
        x = i;
        y = j;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }
    
    public Node[] getNeigh(){
        return neigh;
    }

    public int getColor() {
        return color;
    }

    public int getDist() {
        return distance;
    }

    public void incDist(int i) {
        distance = i + 1;
    }

    public void start() {
        distance = 0;
        visit();
    }

    public void visit() {
        color = 1;
    }

    public void reset() {
//        prev = null;
        color = 0;
        distance = 99999;
    }

    public void setPrev(Node n) {
        prev = n;
    }
    
    public Node getPrev(){
        return prev;
    }

    public void connect(Node n) {
//        if (!neighbours.contains(n)) {
//            neighbours.add(n);
//            n.connect(this);
//        }
        int temp = 0;
        for (int a = 0; a < 4; a++) {
            if (neigh[a] == n) {
                temp++;
                break;
            }
        }
        if (temp == 0) {
            if (nodes < 4) {
                neigh[nodes++] = n;
                n.connect(this);
            }
        }
    }

}
