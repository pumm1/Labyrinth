package labyrinth;

import java.util.*;

public class Graph {

    /*
    TODO:
    välillä heittää nullpointteria
     */
    private List<Node> nodes;
    private int[][] grid;
    private Node[][] nGrid;
    private Character player;
    private Character monster;
    private HashMap<Node, Node> tree;
//    private Queue<Node> queue;
    private Queue queue;
    private Node start;

    public Graph(int[][] g) {

//        queue = new LinkedList<>();
        queue = new Queue(2500);
        grid = g;
        nGrid = new Node[50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (grid[i][j] == 0) {
                    Node n = new Node(i, j);
                    nGrid[i][j] = n;
//                    System.out.println("node added: i" + i + ", " + "j: " + j);
                }
            }
        }

        /*connect nodes and their neighbours*/
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    if (i + 1 < 50) {
                        if (nGrid[i + 1][j] != null) {
                            nGrid[i][j].connect(nGrid[i + 1][j]);
                        }
                    }
                    if (i - 1 >= 0) {
                        if (nGrid[i - 1][j] != null) {
                            nGrid[i][j].connect(nGrid[i - 1][j]);
                        }
                    }
                    if (j + 1 < 50) {
                        if (nGrid[i][j + 1] != null) {
                            nGrid[i][j].connect(nGrid[i][j + 1]);
                        }
                    }
                    if (j - 1 >= 0) {
                        if (nGrid[i][j - 1] != null) {
                            nGrid[i][j].connect(nGrid[i][j - 1]);
                        }
                    }
                }
            }
        }
    }

    public void BFS(Node s) {
        tree = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (nGrid[i][j] != null) {
                    nGrid[i][j].reset();
                    tree.put(nGrid[i][j], null);
                }

            }
        }
        if (s != null) {
            s.start(); //color[s] = black, dist[s] = 0
            queue.enqueue(s);
            Node u = null;
//        List<Node> neighbours = null;
            Node[] neighbours = null;
            while (!queue.isEmpty()) {
                u = queue.dequeue();
                neighbours = u.getNeigh();
                for (Node v : neighbours) {
                    if (v != null) {
                        if (v.getColor() == 0) {
                            v.visit(); //color =  black
                            v.incDist(s.getDist()); //dist[v] = dist[u] + 1
//                    tree.put(v, u);
                            v.setPrev(u);
                            queue.enqueue(v);
                        }
                    }
                }
            }
//        return tree;
        }else{
            System.out.println("s = null");
        }
    }

    public Node[][] getNodeGrid() {
        return nGrid;
    }

    public void setMonster(Character m) {
        monster = m;
    }

    public void setPlayer(Character p) {
        player = p;
    }
}
