package org.exercises.warmup;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SalesByMatchTest {
    private final SalesByMatch salesByMatch = new SalesByMatch();

    @Test
    public void beTested() {
        assertThat(salesByMatch.execute()).isEqualTo(3);
    }
}