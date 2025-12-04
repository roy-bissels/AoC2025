package com.roy.bissels.aoc2025.day01;

import java.util.List;


public class Day01{
    public static final int MAX_NUMBER = 100;

    public String part1(List<String> input) {
        int count0 = 0;
        int currentNumber = 50;
        for (String line : input) {
            currentNumber = Math.floorMod(getResult(currentNumber, getDirection(line), getNumberOfSteps(line)), MAX_NUMBER);
            if(currentNumber==0) count0++;
        }
        return String.valueOf(count0);
    }

    public String part2(List<String> input) {
        int count0 = 0;
        int currentNumber = 50;
        for (String line : input) {
            int result = getResult(currentNumber, getDirection(line), getNumberOfSteps(line));
            count0 += calculateCount0Plus(currentNumber, result, MAX_NUMBER);
            currentNumber = Math.floorMod(result, MAX_NUMBER);
        }
        return String.valueOf(count0);
    }

    private static int getResult(int startNumber, String direction, int numberOfSteps) {
        return switch (direction) {
            case "L" -> startNumber - numberOfSteps;
            case "R" -> (startNumber + numberOfSteps);
            default -> throw new IllegalArgumentException("Unexpected value: " + direction);
        };
    }

    protected int calculateCount0Plus(int startNumber, int result, int maxNumber) {
        if(result==0) return 1;

        double divided = result / (double) maxNumber;
        int count0Plus = Math.abs((int)Math.floor(divided));
        count0Plus = startNumber == 0  && divided < 0 ? count0Plus -1 : count0Plus;

        if(result % 100==0 && result <0) count0Plus++;

        return count0Plus;
    }

    private static Integer getNumberOfSteps(String line) {
        return Integer.parseInt(line.substring(1));
    }

    private static String getDirection(String line) {
        return line.substring(0, 1);
    }
}