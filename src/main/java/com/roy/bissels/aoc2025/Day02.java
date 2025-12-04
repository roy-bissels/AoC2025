package com.roy.bissels.aoc2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02
{
    public String part1(String input) {
        return getSolution(input, 1);
    }

    public String part2(String input) {
        return getSolution(input, 2);
    }

    private String getSolution(String input, int part) {
        List<LongPoint> idRangedInput = Arrays.stream(input.split(","))
                .map(s -> new LongPoint(Long.parseLong(s.split("-")[0]), Long.parseLong(s.split("-")[1]))).toList();
        List<Long> invalidIds = idRangedInput.stream().map(lp -> getInvalidIdsFromRange(lp, part)).flatMap(List::stream).toList();

        return String.valueOf(invalidIds.stream().mapToLong(Long::longValue).sum());
    }

    private List<Long> getInvalidIdsFromRange(LongPoint range, int part)
    {
        List<Long> invalidIds = new ArrayList<>();
        for (long i = range.x; i <= range.y; i++) {
            String stringValue = String.valueOf(i);
            int length = stringValue.length();

            switch (part) {
                case 1 -> invalidForPart1(length, stringValue, invalidIds, i);
                case 2 -> invalidForPart2(length, stringValue, invalidIds, i);}
        }
        return invalidIds;
    }

    private static void invalidForPart1(int length, String stringValue, List<Long> invalidIds, long i) {
        if (length % 2 == 0) {
            String firstHalf = stringValue.substring(0, length / 2);
            String secondHalf = stringValue.substring(length / 2);
            if(firstHalf.equals(secondHalf))
                invalidIds.add(i);
        }
    }

    private static void invalidForPart2(int length, String stringValue, List<Long> invalidIds, long i) {
        for(int subStringLength = 1; subStringLength < length /2+1; subStringLength++) {
            String repeatedSubStringTest = stringValue.substring(0, subStringLength);
            if (stringValue.split(repeatedSubStringTest).length==0){
                invalidIds.add(i);
                break;
            }
        }
    }

    public record LongPoint(long x, long y){}
}