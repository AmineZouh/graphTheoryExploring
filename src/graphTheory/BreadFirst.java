package graphTheory;

import java.util.*;

public class BreadFirst {

    public static void breadthFirstPrint(Map<Character, char[]> graph, char source){
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            char current = queue.poll();
            System.out.println(current);
            char[] neighbors = graph.get(current);
            for (char neighbor:neighbors) {
                queue.add(neighbor);
            }
        }
    }



    public static Map<Character, List<Character>> buildGraph(char[][] graphArray){
        Map<Character, List<Character>> graph = new HashMap<>();
        for (char[] paire:graphArray) {
            char a = paire[0];
            char b = paire[1];
            if(!graph.containsKey(a))
                graph.put(a, new ArrayList<>());
            if(!graph.containsKey(b))
                graph.put(b, new ArrayList<>());
            List<Character> paireA = graph.get(a);
            paireA.add(b);
            graph.put(a, paireA);
            List<Character> paireB = graph.get(b);
            paireB.add(a);
            graph.put(b, paireB);
        }
        return graph;
    }



    public static void main(String args[]){
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
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, new ArrayList<>(Arrays.asList(8, 1, 5)));
        graph2.put(1, new ArrayList<>(Arrays.asList(0)));
        graph2.put(5, new ArrayList<>(Arrays.asList(8, 0)));
        graph2.put(8, new ArrayList<>(Arrays.asList(0, 5)));
        graph2.put(2, new ArrayList<>(Arrays.asList(3, 4)));
        graph2.put(3, new ArrayList<>(Arrays.asList(2, 4)));
        graph2.put(4, new ArrayList<>(Arrays.asList(3, 2)));


//        depthFirstPrintIteration(graph, 'a');
//        depthFirstPrintRecursion(graph, 'a');
//        breadthFirstPrint(graph, 'a');
//        System.out.println("the solution is "+hasPath(graph, 'f', 'j'));
//        System.out.println("the solution is "+hasPathBreadthFirst(graph, 'f', 'h'));
//        System.out.println("the solution is "+undirectedPath(graphArray, 'i', 'l'));
//        System.out.println("the number of components is "+numberOfComponents(graph2));
    }
}
