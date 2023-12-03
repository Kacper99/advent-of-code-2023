package com.kacpermartela.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Trebuchet {

    int calibrate(List<String> lines) {
        List<Integer> nums = new ArrayList<>();
        for (final var line : lines) {
            nums.add(getNumber(line));
        }
        return nums.stream().reduce(0, Integer::sum);
    }

    private static int getNumber(String line) {
        String digits = line.replaceAll("\\D+", "");
        String firstDigit = String.valueOf(digits.charAt(0));
        String lastDigit = String.valueOf(digits.charAt(digits.length() - 1));
        return Integer.parseInt(firstDigit + lastDigit);
    }

    int calibrate(Stream<String> lines) {
        return lines.map(Trebuchet::getNumber).reduce(0, Integer::sum);
    }

    final Map<String, String> wordToNumber = Map.of(
            "one", "one1one",
            "two", "two2two",
            "three", "three3three",
            "four", "four4four",
            "five", "five5five",
            "six", "six6six",
            "seven", "seven7seven",
            "eight", "eight8eight",
            "nine", "nine9nine");

    int calibrate2(List<String> lines) {
        List<Integer> nums = new ArrayList<>();
        for (var line : lines) {
            line = replaceWordsWithNumbers(line);
            nums.add(getNumber(line));
        }
        return nums.stream().reduce(0, Integer::sum);
    }

    int calibrate2(Stream<String> lines) {
        return lines.map(this::replaceWordsWithNumbers)
                .map(Trebuchet::getNumber)
                .reduce(0, Integer::sum);
    }

    private String replaceWordsWithNumbers(String line) {
        for (final var entry : wordToNumber.entrySet()) {
            line = line.replaceAll(entry.getKey(), entry.getValue());
        }
        return line;
    }
}
