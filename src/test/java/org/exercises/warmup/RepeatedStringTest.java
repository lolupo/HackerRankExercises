package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RepeatedStringTest {

    private final RepeatedString subject = new RepeatedString();

    @Test
    void test() {
        assertThat(subject.execute()).isEqualTo(7);
    }

}