package com.example.reactboard.mappers;

import com.example.reactboard.domain.board.Board;

import java.util.List;

public interface BoardMapper {
    int insertBoard(Board board);
    List<Board> findBoard(Integer offset, Integer page_size);
    Board findOneBoard(int id);
    int countBoard();
    int updateBoard(Board board);
    int deleteBoard(int id);
}
