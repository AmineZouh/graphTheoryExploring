package graphTheory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumIslandSize {

    public static int minimumIslandSize(int[][] graphArray){
        Set<List<Integer>> visited = new HashSet<>();
        int rows = graphArray.length;
        int columns = graphArray[0].length;
        int minSize = rows*columns;
        for (int r = 0; r <rows  ; r++) {
            for (int c = 0; c < columns ; c++) {
                int islandSize = exploreSize(graphArray, r, c, visited);
                if(islandSize>0 && islandSize<minSize)
                    minSize=islandSize;
            }
        }
        return minSize;
    }

    private static int exploreSize(int[][] graphArray, int r, int c, Set<List<Integer>>visited) {
        List<Integer> position = List.of(r, c);
        boolean rowInbound = 0<= r && r< graphArray.length;
        boolean columnInbound = 0<= c && c< graphArray[0].length;
        if(!rowInbound || !columnInbound)
            return 0;
        if(graphArray[r][c]=='W')
            return 0;
        if(visited.contains(position))
            return 0;
        visited.add(position);
        int size = 1;
        size+=exploreSize(graphArray, r-1, c, visited);
        size+=exploreSize(graphArray, r+1, c, visited);
        size+=exploreSize(graphArray, r, c-1, visited);
        size+=exploreSize(graphArray, r, c+1, visited);
        return size;
    }


    public static void main(String args[]) {
        int[][] grid = {
                {'W', 'L', 'W', 'W', 'L'},
                {'W', 'L', 'W', 'W', 'L'},
                {'W', 'L', 'W', 'L', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };
        System.out.println("The minimum size of an islands is "+minimumIslandSize(grid));
    }
}
