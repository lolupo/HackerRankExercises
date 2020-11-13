package org.exercises.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoDimensionsArrayTest {

    private final TwoDimensionsArray subject = new TwoDimensionsArray();

    @Test
    void test() {
        assertThat(subject.execute()).isEqualTo(19);
    }
}
