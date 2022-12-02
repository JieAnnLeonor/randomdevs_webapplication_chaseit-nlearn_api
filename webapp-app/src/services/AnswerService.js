import 'bootstrap/dist/css/bootstrap.min.css';
import http from '../http-common'

class AnswerService{
    getAnswers(){
        return http.get("/answer/getAllAnswers");
    }

    createAnswer(data){
        return http.post("/answer/postAnswer", data);
    }
}

export default new AnswerService();