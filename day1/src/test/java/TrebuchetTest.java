import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TrebuchetTest {

    @Test
    void part1() throws IOException {
        final var lines = Files.readAllLines(Path.of("src/test/resources/input.txt"));
        final var trebuchet = new Trebuchet();
        System.out.println(trebuchet.calibrate(lines));
    }

}