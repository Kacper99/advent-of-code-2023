import java.util.ArrayList;
import java.util.List;

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

}
