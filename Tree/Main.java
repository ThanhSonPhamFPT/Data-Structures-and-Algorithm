import implementations.Tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree =
                new Tree<Integer>(7,
                        new Tree<>(19,
                                new Tree<>(1),
                                new Tree<>(12),
                                new Tree<>(31)),
                        new Tree<>(21),
                        new Tree<>(14,
                                new Tree<>(23),
                                new Tree<Integer>(6))
                );
        System.out.println("BFS:");
        List<Integer> myList = tree.orderBfs();
        for (Integer i:myList){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("DFS:");
        List<Integer> myList2 = tree.orderDfs();
        for (Integer i:myList2){
            System.out.print(i+" ");
        }
        Tree<Integer> addedTree = new Tree<>(40);
        tree.addChild(19,addedTree);
        System.out.println();
        System.out.println("BFS:");
         myList = tree.orderBfs();
        for (Integer i:myList){
            System.out.print(i+" ");
        }
        addedTree = new Tree<>(50);
        tree.addChild(7,addedTree);
        System.out.println();
        System.out.println("BFS:");
        myList = tree.orderBfs();
        for (Integer i:myList){
            System.out.print(i+" ");
        }
        tree.removeNode(19);
        System.out.println();
        System.out.println("BFS:");
        myList = tree.orderBfs();
        for (Integer i:myList){
            System.out.print(i+" ");
        }
    }
}
