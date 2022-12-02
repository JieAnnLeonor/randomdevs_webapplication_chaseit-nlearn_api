import React, { Component } from 'react'
import AnswerService from '../services/AnswerService';

class ReadAnswers extends Component {

    constructor(props){
        super(props)
        this.state = {
            answers: []
        }
    }

    componentDidMount(){
        AnswerService.getAnswers()
        .then((res) =>{
            this.setState({answers: res.data});
        });
    }

    render(){
        return (
            <div>
                <h2>Answer List</h2>
                <div className='row'>
                    <table className = "table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>CONTENT</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.answers.map(
                                    answer =>
                                    <tr key = {answer.id}>
                                        <td>{answer.id}</td>
                                        <td>{answer.content}</td>
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

export default ReadAnswers;