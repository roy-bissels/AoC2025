package com.roy.bissels.aoc2025.generic;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Utils {
    
    public static List<String> getInputList(String relativePath) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource(relativePath)).toURI());
        return Files.readAllLines(path);
    }

    public static String getInput(String relativePath) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource(relativePath)).toURI());
        return Files.readString(path);
    }

    public static Map<Point, Boolean> getPointBooleanHashMap(List<String> input, Character character) {
        HashMap<Point, Boolean> isRollmap = new HashMap<>();
        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            for (int x = 0; x < line.length(); x++) {
                isRollmap.put(new Point(x,y), line.charAt(x)==character);
            }
        }
        return isRollmap;
    }
}