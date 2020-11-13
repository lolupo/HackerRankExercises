package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CountingValleysTest {

    private final CountingValleys subject = new CountingValleys();

    @Test
    void test() throws IOException {
        assertThat(subject.execute()).isEqualTo(1);
    }


}