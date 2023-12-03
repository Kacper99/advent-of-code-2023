package com.kacpermartela.aoc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class GearRatiosTest {

    private final GearRatios gearRatios = new GearRatios();

    @Test
    void smallInputExample() {
        var input =
                """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..
                """
                        .lines()
                        .toList();
        assertThat(gearRatios.solve(input)).isEqualTo(4361);
    }

    @Test
    void test() {
        var input = """
                .....
                .123.
                .....
                """
                .lines()
                .toList();
        assertThat(gearRatios.solve(input)).isEqualTo(0);
    }

    @Test
    void test2() {
        var input = """
                .....
                ..123
                .!...
                """
                .lines()
                .toList();
        assertThat(gearRatios.solve(input)).isEqualTo(123);
    }

    @Test
    void test3() {
        var input = """
                .....
                ..123
                .+...
                """
                .lines()
                .toList();
        assertThat(gearRatios.solve(input)).isEqualTo(123);
    }

    @Test
    void part1() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        assertThat(gearRatios.solve(lines)).isEqualTo(529618);
    }
}
