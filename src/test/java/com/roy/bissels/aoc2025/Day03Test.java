package com.roy.bissels.aoc2025;

import org.junit.jupiter.api.Test;

import static com.roy.bissels.aoc2025.generic.Utils.getInputList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    private static final String RELATIVE_PATH_PREFIX = "03_";
    private static final Day03 Day = new Day03();

    @Test
    void example_part1() throws Exception {
        assertEquals("357", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals("17493", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    @Test
    void example_part2() throws Exception {
        assertEquals("3121910778619", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals("173685428989126", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

}
