import React, { Component } from 'react'
import AnswerService from '../services/AnswerService';

class CreateAnswers extends Component {
  constructor(props){
    super(props);
    this.onChangeContent = this.onChangeContent.bind(this);
    this.saveAnswer = this.saveAnswer.bind(this);
    this.newAnswer = this.newAnswer.bind(this);

    this.state = {
      content: "",
      submitted: false
    };
  }

  onChangeContent(e){
    this.setState({
      content: e.target.value
    });
  }

  saveAnswer(){
    var data = {
      content: this.state.content
    };

    AnswerService.createAnswer(data).then(
      response => {
        this.setState({
          content: response.data.content,

          submitted: true
        });
      }
    )
  }

  newAnswer(){
    this.setState({
      content: "",

      submitted: false
    });
  }

  render() {
    return (
      <div className='submit-form'>
        {this.state.submitted ? (
          <div>
            <h4>You submitted successfully!</h4>
            <button className="btn btn-success" onClick={this.newAnswer}>
              Add
            </button>
          </div>
        ) : (
          <div>
            <div className="form-group">
              <label htmlFor="content">Content</label>
              <input
                type="text"
                className="form-control"
                id="content"
                required
                value={this.state.content}
                onChange={this.onChangeContent}
                name="content"
              />
            </div>

            <button onClick={this.saveAnswer} className="btn btn-success">
              Submit
            </button>
          </div>
        )}
      </div>
    )
  }
}

export default CreateAnswers;