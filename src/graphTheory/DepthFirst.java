package graphTheory;

import java.util.*;

public class DepthFirst {

//    Iteration version of depthFirstPrint

    public static void depthFirstPrintIteration(Map<Character, char[]> graph, char source){
        Stack<Character> stack = new Stack<>();
        stack.push(source);
        while(!stack.empty()){
            char current = stack.pop();
            System.out.println(current);
            char[] neighbors = graph.get(current);
            for (char neighbor:neighbors) {
                stack.push(neighbor);
            }
        }
    }
// Recursive version of depthFirstPrint

    public static void depthFirstPrintRecursion(Map<Character, char[]> graph, char source) {
        System.out.println(source);
        char[] neighbors = graph.get(source);
        for(char neighbor:neighbors) {
            depthFirstPrintRecursion(graph, neighbor);
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

    public static Map<Integer, List<Integer>> buildGraphInt(int[][] graphArray){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] paire:graphArray) {
            int a = paire[0];
            int b = paire[1];
            if(!graph.containsKey(a))
                graph.put(a, new ArrayList<>());
            if(!graph.containsKey(b))
                graph.put(b, new ArrayList<>());
            List<Integer> paireA = graph.get(a);
            paireA.add(b);
            graph.put(a, paireA);
            List<Integer> paireB = graph.get(b);
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
        Map<Character, char[]> graph = new HashMap<>();
        graph.put('i', new char[]{'j', 'k'});
        graph.put('j', new char[]{'i'});
        graph.put('k', new char[]{'i', 'm', 'l'});
        graph.put('m', new char[]{'k'});
        graph.put('l', new char[]{'k'});
        graph.put('o', new char[]{'n'});
        graph.put('n', new char[]{'o'});
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
//        System.out.println("the solution is "+largestComponent(graph2));
    }
}
