create table board
(
    id      int auto_increment
        primary key,
    title   varchar(100)                          null comment '제목',
    content text                                  null comment '내용',
    created timestamp default current_timestamp() null,
    updated timestamp                             null on update current_timestamp()
)
    comment '게시판';


create table comment
(
    id       int auto_increment
        primary key,
    content  text                                  null,
    created  timestamp default current_timestamp() null,
    updated  timestamp                             null on update current_timestamp(),
    board_id int                                   null,
    constraint comment_board_id_fk
        foreign key (board_id) references board (id)
);


// 다시 짜야함
create table File
(
    id            int auto_increment primary key,
    original_name varchar(100)                          null,
    uploadFileName varchar(100)null,
    created       timestamp default current_timestamp() null
);
