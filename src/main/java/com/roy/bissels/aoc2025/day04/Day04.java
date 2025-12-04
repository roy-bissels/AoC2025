package com.roy.bissels.aoc2025.day04;

import java.awt.*;
import java.util.List;
import java.util.Map;

import static com.roy.bissels.aoc2025.generic.Utils.getPointBooleanHashMap;

public class Day04 {

    public String part1(List<String> input) {
        Map<Point, Boolean> isRollmap = getPointBooleanHashMap(input, '@');
        long countRollsWithLessThan4AdjacentRolls = isRollmap.entrySet().stream()
                .filter(entry -> Boolean.TRUE.equals(entry.getValue()) && countAdjacentRolls(entry.getKey(), isRollmap)<4)
                .count();
        return String.valueOf(countRollsWithLessThan4AdjacentRolls);
    }

    public String part2(List<String> input) {
        Map<Point, Boolean> isRollmap = getPointBooleanHashMap(input, '@');
        int totalRemoved = 0;
        boolean nothingRemovedPreviousRun = false;

        while(!nothingRemovedPreviousRun) {
            List<Point> pointsToRemove = isRollmap.entrySet().stream()
                    .filter(entry -> Boolean.TRUE.equals(entry.getValue()) && countAdjacentRolls(entry.getKey(), isRollmap)<4)
                    .map(Map.Entry::getKey).toList();
            pointsToRemove.forEach(isRollmap::remove); //Must be done after, otherwise it will impact the countAdjacentRolls
            totalRemoved += pointsToRemove.size();
            nothingRemovedPreviousRun = pointsToRemove.isEmpty();
        }
        return String.valueOf(totalRemoved);
    }

    public int countAdjacentRolls(Point point, Map<Point, Boolean> isRollmap) {
        int countAdjacentRolls = 0;
        for (int xShift = -1; xShift <= 1; xShift++) {
            for (int yShift = -1; yShift <= 1; yShift++) {
                if (xShift == 0 && yShift == 0) continue;
                Point adjacentPoint = new Point(point.x + xShift, point.y + yShift);
                if (isRollmap.containsKey(adjacentPoint) && isRollmap.get(adjacentPoint))
                    countAdjacentRolls++;
            }
        }
        return countAdjacentRolls;
    }
}