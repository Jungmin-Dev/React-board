package com.example.reactboard.controller;


import com.example.reactboard.domain.board.Board;
import com.example.reactboard.domain.Result;
import com.example.reactboard.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BoardController {

    private final BoardMapper boardMapper;

    @PostMapping("/board")
    public Result insert(@RequestBody Board board) {
        int result = boardMapper.insertBoard(board);
        if (result > 0)
            return new Result(0, "success");
        else
            return new Result(1, "fail");
    }

    @GetMapping("board/{id}")
    public Board findOneBoard(@PathVariable int id) {
        return boardMapper.findOneBoard(id);
    }

    @GetMapping("boards")
    public List<Board> findAllBoard(@RequestParam @Nullable Integer page_number, @RequestParam @Nullable Integer page_size) {

        Integer offset = null;
        if (page_number != null && page_size != null) {
            offset = (page_number - 1) * page_size;
        }
        return boardMapper.findBoard(offset, page_size);
    }

    @GetMapping("/board/count")
    public Integer countBoard() {
        return boardMapper.countBoard();
    }

    @PutMapping("board")
    public Result modifyBoard(@RequestBody Board board) {
        int result = boardMapper.updateBoard(board);
        if (result > 0) {
            return new Result(0, "success");
        } else
            return new Result(100, "fail");
    }

    @DeleteMapping("board")
    public Result deleteBoard(@RequestParam int id) {
        int result = boardMapper.deleteBoard(id);
        if (result > 0) {
            return new Result(0, "success");
        } else
            return new Result(100, "fail");
    }
}
