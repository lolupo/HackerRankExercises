package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RepeatedStringTest {

    private final RepeatedString repeatedString = new RepeatedString();

    @Test
    void beTested() {
        assertThat(repeatedString.execute()).isEqualTo(7);
    }

}