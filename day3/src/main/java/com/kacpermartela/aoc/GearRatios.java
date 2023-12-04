package com.kacpermartela.aoc;

import java.util.ArrayList;
import java.util.List;

public class GearRatios {

    int solve(List<String> lines) {
        List<Integer> numbers = new ArrayList<>();

        String[][] schematic = to2DArray(lines);
        for (int i = 0; i < schematic.length; i++) { // Every line
            String[] line = schematic[i];
            String currNumber = "";
            for (int j = 0; j < line.length; j++) {
                char c = line[j].toCharArray()[0];
                if (Character.isDigit(c)) {
                    currNumber += line[j];
                }
                if ((!Character.isDigit(c) && !currNumber.equals(""))) { // Finished building up a number
                    boolean isAdjacent = false;
                    for (int k = Math.max(0, i - 1); k <= Math.min(schematic.length - 1, i + 1); k++) {
                        for (int l = Math.max(0, j - currNumber.length() - 1); l <= j; l++) {
                            if (isSymbolExcludingFullstopAndNumber(schematic[k][l])) {
                                isAdjacent = true;
                                break;
                            }
                        }
                    }
                    if (isAdjacent) {
                        numbers.add(Integer.parseInt(currNumber));
                    }
                    currNumber = "";
                }
            }
            if (!currNumber.equals("")) { //End of line
                boolean isAdjacent = false;
                for (int k = Math.max(0, i - 1); k <= Math.min(schematic.length - 1, i + 1); k++) {
                    for (int l = Math.max(0, line.length - currNumber.length() - 1); l < line.length; l++) {
                        if (isSymbolExcludingFullstopAndNumber(schematic[k][l])) {
                            isAdjacent = true;
                            break;
                        }
                    }
                }
                if (isAdjacent) {
                    numbers.add(Integer.parseInt(currNumber));
                }
                currNumber = "";
            }
        }
        System.out.println(numbers);
        return numbers.stream().reduce(0, Integer::sum);
    }

    String[][] to2DArray(List<String> lines) {
        String[][] array = new String[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            array[i] = lines.get(i).split("");
        }
        return array;
    }

    boolean isSymbolExcludingFullstopAndNumber(String s) {
        return s.matches("[^0-9.]");
    }
}
