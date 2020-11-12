package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JumpingOnCloudsTest {

    private final JumpingOnClouds jumpingOnClouds = new JumpingOnClouds();

    @Test
    void beTested() {
        assertThat(jumpingOnClouds.execute()).isEqualTo(3);
    }

}