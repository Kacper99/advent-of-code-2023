package com.kacpermartela.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trebuchet {

    int calibrate(List<String> lines) {
        List<Integer> nums = new ArrayList<>();
        for (final var line : lines) {
            String digits = line.replaceAll("\\D+", "");
            String firstDigit = String.valueOf(digits.charAt(0));
            String lastDigit = String.valueOf(digits.charAt(digits.length() - 1));
            int number = Integer.parseInt(firstDigit + lastDigit);
            nums.add(number);
        }
        return nums.stream().reduce(0, Integer::sum);
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
            for (final var entry : wordToNumber.entrySet()) {
                line = line.replaceAll(entry.getKey(), entry.getValue());
            }
            String digits = line.replaceAll("\\D+", "");
            String firstDigit = String.valueOf(digits.charAt(0));
            String lastDigit = String.valueOf(digits.charAt(digits.length() - 1));
            int number = Integer.parseInt(firstDigit + lastDigit);
            nums.add(number);
        }
        return nums.stream().reduce(0, Integer::sum);
    }
}
