package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SalesByMatchTest {
    private final SalesByMatch subject = new SalesByMatch();

    @Test
    public void test() {
        assertThat(subject.execute()).isEqualTo(3);
    }
}