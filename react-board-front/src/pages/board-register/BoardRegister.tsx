import React from 'react';
import {Button, Form} from 'react-bootstrap'
import {Board} from "../../domain/Board";
import {request} from "../../api";
import {useNavigate} from "react-router-dom";

const BoardRegister: React.FC = () => {

    const navigate = useNavigate();

    const addBoard = async (board :Board) =>{
        const res = await request('post', '/api/board', board);
        console.log(res);
        navigate("/");
    }

    const handleSubmit = (event :any) =>{
        event.preventDefault();
        const form = event.currentTarget;
        const board = {
            title: form.titleInput.value,
            content: form.contentText.value
        }
        addBoard(board);
    }


    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="titleInput">
                <Form.Label>제목</Form.Label>
                <Form.Control required type="text" placeholder="" />
            </Form.Group>
            <Form.Group controlId="contentText">
                <Form.Label>내용</Form.Label>
                <Form.Control required as="textarea" rows={20} />
            </Form.Group>
            <Button variant="primary" type="submit">
                저장
            </Button>
        </Form>
    );
};

export default BoardRegister;
