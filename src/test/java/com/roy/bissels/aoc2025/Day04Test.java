package com.roy.bissels.aoc2025;

import org.junit.jupiter.api.Test;

import static com.roy.bissels.aoc2025.generic.Utils.getInputList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    private static final String RELATIVE_PATH_PREFIX = "04_";
    private static final Day04 Day = new Day04();

    @Test
    void example_part1() throws Exception {
        assertEquals("13", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals("1356", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    @Test
    void example_part2() throws Exception {
        assertEquals("43", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals("8713",Day.part2(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

}
