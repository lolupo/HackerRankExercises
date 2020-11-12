package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CountingValleysTest {

    private final CountingValleys countingValleys = new CountingValleys();

    @Test
    void beTested() throws IOException {
        assertThat(countingValleys.execute()).isEqualTo(1);
    }


}