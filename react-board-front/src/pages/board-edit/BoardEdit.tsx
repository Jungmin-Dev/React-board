import React, {useEffect, useState} from 'react';
import {Button, Form} from "react-bootstrap";
import {useParams, useNavigate} from "react-router-dom";
import {Board} from "../../domain/Board";
import {request} from "../../api";

const BoardEdit = () => {

    const params = useParams();
    const Navigate = useNavigate();
    const [board, setBoard] = useState<Board>({
        title: '',
        content: '',
    });

    useEffect(() => {
        getBoard();
    }, []);

    // 1. 글 작성 폼이랑 비슷하게 만든다.
    // 2. 수정 버튼 누르면 readonly 풀어볼까 ?
    // 3. 수정 버튼 누르면 그대로 수정 요청

    const getBoard = async () =>{
        const res = await request('get', `/api/board/${params.id}`);
        setBoard(res);
    }

    const setField = (field: string, value: string) => {
        setBoard({
            ...board,
            [field]: value,
        })
    }


    const handleSubmit = async (e: any) => {
        e.preventDefault();
        await request('put', `/api/board`, board);
        Navigate('/');
    }

    return (
        <>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="titleInput">
                    <Form.Label>제목</Form.Label>
                    <Form.Control required type="text" value={board.title} onChange={(e)=>{
                        setField("title", e.target.value);
                    }}/>
                </Form.Group>
                <Form.Group controlId="contentText">
                    <Form.Label>내용</Form.Label>
                    <Form.Control required as="textarea" rows={20} value={board.content} onChange={(e) => {
                        setField("content", e.target.value);
                    }}/>
                </Form.Group>
                <Button variant="primary" type="submit" >
                    저장
                </Button>
            </Form>
        </>
    );
};

export default BoardEdit;
