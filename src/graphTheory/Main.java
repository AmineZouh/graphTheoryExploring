package graphTheory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> visited1 = new HashSet<>();
        Set<List<Integer>> visited2 = new HashSet<>();
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> clist1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        List<Integer> list3 = List.of(7, 8, 9);
        List<Integer> list4 = List.of(10, 11, 12);
        visited2.add(list1);
        visited2.add(list2);
        visited2.add(list3);
        visited1.add(1+" "+2+" "+3);
        visited1.add(4+" "+5+" "+6);
        visited1.add(7+" "+8+" "+9);
//        System.out.println("Does visited contains s1 ? "+visited1.contains("1 2 3"));
//        System.out.println("Does visited contains s5 ? "+visited1.contains("s5"));
//        System.out.println("Does visited contains s3 ? "+visited1.contains("7 8 9"));
        System.out.println("Does visited contains list1 ? "+visited2.contains(clist1));
        System.out.println("Does visited contains list4 ? "+visited2.contains(list4));
    }
}
