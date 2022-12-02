import React, { Component } from 'react'
import QuestionService from '../services/QuestionService'

class ReadQuestions extends Component {

    constructor(props){
        super(props)
        this.state = {
            questions: []
        }
    }

    componentDidMount(){
        QuestionService.getQuestions()
        .then((res) =>{
            this.setState({questions: res.data});
        });
    }

    render() {
        return (
          <div>
            <h2>Question List</h2>
                <div className='row'>
                    <table className = "table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>QUESTION NUMBER</th>
                                <th>CONTENT</th>
                                <th>ANSWER</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.questions.map(
                                    question =>
                                    <tr key = {question.id}>
                                        <td>{question.id}</td>
                                        <td>{question.questionnumber}</td>
                                        <td>{question.content}</td>
                                        <td></td>
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

export default ReadQuestions;