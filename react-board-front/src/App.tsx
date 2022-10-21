import React from 'react';
import './App.css';
import Container from "react-bootstrap/Container";
import BoardList from "./pages/board-list/BoardList"
import BoardRegister from "./pages/board-register/BoardRegister"
import {BrowserRouter, Route, Routes} from "react-router-dom";
import BoardView from "./pages/board-list/BoardView";

function App() {
    return (
        <Container className="p-3">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<BoardList/>}></Route>
                    <Route path="/board-register" element={<BoardRegister/>}></Route>
                    <Route path={"/board-view/:id"} element={<BoardView/>}></Route>
                </Routes>
            </BrowserRouter>
        </Container>
    );
}

export default App;
