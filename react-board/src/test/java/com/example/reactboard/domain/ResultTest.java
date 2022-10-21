package com.example.reactboard.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ResultTest {

    @Test
    public void ResultTest(){
        Result result = new Result(0, "test");

        Assertions.assertThat(result.getCode()).isEqualTo(0);
    }
}
