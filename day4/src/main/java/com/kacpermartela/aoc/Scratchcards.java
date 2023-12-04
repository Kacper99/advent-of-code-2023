package com.kacpermartela.aoc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Scratchcards {


    int points(List<String> input) {
        for (var line: input) {
            var scratchcard = Scratchcard.parse(line);


        }
        return 0;
    }

    record Scratchcard(int cardNumber, List<Integer> winningNumbers, List<Integer> cardNumbers) {
        static Scratchcard parse(String line) {
            String[] nameAndNumbers = line.split(":");

            //Extract name
            String name = nameAndNumbers[0].replace(":", "").strip();
            int cardNumber = Integer.parseInt(name.split(" ")[1]);

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
