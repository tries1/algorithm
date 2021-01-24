package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            for (Node n : node.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            System.out.print(node.data + " ");
        }
    }

    void dfsR(Node r) {
        if (r == null) {
            return;
        }
        r.marked = true;
        System.out.println(r.data + "\n");

        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void bfs() {
        bfs(0);
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

public class GraphSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        //graph.dfs();
        graph.bfs();
    }
}
