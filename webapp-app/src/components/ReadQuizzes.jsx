import React, { Component } from 'react'
import QuizService from '../services/QuizService'

class ReadQuizzes extends Component {

    constructor(props){
        super(props)
        this.state = {
            quizzes: []
        }
    }

    componentDidMount(){
        QuizService.getQuizzes()
        .then((res) =>{
            this.setState({quizzes: res.data});
        });
    }

    render() {
        return (
            <div>
            <h2>Quiz List</h2>
                <div className='row'>
                    <table className = "table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>QUIZ NAME</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.quizzes.map(
                                    quiz =>
                                    <tr key = {quiz.id}>
                                        <td>{quiz.id}</td>
                                        <td>{quiz.quizname}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
          </div>
        );
    }
}

export default ReadQuizzes;