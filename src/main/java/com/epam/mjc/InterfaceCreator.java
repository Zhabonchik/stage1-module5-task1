package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean flag = true;
            for (String s : x){
                if (!Character.isUpperCase(s.charAt(0))) {
                    flag = false;
                    break;
                }
            }
            return flag;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List <Integer> list = new ArrayList<>();
            for (Integer item : x){
                if (item % 2 == 0){
                    list.add(item);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> newList = new ArrayList<>();
            for (String item : values){
                if (Character.isUpperCase(item.charAt(0)) && item.endsWith(".") && item.chars().filter(ch -> ch == ' ').count() > 2){
                    newList.add(item);
                }
            }
            return newList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map <String, Integer> map = new HashMap<>();
            for (String item : x) {
                map.put(item, item.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return new ArrayList<>(list1);
        };
    }
}
