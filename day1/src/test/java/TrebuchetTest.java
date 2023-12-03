import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TrebuchetTest {

    @Test
    void part1() throws IOException {
        final var lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        final var trebuchet = new Trebuchet();
        System.out.println(trebuchet.calibrate(lines));
    }

    @Test
    void part2() throws IOException {
        final var lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        final var trebuchet = new Trebuchet();
        System.out.println(trebuchet.calibrate2(lines));
    }

    @Test
    void part2small() throws IOException {
        final var lines = List.of(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"
        );
        final var trebuchet = new Trebuchet();
        System.out.println(trebuchet.calibrate2(lines));
    }

}