package com.kacpermartela.aoc;

import org.junit.jupiter.api.Test;

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

}