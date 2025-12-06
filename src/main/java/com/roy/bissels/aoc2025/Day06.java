package com.roy.bissels.aoc2025;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day06
{
    public String part1(List<String> input) {
        Map<Point, String> inputMap = new HashMap<>();
        int numberOfLines = input.size();
        int numberOfProblems = 0;
        long totalSolutions = 0;
        for(int y = 0; y < numberOfLines; y++){
            String[] split = input.get(y).strip().split("\\s+");
            numberOfProblems = split.length;
            for(int x = 0 ; x < split.length ; x++){
                inputMap.put(new Point(x, y), split[x]);
            }
        }

        for(int x = 0; x < numberOfProblems; x++){
            String instruction = inputMap.get(new Point(x, numberOfLines - 1));
            long solution = Long.parseLong(inputMap.get(new Point(x,0)));
            for(int y = 1; y < numberOfLines - 1; y++){
                solution = instruction.equals("+") ?
                        Math.addExact(solution, Long.parseLong(inputMap.get(new Point(x,y)))) :
                        Math.multiplyExact(solution, Long.parseLong(inputMap.get(new Point(x,y))));
            }
            totalSolutions += solution;
        }
        return String.valueOf(totalSolutions);
    }

    public String part2(List<String> input) {
        Map<Point, Character> inputMap = new HashMap<>();
        int numberOfLines = input.size();
        int maxLength = 0;
        long totalSolutions = 0;
        for(int y = 0; y < numberOfLines; y++){
            char[] charArray = input.get(y).toCharArray();
            maxLength = Math.max(charArray.length, maxLength);
            for(int x = 0 ; x < charArray.length ; x++){
                inputMap.put(new Point(x, y), charArray[x]);
            }
        }

        Character lastInstruction = null;
        Long totalForInstructionAndNumbers = null;
        for(int x = 0; x < maxLength; x++){
            Character instructionRowChar = inputMap.get(new Point(x, numberOfLines - 1));
            lastInstruction = instructionRowChar == null || instructionRowChar.toString().isBlank() ? lastInstruction : instructionRowChar;
            StringBuilder numberString = new StringBuilder();
            for(int y = 0; y < numberOfLines-1; y++){
                Character charToAppend = inputMap.get(new Point(x, y)) != null ? inputMap.get(new Point(x, y)) : ' ';
                numberString.append(charToAppend);
            }
            if(numberString.toString().isBlank()) {
                totalSolutions += totalForInstructionAndNumbers;
                totalForInstructionAndNumbers = null;
            }
            else if(totalForInstructionAndNumbers == null) {
                totalForInstructionAndNumbers = Long.parseLong(numberString.toString().strip());
            } else {
                IO.println("totalForInstructionAndNumbers : " + totalForInstructionAndNumbers + " instruction : " + lastInstruction + " numberString : " + numberString);
                totalForInstructionAndNumbers = lastInstruction.equals('+') ?
                        Math.addExact(totalForInstructionAndNumbers, Long.parseLong(numberString.toString().strip())) :
                        Math.multiplyExact(totalForInstructionAndNumbers, Long.parseLong(numberString.toString().strip()));
            }
        }

        totalSolutions += totalForInstructionAndNumbers;

        return String.valueOf(totalSolutions);
    }
}