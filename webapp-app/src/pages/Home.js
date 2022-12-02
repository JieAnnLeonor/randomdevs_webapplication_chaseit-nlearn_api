import React from 'react'
import {useNavigate} from "react-router-dom"
import ReadAnswers from '../components/ReadAnswers';
import ReadQuestions from '../components/ReadQuestions';
import ReadQuizzes from '../components/ReadQuizzes';

function Home(){
    let navigate = useNavigate();

    return (
        <div className="App">
            <header className="App-header">
                <h1>Quiz Stuff</h1>
                <button onClick={() =>{
                    navigate("/createquiz");
                }}>
                    Make Quiz
                </button>
                <ReadAnswers/>
                <ReadQuestions/>
                <ReadQuizzes/>
            </header>
        </div>
    );
}

export default Home;