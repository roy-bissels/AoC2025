package com.roy.bissels.aoc2025;

import org.junit.jupiter.api.Test;

import static com.roy.bissels.aoc2025.generic.Utils.getInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
    private static final String RELATIVE_PATH_PREFIX = "02_";
    private static final Day02 Day = new Day02();

    @Test
    void example_part1() throws Exception {
        assertEquals("1227775554", Day.part1(getInput(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals("52316131093", Day.part1(getInput(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    @Test
    void example_part2() throws Exception {
        assertEquals("4174379265", Day.part2(getInput(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals("69564213293", Day.part2(getInput(RELATIVE_PATH_PREFIX + "input.txt")));
    }
}
