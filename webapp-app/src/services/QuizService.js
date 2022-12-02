import 'bootstrap/dist/css/bootstrap.min.css';
import http from '../http-common'

class QuizService{
    getQuizzes(){
        return http.get("/quiz/getAllQuizzes");
    }

    createAnswer(data){
        return http.post("/quiz/postQuiz");
    }
}

export default new QuizService();