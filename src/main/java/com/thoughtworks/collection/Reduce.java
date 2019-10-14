package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                .reduce((n,v) -> n > v ? n : v)
                .orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream()
                .reduce((n,v) -> n < v ? n : v)
                .orElse(0);
    }

    public double getAverage() {
        return arrayList
                .stream()
                .reduce(Integer::sum)
                .map(Integer::doubleValue)
                .map(number -> number / arrayList.size())
                .get();
    }

    public double getOrderedMedian() {
       return arrayList.stream()
               .sorted()
               .map(number -> {
                   if(arrayList.size() % 2 == 0){
                       return arrayList.get(arrayList.size() + 1 / 2) + arrayList.get((arrayList.size() - 1) / 2);
                   }else{
                       return arrayList.get((arrayList.size() + 1) / 2);
                   }
               })
               .mapToDouble(Integer::doubleValue)
               .reduce((a,b) -> b/2)
               .getAsDouble();
    }

    public int getFirstEven() {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .findFirst()
                .orElse(0);
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(arrayList.stream()
                .filter(number -> number % 2 == 0)
                .findFirst()
                .orElse(0));

    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        return arrayList.stream()
                .reduce((first, second) -> second)
                .orElse(null);
    }

    public int getIndexOfLastOdd() {
        return null
    }
}
