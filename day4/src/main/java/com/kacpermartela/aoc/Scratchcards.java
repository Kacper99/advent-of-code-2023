package com.kacpermartela.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Scratchcards {


    int points(List<String> input) {
        int totalScore = 0;
        for (var line: input) {
            var scratchcard = Scratchcard.parse(line);
            int count = 0;
            for (var number: scratchcard.cardNumbers()) {
                if (scratchcard.winningNumbers().contains(number)) {
                    count++;
                }
            }
            if (count > 0) {
                totalScore += (int) Math.pow(2, count - 1);
            }
            System.out.printf("Score for card %d is %d, totalScore is %d%n", scratchcard.cardNumber(), 2 ^ (count - 1), totalScore);
        }
        return totalScore;
    }

    int points2(List<String> input) {
        int[] counts = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i);
            var scratchcard = Scratchcard.parse(line);
            counts[i]++;
            int count = 0;
            for (var number : scratchcard.cardNumbers()) {
                if (scratchcard.winningNumbers().contains(number)) {
                    count++;
                }
            }
            for (int j = 0; j < count; j++) {
                counts[i + j + 1] += counts[i];
            }
        }
        System.out.println(Arrays.toString(counts));
        return Arrays.stream(counts).sum();
    }

    record Scratchcard(int cardNumber, List<Integer> winningNumbers, List<Integer> cardNumbers) {
        static Scratchcard parse(String line) {
            System.out.println("Parsing line: " + line);
            String[] nameAndNumbers = line.split(":");

            //Extract name
            String name = nameAndNumbers[0].replace(":", "").strip();
            int cardNumber = Integer.parseInt(name.split("\\s+")[1]);

            //Extract winning numbers
            String[] winningAndActualNumbers = nameAndNumbers[1].split("\\|");
            String[] winningNumberStrings = winningAndActualNumbers[0].replace("\\|", "").strip().split("\\s+");
            List<Integer> winningNumbers = Stream.of(winningNumberStrings).mapToInt(Integer::parseInt).boxed().toList();

            //Extract actual numbers
            String[] actualNumberStrings = winningAndActualNumbers[1].strip().split("\\s+");
            List<Integer> actualNumbers = Stream.of(actualNumberStrings).mapToInt(Integer::parseInt).boxed().toList();

            return new Scratchcard(cardNumber, winningNumbers, actualNumbers);
        }
    }
}
