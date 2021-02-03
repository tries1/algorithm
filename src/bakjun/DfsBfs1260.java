package bakjun;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class DfsBfs1260 {
    public static class Graph {
        class Node implements Comparable<Node> {
            int data;
            LinkedList<Node> childrens;
            boolean marked;

            Node(int data) {
                this.data = data;
                this.marked = false;
                childrens = new LinkedList<>();
            }

            @Override
            public int compareTo(Node o) {
                if (this.data >= o.data) {
                    return 1;
                } else if (this.data < o.data) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        Node[] nodes;
        StringBuffer result = new StringBuffer();

        Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i, int j) {
            Node n1 = nodes[i];
            Node n2 = nodes[j];

            if (!n1.childrens.contains(n2)) {
                n1.childrens.add(n2);
            }

            if (!n2.childrens.contains(n1)) {
                n2.childrens.add(n1);
            }
        }

        void dfsR(Node r) {
            if (r == null) {
                return;
            }

            r.marked = true;
            visit(r);

            if (0 == r.childrens.stream()
                    .filter(node -> node.marked == false)
                    .count()) {
                System.out.println(this.result.toString().trim());
            }

            Collections.sort(r.childrens);
            for (Node n : r.childrens) {
                if (n.marked == false) {
                    dfsR(n);
                }
            }
        }

        void dfsR(int index) {
            Node r = nodes[index];
            dfsR(r);
        }

        void visit(Node n) {
            this.result.append(n.data + " ");
        }

        void bfs(int index) {
            Node root = nodes[index];
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            root.marked = true;

            while (!queue.isEmpty()) {
                Node r = queue.poll();

                Collections.sort(r.childrens);
                for (Node n : r.childrens) {
                    if (n.marked == false) {
                        n.marked = true;
                        queue.offer(n);
                    }
                }
                visit(r);
            }

            System.out.println(this.result.toString().trim());
        }
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int V = Integer.parseInt(firstLine[2]);

        Graph graph2 = new Graph(N + 1);
        Graph graph1 = new Graph(N + 1);

        int a, b;
        String[] egdeLine;
        for (int i = 1; i <= M; i++) {
            egdeLine = sc.nextLine().split(" ");
            a = Integer.parseInt(egdeLine[0]);
            b = Integer.parseInt(egdeLine[1]);
            graph1.addEdge(a, b);
            graph2.addEdge(a, b);
        }*/
        /*int N = 1000;
        int M = 1;
        int V = 1000;
        Graph graph1 = new Graph(N + 1);
        Graph graph2 = new Graph(N + 1);
        graph1.addEdge(999, 1000);

        graph2.addEdge(999, 1000);*/

        /*int N = 5;
        int M = 5;
        int V = 3;
        Graph graph1 = new Graph(N + 1);
        Graph graph2 = new Graph(N + 1);
        graph1.addEdge(5, 4);
        graph1.addEdge(5, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(3, 4);
        graph1.addEdge(3, 1);

        graph2.addEdge(5, 4);
        graph2.addEdge(5, 2);
        graph2.addEdge(1, 2);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 1);*/

        int N = 4;
        int M = 4;
        int V = 1;
        Graph graph1 = new Graph(N + 1);
        Graph graph2 = new Graph(N + 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(4, 1);

        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(4, 1);

        graph1.dfsR(V);
        graph2.bfs(V);
    }
}
