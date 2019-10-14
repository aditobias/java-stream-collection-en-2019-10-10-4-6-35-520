package com.thoughtworks.collection;

import org.apache.commons.collections.ArrayStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(right, left)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if(left < right){
            return IntStream.rangeClosed(left, right)
                    .boxed()
                    .filter(partOfCollection -> partOfCollection % 2 == 0)
                    .collect(Collectors.toList());
        }
        return IntStream.rangeClosed(right, left)
                .boxed()
                .filter(partOfCollection -> partOfCollection % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .filter(partOfArray -> partOfArray % 2 == 0)
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList =  Arrays.stream(firstArray)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray)
                .boxed()
                .collect(Collectors.toList());

        return firstList.stream()
                .filter(secondList::contains)
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList =  Arrays.stream(firstArray)
                .mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray)
                .mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.toList());

        firstList.addAll(secondList.stream()
                .filter(partOfSecond -> !firstList.contains(partOfSecond))
                .collect(Collectors.toList()));

        return firstList;
    }
}
