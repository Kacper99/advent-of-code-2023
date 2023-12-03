package com.kacpermartela.aoc;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class TrebuchetTest {

    @Test
    void part1() throws IOException {
        final var lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        final var trebuchet = new Trebuchet();
        assertThat(trebuchet.calibrate(lines)).isEqualTo(54990);
    }

    @Test
    void part1_stream() throws IOException {
        final var lines = Files.lines(Path.of("src/test/resources/input.txt"));
        final var trebuchet = new Trebuchet();
        assertThat(trebuchet.calibrate(lines)).isEqualTo(54990);
    }

    @Test
    void part2() throws IOException {
        final var lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        final var trebuchet = new Trebuchet();
        assertThat(trebuchet.calibrate2(lines)).isEqualTo(54473);
    }

    @Test
    void part2_stream() throws IOException {
        final var lines = Files.lines(Path.of("src/test/resources/input.txt"));
        final var trebuchet = new Trebuchet();
        assertThat(trebuchet.calibrate2(lines)).isEqualTo(54473);
    }

    @Test
    void part2small() {
        final var lines = List.of(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen");
        final var trebuchet = new Trebuchet();
        System.out.println(trebuchet.calibrate2(lines));
    }
}
