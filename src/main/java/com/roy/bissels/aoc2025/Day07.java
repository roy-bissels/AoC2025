package com.roy.bissels.aoc2025;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Day07
{
    public long numberOfTimelines = 0;

    public String part1(List<String> input) {
        int numberOfLines = input.size();
        long countSplittersUsed = 0;

        //handle first two rows
        int xPositionStart = input.get(0).indexOf("S");
        char[] secondRow = input.get(1).toCharArray();
        secondRow[xPositionStart] = '|';

        input.set(1, String.valueOf(secondRow));
        String previousRow = String.valueOf(secondRow);

        for(int y = 2; y < numberOfLines-1; y++){
            String finalPreviousRow = previousRow;
            List<Integer> xPositionBeamPrevRow = IntStream.range(0, previousRow.length())
                    .filter(i -> finalPreviousRow.charAt(i) == '|').boxed().toList();


            char[] currentCharRow = input.get(y).toCharArray();
            for(int xPosition : xPositionBeamPrevRow){
                if(currentCharRow[xPosition] == '.'){
                    currentCharRow[xPosition] = '|';
                } else if (currentCharRow[xPosition] == '^') {
                    countSplittersUsed++;
                    currentCharRow[xPosition-1] = '|';
                    currentCharRow[xPosition+1] = '|';
                }
            }
            input.set(y, String.valueOf(currentCharRow));
            previousRow = String.valueOf(currentCharRow);
        }

        return String.valueOf(countSplittersUsed);
    }

    public String part2(List<String> input) {
        int numberOfLines = input.size();

        //handle first two rows
        int xPositionStart = input.get(0).indexOf("S");
        char[] secondRow = input.get(1).toCharArray();
        secondRow[xPositionStart] = '|';

        input.set(1, String.valueOf(secondRow));
        String previousRow = String.valueOf(secondRow);
        Map<Integer, Long> previousRowBeamCount = new HashMap<>();
        previousRowBeamCount.put(xPositionStart, 1L);

        for(int y = 2; y < numberOfLines -1; y++){
            String finalPreviousRow = previousRow;
            Map<Integer, Long> currentRowBeamCount = new HashMap<>(previousRowBeamCount);

            List<Integer> xPositionBeamPrevRow = IntStream.range(0, previousRow.length())
                    .filter(i -> finalPreviousRow.charAt(i) == '|').boxed().toList();

            char[] currentCharRow = input.get(y).toCharArray();
            for(int xPosition : xPositionBeamPrevRow){
                if(currentCharRow[xPosition] == '.'){
                    currentCharRow[xPosition] = '|';
                    currentRowBeamCount.put(xPosition, currentRowBeamCount.getOrDefault(xPosition, 0L));
                } else if (currentCharRow[xPosition] == '^') {
                    currentCharRow[xPosition-1] = '|';
                    currentRowBeamCount.put(xPosition-1, currentRowBeamCount.getOrDefault(xPosition-1, 0L) + currentRowBeamCount.get(xPosition));

                    currentCharRow[xPosition+1] = '|';
                    currentRowBeamCount.put(xPosition+1, currentRowBeamCount.getOrDefault(xPosition+1, 0L) + currentRowBeamCount.get(xPosition));

                    currentRowBeamCount.remove(xPosition);
                }
            }
            input.set(y, String.valueOf(currentCharRow));
            previousRow = String.valueOf(currentCharRow);
            previousRowBeamCount = new HashMap<>(currentRowBeamCount);
        }

        return String.valueOf(previousRowBeamCount.values().stream().mapToLong(Long::longValue).sum());
    }

    private void countTimeLinesRecursiveStackOverflowError(List<String> input, int numberOfLines, String previousRow) {
        for(int y = 2; y < numberOfLines -1; y++){
            IO.println("y : " + y);
            String currentRow = input.get(y);
            List<Integer> xPositionBeamPrevRow = IntStream.range(0, previousRow.length())
                    .filter(i -> previousRow.charAt(i) == '|').boxed().toList();

            char[] currentCharRow = currentRow.toCharArray();
            for(int xPosition : xPositionBeamPrevRow){
                if(currentRow.charAt(xPosition) == '.'){
                    currentCharRow[xPosition] = '|';
                } else if (currentRow.charAt(xPosition) == '^') {
                    char[] leftCharRow = currentCharRow.clone();
                    leftCharRow[xPosition-1] = '|';
                    countTimeLinesRecursiveStackOverflowError(input, numberOfLines, String.valueOf(leftCharRow));

                    char[] rightCharRow = currentCharRow.clone();
                    rightCharRow[xPosition+1] = '|';
                    countTimeLinesRecursiveStackOverflowError(input, numberOfLines, String.valueOf(rightCharRow));
                }
            }
            if(y==numberOfLines-1)
                numberOfTimelines++;
        }
    }
}