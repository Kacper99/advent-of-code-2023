package com.kacpermartela.aoc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CubeConundrumTest {

    @Test
    void part1() throws IOException {
        final var cubeConundrum = new CubeConundrum();
        final var lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        assertThat(cubeConundrum.solve(lines)).isEqualTo(2447);
    }

    @Test
    void part2() throws IOException {
        final var cubeConundrum = new CubeConundrum();
        final var lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        assertThat(cubeConundrum.solve2(lines)).isEqualTo(56322);
    }


    @Test
    void smallTestPart1() {
        final var lines =
                """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """
                        .lines()
                        .toList();
        final var cubeConundrum = new CubeConundrum();
        assertThat(cubeConundrum.solve(lines)).isEqualTo(8);
    }

    @Test
    void smallTestPart2() {
        final var lines =
                """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """
                        .lines()
                        .toList();
        final var cubeConundrum = new CubeConundrum();
        assertThat(cubeConundrum.solve2(lines)).isEqualTo(2286);
    }


    @ParameterizedTest
    @MethodSource("provideTestCases")
    void extractGameId(String input, int expectedId) {
        final var cubeConundrum = new CubeConundrum();
        assertThat(cubeConundrum.extractGameId(input)).isEqualTo(expectedId);
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("Game 1:", 1),
                Arguments.of("Game 2:", 2),
                Arguments.of("Game 3:", 3),
                Arguments.of("Game 32:", 32));
    }
}
