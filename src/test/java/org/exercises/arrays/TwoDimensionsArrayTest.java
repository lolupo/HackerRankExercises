package org.exercises.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoDimensionsArrayTest {

    private final TwoDimensionsArray twoDimensionsArray = new TwoDimensionsArray();

    @Test
    void beTested() {
        assertThat(twoDimensionsArray.execute()).isEqualTo(19);
    }
}
