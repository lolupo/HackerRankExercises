package org.exercises.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeftRotationArrayTest {
    private final LeftRotationArray subject = new LeftRotationArray();

    @Test
    public void test() {
        assertThat(subject.execute()).isEqualTo("5 1 2 3 4");
    }

}