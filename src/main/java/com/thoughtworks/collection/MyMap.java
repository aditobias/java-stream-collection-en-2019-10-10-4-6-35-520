package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(x -> x * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(x -> letterList.get(x - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream()
                .map(this::mappingLetters)
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }

    public String mappingLetters(Integer index){
        Integer truePos = index - 1;
        if(index > 26){
           return letterList.get((truePos  / 26) - 1) + letterList.get(truePos % 26);
        }
        return letterList.get(truePos);
    }

}
