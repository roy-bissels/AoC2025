package com.roy.bissels.aoc2025;

import org.junit.jupiter.api.Test;

import static com.roy.bissels.aoc2025.generic.Utils.getInputList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {

    private static final String RELATIVE_PATH_PREFIX = "05_";
    private static final Day05 Day = new Day05();

    @Test
    void example_part1() throws Exception {
        assertEquals("3", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals("707", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    @Test
    void example_part2() throws Exception {
        assertEquals("14", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void example_part2_2() throws Exception {
        assertEquals("16", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "example_input_2.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals("361615643045059",Day.part2(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

}
