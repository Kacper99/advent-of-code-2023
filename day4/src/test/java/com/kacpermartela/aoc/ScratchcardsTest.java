package com.kacpermartela.aoc;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScratchcardsTest {

    @Test
    void testParsing() {
        var inputLine = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";

        var scratchcard = Scratchcards.Scratchcard.parse(inputLine);

        assertThat(scratchcard.cardNumber()).isEqualTo(1);
        assertThat(scratchcard.winningNumbers()).containsExactly(41, 48, 83, 86, 17);
        assertThat(scratchcard.cardNumbers()).containsExactly(83, 86,  6, 31, 17,  9, 48, 53);
    }

    @Test
    void smallInputTest() {
        var input = """
                Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
                Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
                Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
                """.lines().toList();

        Scratchcards scratchcards = new Scratchcards();
        assertThat(scratchcards.points(input)).isEqualTo(13);
    }

    @Test
    void part1() throws IOException {
        var inputLines = Files.readAllLines(Path.of("src/test/resources/input.txt"));

        var scratchcards = new Scratchcards();

        assertThat(scratchcards.points(inputLines)).isEqualTo(0);
    }

    @Test
    void part2SmallInput() {
        var input = """
                Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
                Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
                Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
                Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
                Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
                """.lines().toList();

        Scratchcards scratchcards = new Scratchcards();

        assertThat(scratchcards.points2(input)).isEqualTo(30);
    }

    @Test
    void part2() throws IOException {
        var inputLines = Files.readAllLines(Path.of("src/test/resources/input.txt"));

        Scratchcards scratchcards = new Scratchcards();

        assertThat(scratchcards.points2(inputLines)).isEqualTo(5571760);
    }

}