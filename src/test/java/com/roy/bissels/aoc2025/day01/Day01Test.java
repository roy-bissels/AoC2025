package com.roy.bissels.aoc2025.day01;

import org.junit.jupiter.api.Test;

import static com.roy.bissels.aoc2025.generic.Utils.getInputList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    private static final String RELATIVE_PATH_PREFIX = "Day01/";
    private static final Day01 Day = new Day01();

    @Test
    void example_part1() throws Exception {
        assertEquals("3", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals("1168", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    @Test
    void example_part2() throws Exception {
        assertEquals("6", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals("7199", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    @Test
    void calculateCount0PlusDebug()
    {
        int result;

        Day01 day01 = new Day01();
        result = day01.calculateCount0Plus(50, 900, 100);
        assertEquals(9, result);

        result = day01.calculateCount0Plus(0, -373, 100);
        assertEquals(3, result);

        result = day01.calculateCount0Plus(0, 100, 100);
        assertEquals(1, result);

        result = day01.calculateCount0Plus(54, 600, 100);
        assertEquals(6, result);

        //start 21, current 43, Instruction L578, count0_start 322, end 328
        result = day01.calculateCount0Plus(21, -557, 100);
        assertEquals(6, result);

//        start 0, current 51, Instruction R751, count0_start 330, end 337
        result = day01.calculateCount0Plus(0, 751, 100);
        assertEquals(7, result);


        //start 45, current 0, Instruction L645, count0_start 750, end 756
        result = day01.calculateCount0Plus(45, -600, 100);
        assertEquals(7, result);
    }

    @Test
    void testEdgeCase(){
        int result;
        //start 45, current 0, Instruction L645, count0_start 750, end 756
        result = new Day01().calculateCount0Plus(45, -600, 100);
        assertEquals(7, result);
    }
}
