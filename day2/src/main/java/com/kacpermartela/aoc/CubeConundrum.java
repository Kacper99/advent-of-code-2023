package com.kacpermartela.aoc;

import java.util.*;

public class CubeConundrum {

    int RED_CUBES = 12;
    int GREEN_CUBES = 13;
    int BLUE_CUBES = 14;

    Map<String, Integer> colourToCube = Map.of(
            "red", RED_CUBES,
            "green", GREEN_CUBES,
            "blue", BLUE_CUBES);

    int solve(List<String> lines) {
        List<Integer> validGameIds = new ArrayList<>();
        for (final var game : lines) {
            boolean gamePossible = true;
            var gameAndHands = game.split(":", 2);
            var gameId = extractGameId(gameAndHands[0]);
            String[] hands = gameAndHands[1].split(";");
            for (final var cubes : hands) {
                String[] hand = cubes.strip().split(",");
                for (String cube : hand) {
                    String[] countAndColour = cube.strip().split(" ");
                    int count = Integer.parseInt(countAndColour[0]);
                    String colour = countAndColour[1].replace(",", "").strip();
                    if (count > colourToCube.get(colour)) {
                        gamePossible = false;
                        break;
                    }
                }
            }
            if (gamePossible) {
                validGameIds.add(gameId);
            }
        }
        return validGameIds.stream().reduce(0, Integer::sum);
    }

    int solve2(List<String> lines) {
        List<Integer> powers = new ArrayList<>();
        for (final var game : lines) {
            Map<String, Integer> minNumberOfColours = new HashMap<>();
            boolean gamePossible = true;
            var gameAndHands = game.split(":", 2);
            var gameId = extractGameId(gameAndHands[0]);
            String[] hands = gameAndHands[1].split(";");
            for (final var cubes : hands) {
                String[] hand = cubes.strip().split(",");
                for (String cube : hand) {
                    String[] countAndColour = cube.strip().split(" ");
                    int count = Integer.parseInt(countAndColour[0]);
                    String colour = countAndColour[1].replace(",", "").strip();
                    minNumberOfColours.compute(colour, (k, v) -> v == null ? count : Math.max(v, count));
                }
            }
            int result = 1;
            for (final var entry : minNumberOfColours.entrySet()) {
                result *= entry.getValue();
            }
            powers.add(result);
        }
        return powers.stream().reduce(0, Integer::sum);
    }

    int extractGameId(String game) {
        return Integer.parseInt(game.replace(":", "").strip().split(" ")[1]);
    }

    record Game(int id, Set<Hand> hands) {}

    record Hand(int redCubes, int blueCubes, int greenCubes) {}
}
