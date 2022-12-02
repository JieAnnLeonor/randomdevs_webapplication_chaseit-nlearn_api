import React from 'react'
import {useNavigate} from "react-router-dom"

function CreateQuiz(){
  let navigate = useNavigate();

  return (
    <div className="App">
      <header className="App-header">
        <h2>Making Quiz (not done)</h2>
        <button onClick={() =>{
          navigate("/createanswer");
        }}>
          Make Answer
        </button>
        <button onClick={() =>{
          navigate("/");
        }}>
          Finish Quiz
        </button>
      </header>
    </div>
  );
}

export default CreateQuiz;