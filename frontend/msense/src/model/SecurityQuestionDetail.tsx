import Cloneable from "./interface/Cloneable";
import Validatable from "./interface/Validatable";

class SecurityQuestionDetail implements Cloneable, Validatable {
    question: string;
    answer: string;

    constructor(question?: string, answer?: string) {
        this.question = question || "";
        this.answer = answer || "";
    }

    getQuestion = () => this.question;
    getAnswer = () => this.answer;

    setQuestion = (question: string) => this.question = question;
    setAnswer = (answer: string) => this.answer = answer;

    isQuestionValid = () => this.question.length > 0;
    isAnswerValid = () => this.answer.length > 0;

    set = (property: string, value: string) => (property.match("question") && this.setQuestion(value)) || (property.match("answer") && this.setAnswer(value));
    clone = () => (new SecurityQuestionDetail(this.question, this.answer) as this);
    isValid = () => this.isQuestionValid() && this.isAnswerValid();
}

export default SecurityQuestionDetail;