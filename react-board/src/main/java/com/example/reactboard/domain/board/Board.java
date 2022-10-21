package com.example.reactboard.domain.board;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

// not_null 인 경우만 포함한다는 의미이므로 json을 만들때 property가 null이면 만들지 말라는 의미이다.
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Board {
    private Integer id;
    private String title;
    private String content;
    private String created;
    private String updated;
}
