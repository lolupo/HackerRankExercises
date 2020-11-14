package org.exercises.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewYearChaosTest {

    private final NewYearChaos subject = new NewYearChaos();

    @Test
    public void test() {
        assertThat(subject.execute()).isEqualTo("3_Too chaotic");
    }

}