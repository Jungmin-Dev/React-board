package com.example.reactboard.mappers;

import com.example.reactboard.domain.board.Comment;

import java.util.List;

public interface CommentMapper {
    int insertComment(Comment comment);
    Comment findOneComment(int id);
    List<Comment> findComment(int board_id);
    int updateComment(Comment comment);
    int deleteComment(int id);
}
