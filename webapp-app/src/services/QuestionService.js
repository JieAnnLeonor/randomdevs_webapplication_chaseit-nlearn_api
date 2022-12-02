import 'bootstrap/dist/css/bootstrap.min.css';
import http from '../http-common'

class QuestionService{
    getQuestions(){
        return http.get("/question/getAllQuestions");
    }

    createQuestion(data){
        return http.post("/answer/postQuestion");
    }
}

export default new QuestionService();