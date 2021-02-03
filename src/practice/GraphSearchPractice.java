package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * DFS : 깊이 우선 탐색, 자식의 깊이순서로 탐색하는 그래프, Stack을 사용
 * <p>
 * BFS : 너비 우선 탐색, 자식의 같은레벨의 노드먼저 탐색하는 그래프, Queue 사용
 */
public class GraphSearchPractice {
    public static class Graph {
        class Node {
            int data;
            LinkedList<Node> childrens;
            boolean marked;

            Node(int data) {
                this.data = data;
                this.marked = false;
                childrens = new LinkedList<>();
            }
        }

        Node[] nodes;

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

        void dfs() {
            dfs(0);
        }

        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.marked = true;

            while (!stack.isEmpty()) {
                Node r = stack.pop();

                for (Node n : r.childrens) {
                    if (n.marked == false) {
                        n.marked = true;
                        stack.push(n);
                    }
                }

                visit(r);
            }
        }

        void visit(Node n) {
            System.out.print(n.data + " ");
        }

        void dfsR(Node r) {
            if (r == null) {
                return;
            }

            r.marked = true;
            visit(r);

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

        void dfsR() {
            dfsR(0);
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
                Node r = queue.poll();
                for (Node n : r.childrens) {
                    if (n.marked == false) {
                        n.marked = true;
                        queue.offer(n);
                    }
                }
                visit(r);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        //0 1 3 5 7 6 8 4 2
        g.dfs();
        //g.bfs();
        //g.dfsR();
    }
}
