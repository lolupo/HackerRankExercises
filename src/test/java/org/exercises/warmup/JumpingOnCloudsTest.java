package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JumpingOnCloudsTest {

    private final JumpingOnClouds subject = new JumpingOnClouds();

    @Test
    void test() {
        assertThat(subject.execute()).isEqualTo(3);
    }

}