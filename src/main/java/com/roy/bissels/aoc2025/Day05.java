package com.roy.bissels.aoc2025;

import com.roy.bissels.aoc2025.generic.Utils.LongStartEnd;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Day05 {

    public String part1(List<String> input) {
        Set<LongStartEnd> freshIdRangeSet = new HashSet<>();
        Set<Long> freshIngredientsSet = new HashSet<>();
        for (String line : input) {
            if (line.contains("-")) {
                String[] split = line.split("-");
                freshIdRangeSet.add(new LongStartEnd(Long.parseLong(split[0]), Long.parseLong(split[1])));
            } else if (!line.isBlank()) {
                long availableIngredient = Long.parseLong(line);
                if(freshIdRangeSet.stream()
                        .anyMatch(lp -> lp.start() <= availableIngredient && lp.end() >= availableIngredient))
                    freshIngredientsSet.add(availableIngredient);
            }
        }

        return String.valueOf(freshIngredientsSet.size());
    }

    public String part2(List<String> input) {
        Set<LongStartEnd> freshIdRangeSet = new HashSet<>();
        AtomicLong countFreshIngredients = new AtomicLong();

        for (String line : input) {
            if (!line.contains("-"))
                break;
            String[] split = line.split("-");
            freshIdRangeSet.add(new LongStartEnd(Long.parseLong(split[0]), Long.parseLong(split[1])));
        }
        AtomicReference<LongStartEnd> last = new AtomicReference<>();

        freshIdRangeSet.stream().sorted(Comparator.comparingLong(LongStartEnd::start)).forEach(lp -> {
                if(last.get() == null)
                    last.set(lp);
                else if(last.get().end() < lp.start()) {      //No overlap cause current start is larger than last end
                    countFreshIngredients.addAndGet(last.get().end() - last.get().start() + 1);
                    last.set(lp);
                } else{                                                         //Overlap
                    long newEnd = Math.max(last.get().end(), lp.end());         //Take max End of both ranges
                    last.set(new LongStartEnd(last.get().start(), newEnd));     //Update last
                }
            }
        );

        countFreshIngredients.addAndGet(last.get().end() - last.get().start() + 1); //also add last one!
        return String.valueOf(countFreshIngredients.get());
    }
}