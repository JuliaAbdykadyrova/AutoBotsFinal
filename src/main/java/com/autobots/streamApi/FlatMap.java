package com.autobots.streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {

        List<List<String>> nestedList = List.of(
                List.of("A", "B"),
                List.of("C", "D"),
                List.of("E")
        );

        System.out.println(nestedList);


    List<String> nonNestedList = new ArrayList<>();
for (List<String> list : nestedList){
        for(String s : list){
            nonNestedList.add(s);
        }
    }
System.out.println(nonNestedList);
        System.out.println("_________________");

List<String> nonNestedListWithStream = nestedList.stream()
        .flatMap(List::stream).collect(Collectors.toList());
        System.out.println(nonNestedListWithStream);


    }
}
