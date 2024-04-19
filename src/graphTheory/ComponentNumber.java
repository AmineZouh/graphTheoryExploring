package graphTheory;

import java.util.*;

public class ComponentNumber {

    public static int numberOfComponents(Map<Integer, List<Integer>> graph){
        int c = 0;
        Set<Integer> visited = new HashSet<>();
        for (int n:graph.keySet()) {
            if(explore(graph, n, visited))
                c++;
        }
        return c;
    }

    public static boolean explore(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        if(visited.contains(node))
            return false;
        visited.add(node);
        for (int neighbor:graph.get(node)) {
            explore(graph, neighbor, visited);
        }
        return true;
    }

    public static void main(String args[]){
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, new ArrayList<>(Arrays.asList(8, 1, 5)));
        graph2.put(1, new ArrayList<>(Arrays.asList(0)));
        graph2.put(5, new ArrayList<>(Arrays.asList(8, 0)));
        graph2.put(8, new ArrayList<>(Arrays.asList(0, 5)));
        graph2.put(2, new ArrayList<>(Arrays.asList(3, 4)));
        graph2.put(3, new ArrayList<>(Arrays.asList(2, 4)));
        graph2.put(4, new ArrayList<>(Arrays.asList(3, 2)));
        int[][] graphIntArray = {
                {0, 8},
                {0, 1},
                {0, 5},
                {8, 5},
                {2, 3},
                {2, 4},
                {3, 4}
        };
        char[][] graphArray = {
                {'i', 'j'},
                {'i', 'k'},
                {'m', 'k'},
                {'l', 'k'},
                {'o', 'n'}
        };
        Map<Character, char[]> graph1 = new HashMap<>();
        graph1.put('i', new char[]{'j', 'k'});
        graph1.put('j', new char[]{'i'});
        graph1.put('k', new char[]{'i', 'm', 'l'});
        graph1.put('m', new char[]{'k'});
        graph1.put('l', new char[]{'k'});
        graph1.put('o', new char[]{'n'});
        graph1.put('n', new char[]{'o'});



//        depthFirstPrintIteration(graph, 'a');
//        depthFirstPrintRecursion(graph, 'a');
//        breadthFirstPrint(graph, 'a');
//        System.out.println("the solution is "+hasPath(graph, 'f', 'j'));
//        System.out.println("the solution is "+hasPathBreadthFirst(graph, 'f', 'h'));
//        System.out.println("the solution is "+undirectedPath(graphArray, 'i', 'l'));
//        System.out.println("the number of components is "+numberOfComponents(graph2));
    }
}
