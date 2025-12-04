package com.roy.bissels.aoc2025.day03;

import java.util.ArrayList;
import java.util.List;

public class Day03 {

    public String part1(List<String> input) {
        return String.valueOf(input.stream().mapToLong(line -> getHighestJoltageForLine(line, 2)).sum());
    }

    public String part2(List<String> input) {
        return String.valueOf(input.stream().mapToLong(line -> getHighestJoltageForLine(line, 12)).sum());
    }

    public long getHighestJoltageForLine(String input, int minimumNumbersLeftOver){
        ArrayList<String> maxNumbers = new ArrayList<>();

        while(minimumNumbersLeftOver > 0){
            String max = String.valueOf(
                    input.substring(0, input.length() - --minimumNumbersLeftOver).chars()
                    .mapToObj(Character::toChars)
                    .mapToInt(value -> Integer.parseInt(new String(value)))
                    .max().getAsInt());

            input = input.substring(input.indexOf(max) + 1);
            maxNumbers.add(max);}

        return Long.parseLong(String.join("", maxNumbers));
    }
}