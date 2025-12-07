package com.roy.bissels.aoc2025;

import org.junit.jupiter.api.Test;

import static com.roy.bissels.aoc2025.generic.Utils.getInputList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {
    private static final String RELATIVE_PATH_PREFIX = "07_";
    private static final Day07 Day = new Day07();

    @Test
    void example_part1() throws Exception {
        assertEquals("21", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part1() throws Exception {
        assertEquals("1543", Day.part1(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }

    //count Beams per char end should look like for example :
    //00  .......S.......
    //01  .......1.......
    //02  .......^.......
    //03  ......1.1......
    //04  .....1^2^1.....
    //05  .....1.2.1.....
    //06  ....1^3^3^1....
    //07  ....1.3.3.1....
    //08  ...1^4^331^1...
    //19  ...1.4.331.1...
    //10  ..1^5^434^2^1..
    //11  ..1.5.434.2.1..
    //12  .1^154^74.21^1.
    //13  .1.154.74.21.1.
    //14  1^2^a^b^b^211^1
    //15  1+2+10+11+11+2+1+1+1
    // 6    ...............

    @Test
    void example_part2() throws Exception {
        assertEquals("40", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "example_input.txt")));
    }

    @Test
    void part2() throws Exception {
        assertEquals("3223365367809", Day.part2(getInputList(RELATIVE_PATH_PREFIX + "input.txt")));
    }
}
