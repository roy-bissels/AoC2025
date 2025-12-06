package com.roy.bissels.aoc2025;

import org.junit.jupiter.api.Test;

import static com.roy.bissels.aoc2025.generic.Utils.getInputList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {
    private static final String RELATIVE_PATH_PREFIX = "06_";
    private static final Day06 Day = new Day06();

    @Test
    void example_part1() throws Exception {
        assertEquals("4277556", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals("6171290547579", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    @Test
    void example_part2() throws Exception {
        assertEquals("3263827", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals("8811937976367", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }
}
