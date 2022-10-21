import React, {useEffect, useState} from 'react';
import {request} from "../../api";
import {Board} from "../../domain/Board";
import {Button, Col, Row} from "react-bootstrap";
import './BoardList.scss'
import {useNavigate} from "react-router-dom";

const BoardList: React.FC = (props: any) => {
    const [boardList, setBoardList] = useState<Array<Board>>([]);

    const navigate = useNavigate();

    useEffect(() => {
        getBoardList();
    }, [])

    const getBoardList = async () => {
        const res = await request('get', '/api/boards');
        setBoardList(res);
    }

    const createBoard = () => {
        navigate(`/board-register`)
    }

    return (
        <>
            <Row className={"mb-3 justify-content-end"}>
                <Col xs={"auto"} sm={"auto"}>
                    <Button onClick={createBoard}>등 록</Button>
                </Col>
            </Row>
            {
                boardList.map((board: Board) =>
                    <Row key={board.id} className="py-2 board" onClick={()=>{
                        navigate(`/board-view/${board.id}`)
                    }}>
                        <Col>{board.title}</Col>
                        <Col xs="auto" sm="auto">{board.created}</Col>
                    </Row>)
            }

        </>
    );
};

export default BoardList;
