package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Integer minValue = Math.min(leftBorder, rightBorder);
        Integer maxValue = Math.max(leftBorder, rightBorder);

        return IntStream.rangeClosed(minValue, maxValue)
                .filter(partOfArray -> partOfArray % 2 == 0)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Integer minValue = Math.min(leftBorder, rightBorder);
        Integer maxValue = Math.max(leftBorder, rightBorder);

        return IntStream.rangeClosed(minValue, maxValue)
                .filter(partOfArray -> partOfArray % 2 != 0)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(partOfArray -> (partOfArray * 3) + 2)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(a -> a % 2 != 0 ? a * 3 + 2 : a)
                .boxed()
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(a -> a % 2 != 0)
                .mapToInt(a -> (a * 3) + 5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(numberInArray -> numberInArray % 2 == 0)
                .mapToDouble(number -> number)
                .sum() / 2;

    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(partOfArray -> partOfArray % 2 == 0)
                .mapToDouble(a -> a)
                .average()
                .getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
       return arrayList.stream()
               .filter(partOfArray -> partOfArray.equals(specialElment))
               .filter(partyOfArray -> partyOfArray % 2 == 0).count() != 0;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList
                .stream()
                .filter(partOfArray -> partOfArray % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> oddList = arrayList.stream()
                .filter(partOfArray -> partOfArray % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> evenList = arrayList.stream()
                .filter(partOfArray -> partOfArray % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> allList = new ArrayList<>();

        allList.addAll(evenList);
        allList.addAll(oddList);

        return allList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
       List<Integer> result = new ArrayList<>();

       List<Integer> tempList = arrayList.stream().map(a-> a * 3).collect(Collectors.toList());

       tempList.forEach(num -> {

       });

       return null;
    }
}
