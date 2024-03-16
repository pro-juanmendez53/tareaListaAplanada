package edu.ejercicios.ListaAplanada;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedList;

public class FlattenNestedListExample {
    public static void main (String[] args){
        //Ajustando la estructura segun el orden deseado y usando LinkedList
        List<Object> nestedList = new LinkedList<>(Arrays.asList(
                1, 2, new LinkedList<>(Arrays.asList(
                        3, new LinkedList<>(Arrays.asList(
                                7, new LinkedList<>(Arrays.asList(8, new LinkedList<>(Arrays.asList(11, 12)))),
                                9, 10
                        ))
                )),
                4, 5, 6
        ));
        List<Integer> flatList = flattenList(nestedList);
        printFlatList(flatList);
    }
    @SuppressWarnings("unchecked")
    public static List<Integer> flattenList(List<Object> nestedList) {
        // El método se mantiene sin cambios, funciona igual con LinkedList y ArrayList
        return nestedList.stream()
                .flatMap(o -> {
                    if (o instanceof List) {
                        return flattenList((List<Object>) o).stream();
                    } else {
                        return Stream.of((Integer) o);
                    }
                })
                .collect(Collectors.toList());
    }

    public static void printFlatList(List<Integer> flatList) {
        // El método para imprimir también se mantiene sin cambios
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < flatList.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(flatList.get(i));
        }
        System.out.println(result.toString());
    }
}