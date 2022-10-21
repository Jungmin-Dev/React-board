import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import {Board} from "../../domain/Board";
import {request} from "../../api";
import {Card} from "react-bootstrap";

const BoardView = () => {

    const param = useParams();

    const [board, setBoard] = useState<Board>({
        title: '',
        content: '',
    });

    const getBoard = async (id?: string)=>{
        const res = await request('get', `/api/board/${id}`);
        setBoard(res);
    }

    useEffect(()=>{
    getBoard(param.id)
    }, [])

    return (
        <>
            <Card>
                <Card.Title>{board?.title}</Card.Title>
                <Card.Text>
                    {board?.content}
                </Card.Text>
            </Card>
        </>
    );
};

export default BoardView;
