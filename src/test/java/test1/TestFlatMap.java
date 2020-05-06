package test1;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestFlatMap {

    @Test
    public void testFlatMap(){
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<Integer> listB = Arrays.asList(3, 4);

        Stream<Stream<ImmutablePair<Integer, Integer>>> streamStream = listA.stream().map(a -> listB.stream().map(b -> new ImmutablePair<Integer, Integer>(a, b)));
        Stream<ImmutablePair<Integer, Integer>> immutablePairStream = listA.stream().flatMap(a -> listB.stream().map(b -> new ImmutablePair<Integer, Integer>(a, b)));
        listA
                .stream()
                .flatMap(a -> listB.stream().map(b -> new ImmutablePair<Integer, Integer>(a, b)))
                .filter(pair->(pair.getLeft()+pair.getRight())%3==0)
                .forEach(System.out::println);

        listA
                .stream()
                .flatMap(
                        a -> listB.stream()
                                .filter(b-> (a+b)%3==0)
                                .map(b -> new ImmutablePair<Integer, Integer>(a, b))
                ).forEach(System.out::println);

    }
}

