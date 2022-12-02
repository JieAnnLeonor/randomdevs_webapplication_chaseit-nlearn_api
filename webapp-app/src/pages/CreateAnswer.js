import React from 'react'
import {useNavigate} from "react-router-dom"
import CreateAnswers from '../components/CreateAnswers';

function CreateAnswer(){
  let navigate = useNavigate();

  return (
    <div className="App">
      <header className="App-header">
        <h2>Making Answer</h2>
        <CreateAnswers/>
        <button onClick={() =>{
          navigate("/createquiz");
        }}>
          Finish Answer
        </button>
      </header>
    </div>
  );
}

export default CreateAnswer;