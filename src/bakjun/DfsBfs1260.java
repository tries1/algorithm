package bakjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node node1 = nodes[i1];
        Node node2 = nodes[i2];

        if (!node1.adjacent.contains(node2)) {
            node1.adjacent.add(node2);
        }

        if (!node2.adjacent.contains(node1)) {
            node2.adjacent.add(node1);
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        if (r == null) {
            return;
        }
        r.marked = true;
        System.out.print(r.data + " ");

        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n.data);
            }
        }
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node n : node.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.offer(n);
                }
            }
            System.out.print(node.data + " ");
        }
    }
}

public class DfsBfs1260 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        Graph graph2 = new Graph(N);
        Graph graph1 = new Graph(N);

        int a, b;
        for (int i = 0; i < M; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            graph1.addEdge(a, b);
            graph2.addEdge(a, b);
        }*/
        int N = 1000;
        int M = 1;
        int V = 1000;
        Graph graph1 = new Graph(N);
        graph1.addEdge(999, 1000);

        Graph graph2 = new Graph(N);
        graph2.addEdge(999, 1000);

        graph1.dfsR(V);

        System.out.println();

        graph2.bfs(V);
    }
}
