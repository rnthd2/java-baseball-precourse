package service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    static HashSet hashSet = new HashSet();;

    static Stream getValues(){
        List<Integer> number = new ArrayList<>(Arrays.asList(1,2,3));
        hashSet.addAll(number);
        return Stream.of(number.get(0), number.get(1), number.get(2));
    }

    @ParameterizedTest
    @MethodSource("getValues")
    void makeValues(Integer number) {
        assertAll(
                () -> assertThat(hashSet.size() == 3),
                () -> assertNotEquals(number, 0),
                () -> assertTrue(0 < number && number < 10)
        );
    }
}