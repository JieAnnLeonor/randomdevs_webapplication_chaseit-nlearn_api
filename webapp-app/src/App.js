import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Home from './pages/Home';
import CreateQuiz from './pages/CreateQuiz';
import CreateAnswer from './pages/CreateAnswer';

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path = "/" element={<Home/>}/>
        <Route exact path = "/createquiz" element={<CreateQuiz/>}/>
        <Route exact path = "/createanswer" element={<CreateAnswer/>}/>
      </Routes>
    </Router>
  );
}

/*
<div className="App">
      <header className="App-header">
      <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
*/

/*
<ReadQuizzes/>
<ReadQuestions/>
<ReadAnswers/>
*/

export default App;
